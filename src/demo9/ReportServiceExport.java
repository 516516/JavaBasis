package demo9;


package demo9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haiziwang.platform.appclient.api.AppEnvirement;
import com.haiziwang.platform.cusreport.web.constant.Constant;
import com.haiziwang.platform.cusreport.web.dbo.DatabasePermissionsRequest;
import com.haiziwang.platform.cusreport.web.dbo.MetaLabelsBean;
import com.haiziwang.platform.cusreport.web.dbo.Report;
import com.haiziwang.platform.cusreport.web.dbo.ReportSql;
import com.haiziwang.platform.cusreport.web.dbo.SystemPermissionsResponse;
import com.haiziwang.platform.cusreport.web.dbo.TablePermissionsRequest;
import com.haiziwang.platform.cusreport.web.svc.api.IApiService;
import com.haiziwang.platform.cusreport.web.svc.api.IReportService;
import com.haiziwang.platform.cusreport.web.svc.api.IRpmsService;
import com.haiziwang.platform.cusreport.web.util.CollectionUtil;
import com.haiziwang.platform.cusreport.web.util.CurrentUserHelper;
import com.haiziwang.platform.cusreport.web.util.CurrentUserHelper.LoginUserInfo;
import com.haiziwang.platform.cusreport.web.util.JSONUtil;
import com.haiziwang.platform.cusreport.web.util.Request;
import com.haiziwang.platform.cusreport.web.util.Response;
import com.haiziwang.platform.freemaker.FreeMakerParser;
import com.haiziwang.platform.spliceSql.SpliceSqlKit2;

import net.jplugin.common.kits.StringKit;
import net.jplugin.common.kits.http.HttpKit;
import net.jplugin.core.ctx.api.RuleServiceFactory;
import net.jplugin.core.das.api.PageCond;
import net.jplugin.core.kernel.api.PluginEnvirement;
import net.jplugin.core.rclient.api.RemoteExecuteException;
import net.jplugin.core.rclient.proxyfac.ClientProxyFactory;
import net.jplugin.ext.webasic.api.Para;

/**
 * @author 2016年5月3日
 */

public class ReportServiceExport {

    // add customer report 新增定制报表
    public IReportService reportService = RuleServiceFactory.getRuleService(IReportService.class);

