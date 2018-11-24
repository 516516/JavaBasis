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
 * @author 2016��5��3��
 */

public class ReportServiceExport {

    // add customer report �������Ʊ���
    public IReportService reportService = RuleServiceFactory.getRuleService(IReportService.class);

    public HashMap<String, Object> addCustomerReport(@Para(name = "reportMap") HashMap<String, String> reportMap) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        List<ReportSql> reportSqls = new ArrayList<ReportSql>();
        Report report = new Report();
        // �п�(����ֵ)
        if (StringUtils.isAnyBlank(reportMap.get("reportCode"), reportMap.get("reportName"), reportMap.get("sourceType"), reportMap.get("htmlType"), reportMap.get("htmlUrl"),
                reportMap.get("subjectCode"))) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "params is null or empty..."); // ��װ�������
        }
        if (reportMap.get("sourceType") == "1" && reportMap.get("sqlContentJson").equals("[]")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "sql�ű�����Ϊ��"); // ��װ�������
        }
        if (reportMap.get("sourceType") == "2" && reportMap.get("javaScript").equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "java�ű�����Ϊ��"); // ��װ�������
        }
        if (reportMap.get("htmlType") == "1" && reportMap.get("sqlFilePath").equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "ǰ����Դ�ļ�����Ϊ��"); // ��װ�������
        }
        if (reportMap.get("htmlType") == "2" && reportMap.get("htmlText").equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "html�ı�����Ϊ��"); // ��װ�������
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

        // ��ҵ��������뵽ҵ�����
        String subjectCodeStr = reportMap.get("subjectCode");
        report.setSubjectCode(subjectCodeStr);
        report.setStatus("0");
        report.setCompareStatus("0");
        LoginUserInfo loginUserInfo = CurrentUserHelper.getLoginUserInfo();
        String loginName = loginUserInfo.loginName;
        if (loginName == null || loginName.equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "����ѹ��� , �����µ�¼...");
        }
        report.setCreatorNo(loginUserInfo.loginName);
        report.setCreator(loginUserInfo.userName);
        report.setUpdaterNo(loginUserInfo.loginName);
        report.setUpdater(loginUserInfo.userName);

        // ��ȡsql�ű�����java �ű�
        if (report.getSourceType() == 1) {
            String sqlContent = reportMap.get("sqlContentJson");
            reportSqls = JSONObject.parseArray(sqlContent, ReportSql.class);
            // querymap.put("sqlList", reportSqls);
            report.setJavaScript("");
            // �Ƚ���sql�ı�Ȩ��У��
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
                        throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, reportSqls.get(i).getDsCode() + "Ȩ��У��ʧ��:" + response.getErrorMessage() + ",���������Ȩ��");
                    }
                }else {
                    String dsCode = reportSqls.get(i).getDataSource();
                    String dbsql = reportSqls.get(i).getSqlText();
                    Set<String> tables = null;
                    try {
                        tables = FreeMakerParser.parserTables(dbsql);
                    }catch (Exception e) {
                        throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, reportSqls.get(i).getDsCode() + "SQL����ʧ��:" + e.getMessage());
                    }
                    if (tables != null && tables.size() > 0) {
                        TablePermissionsRequest request = new TablePermissionsRequest();
                        request.setUserCode(report.getCreatorNo());
                        Map<String, Set<String>> tableMap = new HashMap<String, Set<String>>();
                        tableMap.put(dsCode, tables);
                        request.setTableMap(tableMap);
                        SystemPermissionsResponse response = ClientProxyFactory.instance.getClientProxy(IRpmsService.class).checkTablePermissionsByUserCode(request);
                        if (!response.isHasPermissions()) {
                            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, reportSqls.get(i).getDsCode() + "Ȩ��У��ʧ��:" + response.getErrorMessage() + ",���������Ȩ��");
                        }
                    }
                }
            }
        }else {
            report.setJavaScript(StringKit.trim(reportMap.get("javaScript")));
        }

        int result = reportService.addReport(report, reportSqls);
        if (result < 0) {
            throw new RemoteExecuteException(Constant.Code.INSERT_ERROR, "���ݲ���ʧ��..."); // ��װ�������
        }
        
        
        deploy(report.getReportCode(),"0");
        
        map.put("code", Constant.Code.OPERATE_SUCCESS);
        return map;

    }

    // �������
    public HashMap<String, Object> updateCustomerReport(@Para(name = "reportMap") HashMap<String, String> reportMap) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        Report report = new Report();
        List<ReportSql> reportSqls = new ArrayList<ReportSql>();
        // �п�(����ֵ)
        if (StringUtils.isAnyBlank(reportMap.get("reportCode"), reportMap.get("reportName"), reportMap.get("sourceType"), reportMap.get("htmlType"), reportMap.get("htmlUrl"),
                reportMap.get("subjectCode"))) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "params is null or empty..."); // ��װ�������
        }
        if (reportMap.get("sourceType") == "1" && reportMap.get("sqlContentJson").equals("[]")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "sql�ű�����Ϊ��"); // ��װ�������
        }
        if (reportMap.get("sourceType") == "2" && reportMap.get("javaScript").equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "java�ű�����Ϊ��"); // ��װ�������
        }
        if (reportMap.get("htmlType") == "1" && reportMap.get("sqlFilePath").equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "ǰ����Դ�ļ�����Ϊ��"); // ��װ�������
        }
        if (reportMap.get("htmlType") == "2" && reportMap.get("htmlText").equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "html�ı�����Ϊ��"); // ��װ�������
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
        // ��ҵ��������뵽ҵ�����
        String subjectCodeStr = reportMap.get("subjectCode");
        report.setSubjectCode(subjectCodeStr);
        LoginUserInfo loginUserInfo = CurrentUserHelper.getLoginUserInfo();
        String loginName = loginUserInfo.loginName;
        if (loginName == null || loginName.equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "����ѹ��� , �����µ�¼...");
        }
        report.setUpdaterNo(loginUserInfo.loginName);
        report.setUpdater(loginUserInfo.userName);

        // ��ȡsql�ű�����java �ű�
        if (report.getSourceType() == 1) {
            String sqlContent = reportMap.get("sqlContentJson");
            reportSqls = JSONObject.parseArray(sqlContent, ReportSql.class);
            // �Ƚ���sql�ı�Ȩ��У��
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
                        throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, reportSqls.get(i).getDsCode() + "Ȩ��У��ʧ��:" + response.getErrorMessage() + ",���������Ȩ��");
                    }
                }else {
                    String dsCode = reportSqls.get(i).getDataSource();
                    String dbsql = reportSqls.get(i).getSqlText();
                    Set<String> tables = null;
                    try {
                        tables = FreeMakerParser.parserTables(dbsql);
                    }catch (Exception e) {
                        throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, reportSqls.get(i).getDsCode() + "SQL����ʧ��:" + e.getMessage());
                    }
                    if (tables != null && tables.size() > 0) {
                        TablePermissionsRequest request = new TablePermissionsRequest();
                        request.setUserCode(report.getUpdaterNo());
                        Map<String, Set<String>> tableMap = new HashMap<String, Set<String>>();
                        tableMap.put(dsCode, tables);
                        request.setTableMap(tableMap);

                        SystemPermissionsResponse response = ClientProxyFactory.instance.getClientProxy(IRpmsService.class).checkTablePermissionsByUserCode(request);
                        if (!response.isHasPermissions()) {
                            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, reportSqls.get(i).getDsCode() + "Ȩ��У��ʧ��:" + response.getErrorMessage() + ",���������Ȩ��");
                        }
                    }
                }
            }

        }else {
            report.setJavaScript(StringKit.trim(reportMap.get("javaScript")));
        }

        int result = reportService.updateReport(report, reportSqls);
        if (result < 0) {
            throw new RemoteExecuteException(Constant.Code.INSERT_ERROR, "���ݲ���ʧ��..."); // ��װ�������
        }
        String editResouseFile = reportMap.get("editResouseFile");
         
        if(editResouseFile.equals("0") || report.getHtmlType()==2){
            deploy(report.getReportCode(),"0");
        }
        map.put("code", Constant.Code.OPERATE_SUCCESS);
        return map;
    }

    // �����ѯ
    public HashMap<String, Object> queryList(@Para(name = "queryCond") HashMap<String, String> queryCond, @Para(name = "pageCond") PageCond pageCond) throws Exception {
        String loginName = CurrentUserHelper.getLoginUserInfo().loginName;
        if (loginName == null || loginName.equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "����ѹ���,�����µ�¼...");
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        queryCond.put("creatorNo", loginName);// ֻ�ܲ鿴�Լ��ύ�ķ�����
        List<Report> list = reportService.queryReportWithPage(queryCond, pageCond);
        hashMap.put("list", list);
        hashMap.put("pc", pageCond);
        return hashMap;

    }

    // ����code list ��ѯ
    public HashMap<String, Object> queryReportCode(@Para(name = "param") String param) throws Exception {
        HashMap<String, String> queryCond = new HashMap<>();
        HashMap<String, Object> hashMap = new HashMap<>();
        String loginName = CurrentUserHelper.getLoginUserInfo().loginName;
        if (loginName == null || loginName.equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "����ѹ���,�����µ�¼...");
        }
        if (!param.equals("admin")) {

            queryCond.put("creatorNo", loginName);// ֻ�ܲ鿴�Լ�����ı���
        }

        List<Report> list = reportService.queryReportCode(queryCond);
        hashMap.put("list", list);
        return hashMap;

    }

    // �����ѯ(����Ա)
    public HashMap<String, Object> queryAllList(@Para(name = "queryCond") HashMap<String, String> queryCond, @Para(name = "pageCond") PageCond pageCond) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<>();
        List<Report> list = reportService.queryAllReportWithPage(queryCond, pageCond);
        hashMap.put("list", list);
        hashMap.put("pc", pageCond);
        return hashMap;

    }

    // ���ϱ����ѯ(����Ա)
    public HashMap<String, Object> queryOnlineList(@Para(name = "queryCond") HashMap<String, String> queryCond, @Para(name = "pageCond") PageCond pageCond) throws Exception {
        String loginName = CurrentUserHelper.getLoginUserInfo().loginName;
        if (loginName == null || loginName.equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "����ѹ���,�����µ�¼...");
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        List<Report> list = reportService.queryOnlineReportWithPage(queryCond, pageCond);
        hashMap.put("list", list);
        hashMap.put("pc", pageCond);
        return hashMap;

    }

    // ����reportCodeɾ�������Լ����������
    public HashMap<String, Object> delReport(@Para(name = "queryCond") Report report) throws Exception {

        HashMap<String, Object> map = new HashMap<>();
        // �ж��¸ñ����Ƿ��������Ȩ�ޣ����������Ȩ�ޣ����ܽ���ɾ������
        HashMap<String, String> queryCond = new HashMap<String, String>();
        queryCond.put("reportCode", report.getReportCode());
        int result = reportService.delReport(report);
        if (result > 0) {
            map.put("code", Constant.Code.OPERATE_SUCCESS);
        }
        return map;
    }

    // ����reportCode���������룬���������ߣ�
    public HashMap<String, Object> manageReport(@Para(name = "queryCond") HashMap<String, String> queryCond) throws Exception {

        HashMap<String, Object> map = new HashMap<>();
        // HashMap<String, Object> queryMap = new HashMap<String, Object>();
        String status = queryCond.get("status");
        int result = 0;
        // ����Ƿ��������ϣ�����Ҫͬ�����ݵ�stable����
        if (status.equals("3") && queryCond.get("flag") == null) {

            // ����code �õ�report����
            Report report = reportService.queryReportByCode(queryCond);
            report.setStatus(status);
            report.setCompareStatus("1");

            List<ReportSql> reportSqls = reportService.getReportSql(queryCond);
            // ����ɾ��stable ����ԭ��������
            // queryMap.put("sqlList", reportSqls);
            // queryMap.put("Report", report);
            result = reportService.updateOnlineReport(report, reportSqls);
            if (result > 0) {
                // ��ѹ�ļ����б�����׳�ȥ�ˣ�
                decompressFile(queryCond);
            }

        }
        // ����Ǵӷ���״̬������״̬�������ϺͿ������е�״̬��Ҫ����
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

    // ����reportCode��ѯ�����sql
    public HashMap<String, Object> getReportSql(@Para(name = "queryCond") HashMap<String, String> queryCond) throws Exception {

        HashMap<String, Object> map = new HashMap<>();
        List<ReportSql> reportSqls = reportService.getReportSql(queryCond);
        map.put("list", reportSqls);
        return map;
    }

    // ���±���ά����(����Ա����)
    public HashMap<String, Object> updateOwner(@Para(name = "reportMap") HashMap<String, String> reportMap) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        List<ReportSql> reportSqls = new ArrayList<ReportSql>();
        Report report = new Report();
        // �п�(����ֵ)
        if (StringUtils.isAnyBlank(reportMap.get("reportCode"), reportMap.get("creatorNo"), reportMap.get("creator"))) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "params is null or empty..."); // ��װ�������
        }

        report.setReportCode(StringKit.trim(reportMap.get("reportCode")));
        LoginUserInfo loginUserInfo = CurrentUserHelper.getLoginUserInfo();
        String loginName = loginUserInfo.loginName;
        if (loginName == null || loginName.equals("")) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "����ѹ��� , �����µ�¼...");
        }
        report.setCreatorNo(StringKit.trim(reportMap.get("creatorNo")));
        report.setCreator(StringKit.trim(reportMap.get("creator")));
        int result = reportService.updateReport(report, reportSqls);
        if (result < 0) {
            throw new RemoteExecuteException(Constant.Code.INSERT_ERROR, "���ݸ���ʧ��..."); // ��װ�������
        }
        
        map.put("code", Constant.Code.OPERATE_SUCCESS);
        return map;

    }

    /**
     * ��ѯҵ�������ǩ
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
            // log.error("��ȡҵ�������ǩ�쳣��", e);
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

    // ��ѯ����ͨ������Դ
    public HashMap<String, Object> getDataSource() {
        HashMap<String, Object> map = new HashMap<>();
        PluginEnvirement.getInstance().startup();
        try {
            IApiService apiService = ClientProxyFactory.instance.getClientProxy(IApiService.class);
            Response dataSource = apiService.getDataSource(new Request());
            map.put("dataSource", dataSource);
            // log.debug("����Դ:{}", dataSource.toString());
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return map;
    }

    // ��������ַ�����̨������
    public HashMap<String, Object> decompressFile(@Para(name = "queryCond") HashMap<String, String> queryCond) {
        if (StringUtils.isAnyBlank(queryCond.get("reportCode"), queryCond.get("mode"))) {
            throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "��ѹ����Ϊ�� "); // ��װ�������
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
                    throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, "������:" + serverUrl[i] + "���������쳣������˹��ϣ����Ժ����Ի���ϵ������Ա: �쳣��Ϣ:" + parseObject.getString("msg"));
                }
            }catch (Exception e) {
                throw new RemoteExecuteException(Constant.Code.SYSTEM_EXCEPTION, e.getMessage());
            }

        }
        return contentJson;
    }

    // ��������ַ�����̨������
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
