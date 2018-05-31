package xcl.oa.test.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import xcl.oa.dept.service.DeptService;
import xcl.oa.dept.vo.Dept;
import xcl.oa.employee.service.EmployeeService;
import xcl.oa.employee.vo.Employee;
import xcl.oa.receivefile.service.ReceiveFileService;
import xcl.oa.sendfile.service.SendFileService;
import xcl.oa.sendfile.vo.SendFile;

public class TestAction extends ActionSupport implements ModelDriven<SendFile>{
	
	private SendFile sendFile = new SendFile();
	public SendFile getModel() {
		return sendFile;
	}
	
	private Map<String,Object> result;
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	//图片路径处理
	private File upload;
	public void setUpload(File upload) {
		this.upload = upload;
	}
	private String uploadFileName;
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
/*	private String uploadContentType;
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}*/
	
	//文件
	private File file;
	private String fileFileName;
	private String fileContentType;	
	public void setFile(File file) {
		this.file = file;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	private String employees;
	public void setEmployees(String employees) {
		this.employees = employees;
	}
	
	
	@Autowired
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	@Autowired
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@Autowired
	private SendFileService sendFileService;
	public void setSendFileService(SendFileService sendFileService) {
		this.sendFileService = sendFileService;
	}
	
	@Autowired
	private ReceiveFileService receiveFileService;
	public void setReceiveFileService(ReceiveFileService receiveFileService) {
		this.receiveFileService = receiveFileService;
	}
	
	public String upload() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String path = ServletActionContext.getServletContext().getRealPath(
				"/indexstatic/summernote/fileimg");
		// 创建文件类型对象:
		File diskFile = new File(path + "//" + uploadFileName);
		// 文件上传:
		FileUtils.copyFile(upload, diskFile);
		String fictitiousFilePath = "../../indexstatic/summernote/fileimg/"+uploadFileName;
		 try {
	            response.getWriter().print(fictitiousFilePath);
	            response.getWriter().close();
	        } catch (Exception e) {
	            //log.fatal(e);
	        }
		return NONE;
	}
	
	
	public String file() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		String path = ServletActionContext.getServletContext().getRealPath("/indexstatic/sendfile");
		if (file != null) {
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + fileFileName);
			// 文件上传:
			FileUtils.copyFile(file, diskFile);
			/*System.out.println("文件名：" + fileFileName);*/
		}
		/*System.out.println("文件内容：" + sendFile.getFileText());
		System.out.println("数组：" + employees);*/
		sendFile.setFilesrc(fileFileName);
		try {
			sendFile = sendFileService.save(sendFile);
			receiveFileService.save(sendFile, employees);
			response.getWriter().print("上传成功");
			response.getWriter().close();
		} catch (Exception e) {
			// log.fatal(e);
		}
		return NONE;
	}
	
	public String json() {
		HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        JsonConfig config = new JsonConfig();
        config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); 
        config.setExcludes(new String[]{"employees","hibernateLazyInitializer"});  
        config.setExcludes(new String[]{"jobs","hibernateLazyInitializer"});  
        List<Dept> list = deptService.findAll();
        List<Employee> list1 = employeeService.findAll();
        String json = JSONArray.fromObject(list, config).toString();
        
        JsonConfig config1 = new JsonConfig();
        config1.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); 
        config1.setExcludes(new String[]{"dept","hibernateLazyInitializer"});  
        config1.setExcludes(new String[]{"job","hibernateLazyInitializer"});  
        String json1 = JSONArray.fromObject(list1,config1).toString();
        
        try {
            response.getWriter().print(json);
            response.getWriter().close();
        } catch (Exception e) {
            //log.fatal(e);
        }
		return NONE;
	}
	
	public String ajaxjson() {
        JsonConfig config = new JsonConfig();
        config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); 
        config.setExcludes(new String[]{"employees","hibernateLazyInitializer"});  
        config.setExcludes(new String[]{"jobs","hibernateLazyInitializer"});  
        List<Dept> list = deptService.findAll();
        List<Employee> list1 = employeeService.findAll();
        String json = JSONArray.fromObject(list, config).toString();
        
        JsonConfig config1 = new JsonConfig();
        config1.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); 
        config1.setExcludes(new String[]{"dept","hibernateLazyInitializer"});  
        config1.setExcludes(new String[]{"job","hibernateLazyInitializer"});  
        String json1 = JSONArray.fromObject(list1,config1).toString();
        
        result = new HashMap<String, Object>();
        result.put("depe", list);
        result.put("employee", list1);
    
		return SUCCESS;
	}
}