    public HashMap<String, Object> addCustomerReport(@Para(name = "reportMap") HashMap<String, String> reportMap) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        List<ReportSql> reportSqls = new ArrayList<ReportSql>();
        Report report = new Report();
        // 判空(属性值)
        if (StringUtils.isAnyBlank(reportMap.get("reportCode"), reportMap.get("reportName"), reportMap.get("sourceType"), reportMap.get("htmlType"), reportMap.get("htmlUrl"),
                reportMap.get("subjectCode"))) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "params is null or empty..."); // 包装错误代码
        }
        if (reportMap.get("sourceType") == "1" && reportMap.get("sqlContentJson").equals("[]")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "sql脚本不能为空"); // 包装错误代码
        }
        if (reportMap.get("sourceType") == "2" && reportMap.get("javaScript").equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "java脚本不能为空"); // 包装错误代码
        }
        if (reportMap.get("htmlType") == "1" && reportMap.get("sqlFilePath").equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "前端资源文件不能为空"); // 包装错误代码
        }
        if (reportMap.get("htmlType") == "2" && reportMap.get("htmlText").equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "html文本不能为空"); // 包装错误代码
        }

        report.setReportCode(StringKit.trim(reportMap.get("reportCode")));
        report.setReportName(StringKit.trim(reportMap.get("reportName")));
        report.setSourceType(Integer.valueOf(reportMap.get("sourceType")));
        report.setResourceUrl(StringKit.trim(reportMap.get("sqlFilePath")));
        report.setFileName(StringKit.trim(reportMap.get("sqlFileName")));
        report.setHtmlType(Integer.valueOf(reportMap.get("htmlType")));
        report.setHtmlText(StringKit.trim(reportMap.get("htmlText")));
        report.setMobileText(StringKit.trim(reportMap.get("mobileText")));
        report.setReportType(Integer.valueOf(reportMap.get("reportType")));
        report.setHtmlUrl(StringKit.trim(reportMap.get("htmlUrl")));

        // 将业务主题插入到业务表中
        String subjectCodeStr = reportMap.get("subjectCode");
        report.setSubjectCode(subjectCodeStr);
        report.setStatus("0");
        report.setCompareStatus("0");
        LoginUserInfo loginUserInfo = CurrentUserHelper.getLoginUserInfo();
        String loginName = loginUserInfo.loginName;
        if (loginName == null || loginName.equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "身份已过期 , 请重新登录...");
        }
        report.setCreatorNo(loginUserInfo.loginName);
        report.setCreator(loginUserInfo.userName);
        report.setUpdaterNo(loginUserInfo.loginName);
        report.setUpdater(loginUserInfo.userName);

        // 获取sql脚本或者java 脚本
        if (report.getSourceType() == 1) {
            String sqlContent = reportMap.get("sqlContentJson");
            reportSqls = JSONObject.parseArray(sqlContent, ReportSql.class);
            // querymap.put("sqlList", reportSqls);
            report.setJavaScript("");
            // 先进行sql的表权限校验
            for (int i = 0; i < reportSqls.size(); i++) {
                if (reportSqls.get(i).getSqlType() == 1) {
                    String dbsql = reportSqls.get(i).getSqlText();
                    dbsql = SpliceSqlKit2.formatSql(dbsql);
                    DatabasePermissionsRequest request = new DatabasePermissionsRequest();
                    request.setAppCode(reportSqls.get(i).getReportCode());
                    request.setSourceCode(reportSqls.get(i).getDataSource());
                    request.setSql(dbsql);
                    request.setDatabaseName("");
                    request.setUserCode(report.getCreatorNo());
                    SystemPermissionsResponse response = ClientProxyFactory.instance.getClientProxy(IRpmsService.class).checkDbPermissionsByUserCode(request);
                    if (!response.isHasPermissions()) {
                        throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, reportSqls.get(i).getDsCode() + "权限校验失败:" + response.getErrorMessage() + ",请先申请表权限");
                    }
                }else {
                    String dsCode = reportSqls.get(i).getDataSource();
                    String dbsql = reportSqls.get(i).getSqlText();
                    Set<String> tables = null;
                    try {
                        tables = FreeMakerParser.parserTables(dbsql);
                    }catch (Exception e) {
                        throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, reportSqls.get(i).getDsCode() + "SQL解析失败:" + e.getMessage());
                    }
                    if (tables != null && tables.size() > 0) {
                        TablePermissionsRequest request = new TablePermissionsRequest();
                        request.setUserCode(report.getCreatorNo());
                        Map<String, Set<String>> tableMap = new HashMap<String, Set<String>>();
                        tableMap.put(dsCode, tables);
                        request.setTableMap(tableMap);
                        SystemPermissionsResponse response = ClientProxyFactory.instance.getClientProxy(IRpmsService.class).checkTablePermissionsByUserCode(request);
                        if (!response.isHasPermissions()) {
                            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, reportSqls.get(i).getDsCode() + "权限校验失败:" + response.getErrorMessage() + ",请先申请表权限");
                        }
                    }
                }
            }
        }else {
            report.setJavaScript(StringKit.trim(reportMap.get("javaScript")));
        }

        int result = reportService.addReport(report, reportSqls);
        if (result < 0) {
            throw new RemoteExecuteException(Constant.Code.INSERT_ERROR, "数据插入失败..."); // 包装错误代码
        }
        
        
        deploy(report.getReportCode(),"0");
        
        map.put("code", Constant.Code.OPERATE_SUCCESS);
        return map;

    }

    // 报表更新
    public HashMap<String, Object> updateCustomerReport(@Para(name = "reportMap") HashMap<String, String> reportMap) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        Report report = new Report();
        List<ReportSql> reportSqls = new ArrayList<ReportSql>();
        // 判空(属性值)
        if (StringUtils.isAnyBlank(reportMap.get("reportCode"), reportMap.get("reportName"), reportMap.get("sourceType"), reportMap.get("htmlType"), reportMap.get("htmlUrl"),
                reportMap.get("subjectCode"))) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "params is null or empty..."); // 包装错误代码
        }
        if (reportMap.get("sourceType") == "1" && reportMap.get("sqlContentJson").equals("[]")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "sql脚本不能为空"); // 包装错误代码
        }
        if (reportMap.get("sourceType") == "2" && reportMap.get("javaScript").equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "java脚本不能为空"); // 包装错误代码
        }
        if (reportMap.get("htmlType") == "1" && reportMap.get("sqlFilePath").equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "前端资源文件不能为空"); // 包装错误代码
        }
        if (reportMap.get("htmlType") == "2" && reportMap.get("htmlText").equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "html文本不能为空"); // 包装错误代码
        }
        String compareStatus = StringKit.trim(reportMap.get("compareStatus"));
        if (compareStatus.equals("1")) {
            report.setCompareStatus("2");
        }
        report.setReportCode(StringKit.trim(reportMap.get("reportCode")));
        report.setReportName(StringKit.trim(reportMap.get("reportName")));
        report.setSourceType(Integer.valueOf(reportMap.get("sourceType")));
        report.setHtmlType(Integer.valueOf(reportMap.get("htmlType")));
        report.setHtmlText(StringKit.trim(reportMap.get("htmlText")));
        report.setResourceUrl(StringKit.trim(reportMap.get("sqlFilePath")));
        report.setFileName(StringKit.trim(reportMap.get("sqlFileName")));
        report.setHtmlUrl(StringKit.trim(reportMap.get("htmlUrl")));
        report.setMobileText(StringKit.trim(reportMap.get("mobileText")));
        report.setReportType(Integer.valueOf(reportMap.get("reportType")));
        // 将业务主题插入到业务表中
        String subjectCodeStr = reportMap.get("subjectCode");
        report.setSubjectCode(subjectCodeStr);
        LoginUserInfo loginUserInfo = CurrentUserHelper.getLoginUserInfo();
        String loginName = loginUserInfo.loginName;
        if (loginName == null || loginName.equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "身份已过期 , 请重新登录...");
        }
        report.setUpdaterNo(loginUserInfo.loginName);
        report.setUpdater(loginUserInfo.userName);

        // 获取sql脚本或者java 脚本
        if (report.getSourceType() == 1) {
            String sqlContent = reportMap.get("sqlContentJson");
            reportSqls = JSONObject.parseArray(sqlContent, ReportSql.class);
            // 先进行sql的表权限校验
            for (int i = 0; i < reportSqls.size(); i++) {
                if (reportSqls.get(i).getSqlType() == 1) {
                    String dbsql = reportSqls.get(i).getSqlText();
                    dbsql = SpliceSqlKit2.formatSql(dbsql);
                    DatabasePermissionsRequest request = new DatabasePermissionsRequest();
                    request.setAppCode(reportSqls.get(i).getReportCode());
                    request.setSourceCode(reportSqls.get(i).getDataSource());
                    request.setSql(dbsql);
                    request.setDatabaseName("");
                    request.setUserCode(report.getUpdaterNo());
                    SystemPermissionsResponse response = ClientProxyFactory.instance.getClientProxy(IRpmsService.class).checkDbPermissionsByUserCode(request);
                    if (!response.isHasPermissions()) {
                        throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, reportSqls.get(i).getDsCode() + "权限校验失败:" + response.getErrorMessage() + ",请先申请表权限");
                    }
                }else {
                    String dsCode = reportSqls.get(i).getDataSource();
                    String dbsql = reportSqls.get(i).getSqlText();
                    Set<String> tables = null;
                    try {
                        tables = FreeMakerParser.parserTables(dbsql);
                    }catch (Exception e) {
                        throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, reportSqls.get(i).getDsCode() + "SQL解析失败:" + e.getMessage());
                    }
                    if (tables != null && tables.size() > 0) {
                        TablePermissionsRequest request = new TablePermissionsRequest();
                        request.setUserCode(report.getUpdaterNo());
                        Map<String, Set<String>> tableMap = new HashMap<String, Set<String>>();
                        tableMap.put(dsCode, tables);
                        request.setTableMap(tableMap);

                        SystemPermissionsResponse response = ClientProxyFactory.instance.getClientProxy(IRpmsService.class).checkTablePermissionsByUserCode(request);
                        if (!response.isHasPermissions()) {
                            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, reportSqls.get(i).getDsCode() + "权限校验失败:" + response.getErrorMessage() + ",请先申请表权限");
                        }
                    }
                }
            }

        }else {
            report.setJavaScript(StringKit.trim(reportMap.get("javaScript")));
        }

        int result = reportService.updateReport(report, reportSqls);
        if (result < 0) {
            throw new RemoteExecuteException(Constant.Code.INSERT_ERROR, "数据插入失败..."); // 包装错误代码
        }
        String editResouseFile = reportMap.get("editResouseFile");
         
        if(editResouseFile.equals("0") || report.getHtmlType()==2){
            deploy(report.getReportCode(),"0");
        }
        map.put("code", Constant.Code.OPERATE_SUCCESS);
        return map;
    }

    // 报表查询
    public HashMap<String, Object> queryList(@Para(name = "queryCond") HashMap<String, String> queryCond, @Para(name = "pageCond") PageCond pageCond) throws Exception {
        String loginName = CurrentUserHelper.getLoginUserInfo().loginName;
        if (loginName == null || loginName.equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "身份已过期,请重新登录...");
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        queryCond.put("creatorNo", loginName);// 只能查看自己提交的发布单
        List<Report> list = reportService.queryReportWithPage(queryCond, pageCond);
        hashMap.put("list", list);
        hashMap.put("pc", pageCond);
        return hashMap;

    }

    // 报表code list 查询
    public HashMap<String, Object> queryReportCode(@Para(name = "param") String param) throws Exception {
        HashMap<String, String> queryCond = new HashMap<>();
        HashMap<String, Object> hashMap = new HashMap<>();
        String loginName = CurrentUserHelper.getLoginUserInfo().loginName;
        if (loginName == null || loginName.equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "身份已过期,请重新登录...");
        }
        if (!param.equals("admin")) {

            queryCond.put("creatorNo", loginName);// 只能查看自己申请的报表
        }

        List<Report> list = reportService.queryReportCode(queryCond);
        hashMap.put("list", list);
        return hashMap;

    }

    // 报表查询(管理员)
    public HashMap<String, Object> queryAllList(@Para(name = "queryCond") HashMap<String, String> queryCond, @Para(name = "pageCond") PageCond pageCond) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<>();
        List<Report> list = reportService.queryAllReportWithPage(queryCond, pageCond);
        hashMap.put("list", list);
        hashMap.put("pc", pageCond);
        return hashMap;

    }

    // 线上报表查询(管理员)
    public HashMap<String, Object> queryOnlineList(@Para(name = "queryCond") HashMap<String, String> queryCond, @Para(name = "pageCond") PageCond pageCond) throws Exception {
        String loginName = CurrentUserHelper.getLoginUserInfo().loginName;
        if (loginName == null || loginName.equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "身份已过期,请重新登录...");
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        List<Report> list = reportService.queryOnlineReportWithPage(queryCond, pageCond);
        hashMap.put("list", list);
        hashMap.put("pc", pageCond);
        return hashMap;

    }

    // 根据reportCode删除报表以及相关所有项
    public HashMap<String, Object> delReport(@Para(name = "queryCond") Report report) throws Exception {

        HashMap<String, Object> map = new HashMap<>();
        // 判断下该报表是否申请过表权限，如申请过表权限，则不能进行删除操作
        HashMap<String, String> queryCond = new HashMap<String, String>();
        queryCond.put("reportCode", report.getReportCode());
        int result = reportService.delReport(report);
        if (result > 0) {
            map.put("code", Constant.Code.OPERATE_SUCCESS);
        }
        return map;
    }

    // 根据reportCode管理报表（申请，发布，下线）
    public HashMap<String, Object> manageReport(@Para(name = "queryCond") HashMap<String, String> queryCond) throws Exception {

        HashMap<String, Object> map = new HashMap<>();
        // HashMap<String, Object> queryMap = new HashMap<String, Object>();
        String status = queryCond.get("status");
        int result = 0;
        // 如果是发布到线上，则需要同步数据到stable表中
        if (status.equals("3") && queryCond.get("flag") == null) {

            // 根据code 拿到report对象
            Report report = reportService.queryReportByCode(queryCond);
            report.setStatus(status);
            report.setCompareStatus("1");

            List<ReportSql> reportSqls = reportService.getReportSql(queryCond);
            // 首先删除stable 表中原来的数据
            // queryMap.put("sqlList", reportSqls);
            // queryMap.put("Report", report);
            result = reportService.updateOnlineReport(report, reportSqls);
            if (result > 0) {
                // 解压文件（有报错就抛出去了）
                decompressFile(queryCond);
            }

        }
        // 如果是从发布状态到下线状态吗，则线上和开发表中的状态都要更新
        else if (status.equals("4") || queryCond.get("flag") != null) {
            reportService.manageOnlineReport(queryCond);
            result = reportService.manageReport(queryCond);
        }else {
            result = reportService.manageReport(queryCond);
        }
        if (result > 0) {

            map.put("code", Constant.Code.OPERATE_SUCCESS);
        }
        return map;
    }

    // 根据reportCode查询报表的sql
    public HashMap<String, Object> getReportSql(@Para(name = "queryCond") HashMap<String, String> queryCond) throws Exception {

        HashMap<String, Object> map = new HashMap<>();
        List<ReportSql> reportSqls = reportService.getReportSql(queryCond);
        map.put("list", reportSqls);
        return map;
    }

    // 更新报表维护人(管理员操作)
    public HashMap<String, Object> updateOwner(@Para(name = "reportMap") HashMap<String, String> reportMap) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        List<ReportSql> reportSqls = new ArrayList<ReportSql>();
        Report report = new Report();
        // 判空(属性值)
        if (StringUtils.isAnyBlank(reportMap.get("reportCode"), reportMap.get("creatorNo"), reportMap.get("creator"))) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "params is null or empty..."); // 包装错误代码
        }

        report.setReportCode(StringKit.trim(reportMap.get("reportCode")));
        LoginUserInfo loginUserInfo = CurrentUserHelper.getLoginUserInfo();
        String loginName = loginUserInfo.loginName;
        if (loginName == null || loginName.equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "身份已过期 , 请重新登录...");
        }
        report.setCreatorNo(StringKit.trim(reportMap.get("creatorNo")));
        report.setCreator(StringKit.trim(reportMap.get("creator")));
        int result = reportService.updateReport(report, reportSqls);
        if (result < 0) {
            throw new RemoteExecuteException(Constant.Code.INSERT_ERROR, "数据更新失败..."); // 包装错误代码
        }
        
        map.put("code", Constant.Code.OPERATE_SUCCESS);
        return map;

    }

    /**
     * 查询业务主题标签
     * @return MetaLabelsBean
     */
    public List<MetaLabelsBean> getLabelsList() {
        List<MetaLabelsBean> result = CollectionUtil.newArrayList();
        Map<String, Object> map = new HashMap<>();
        try {
            String post = HttpKit.post(Constant.SUBJECT_URL + "getLabelsByGroupId.do?groupid=65598016eb7744e2beae72a276a3ef34", map);
            JSONArray array = JSON.parseArray(getContent(post));
            array.stream().map(obj -> JSONObject.parseObject(obj.toString(), MetaLabelsBean.class)).forEach(result::add);
        }catch (Exception e) {
            // log.error("获取业务主题标签异常！", e);
        }
        return result;
    }

    private String getContent(String json) {
        String s = "";
        JSONObject object = JSONUtil.getJSONFromString(json);
        Boolean success = object.getBoolean("success");
        if (success) {
            JSONObject content = JSONUtil.getJSONFromString(object.get("content").toString());
            JSONArray result = JSON.parseArray(content.get("result").toString());
            s = result.toJSONString();
        }
        return s;
    }

    // 查询数据通道数据源
    public HashMap<String, Object> getDataSource() {
        HashMap<String, Object> map = new HashMap<>();
        PluginEnvirement.getInstance().startup();
        try {
            IApiService apiService = ClientProxyFactory.instance.getClientProxy(IApiService.class);
            Response dataSource = apiService.getDataSource(new Request());
            map.put("dataSource", dataSource);
            // log.debug("数据源:{}", dataSource.toString());
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return map;
    }

    // 调用引擎分发到两台机器上
    public HashMap<String, Object> decompressFile(@Para(name = "queryCond") HashMap<String, String> queryCond) {
        if (StringUtils.isAnyBlank(queryCond.get("reportCode"), queryCond.get("mode"))) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "解压参数为空 "); // 包装错误代码
        }

        // String fileUrl =
        // AppEnvirement.INSTANCE.getEnvConfiguration("custom.report.show.url");
        String fileUrl = "http://test.report.haiziwang.com:25702";

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", Constant.Code.OPERATE_SUCCESS);
        map.put("url", fileUrl);
        if(!queryCond.get("mode").equals("0")){
        	 JSONObject contentJson = deploy(queryCond.get("reportCode"),queryCond.get("mode"));
             map.put("ts", contentJson.getString("result"));
        }
        return map;
    }
    
    
    private JSONObject deploy(String reportCode,String mode){
    	
    	// String server =
        // AppEnvirement.INSTANCE.getEnvConfiguration("custom.report.server");
       

        String server = "http://test.report.haiziwang.com:25702";

        String[] serverUrl = server.split(",");
        JSONObject contentJson = new JSONObject();
        for (int i = 0; i < serverUrl.length; i++) {
            String url = serverUrl[i] + "/deploy/deploy.do?reportCode=" + reportCode + "&mode=" + mode;
            String resutString;
            try {

                resutString = HttpKit.get(url);
                JSONObject parseObject = JSON.parseObject(resutString);
                String content = parseObject.getString("content");
                contentJson = JSON.parseObject(content);
                boolean falg = parseObject.getBooleanValue("success");
                if (!falg) {
                    throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "服务器:" + serverUrl[i] + "报表部署发生异常，服务端故障，请稍后重试或联系技术人员: 异常信息:" + parseObject.getString("msg"));
                }
            }catch (Exception e) {
                throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, e.getMessage());
            }

        }
        return contentJson;
    }

    // 调用引擎分发到两台机器上
    public HashMap<String, Object> getEnvConfigUrl(@Para(name = "url") String url) {
        try {
            String envUrl = AppEnvirement.INSTANCE.getEnvConfiguration(url);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", Constant.Code.OPERATE_SUCCESS);
            map.put("url", envUrl);
            return map;
        }catch (Exception e) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, e.getMessage());
        }
    }
    
}
