package xcl.oa.receivefile.action;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import xcl.oa.employee.service.EmployeeService;
import xcl.oa.employee.vo.Employee;
import xcl.oa.receivefile.service.ReceiveFileService;
import xcl.oa.receivefile.vo.ReceiveFile;
import xcl.oa.sendfile.service.SendFileService;
import xcl.oa.sendfile.vo.SendFile;

public class ReceiveFileAction extends ActionSupport implements ModelDriven<ReceiveFile>{
	private static final long serialVersionUID = 1L;
	private ReceiveFile receivefile = new ReceiveFile();
	@Override
	public ReceiveFile getModel() {
		return receivefile;
	}
	
	private Map<String,Object> result;
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
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
	
	//获得所有消息
	public String getAllMessage() {
		result = new HashMap<String, Object>();
		Employee employee = employeeService.findById(1);
		Set<ReceiveFile> set = employee.getReceiveFiles();
		int num = 0;
		for(ReceiveFile file: set) {
			if(file.getIsLook()==0) {
				num++;
			}
		}
		result.put("num", num);
		result.put("message", employee);
		return SUCCESS;
	}
	
	//设置消息为已读
	public String isLook() {
		ReceiveFile file = receiveFileService.findById(receivefile.getReceiveID());
		System.out.println("文件id："+receivefile.getReceiveID());
		file.setIsLook(1);
		receiveFileService.isLook(file);
		result = new HashMap<String, Object>();
		result.put("msg", "状态已变为已读");
		return SUCCESS;
	}
	
	//设置消息为删除
	public String isDelete() {
		ReceiveFile file = receiveFileService.findById(receivefile.getReceiveID());
		file.setIsDelete(1);
		receiveFileService.isLook(file);
		result = new HashMap<String, Object>();
		result.put("msg", "删除成功");
		return SUCCESS;
	}
	
	
	private String fileName;
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	//1.下载文件
	public String download() throws Exception {
		 return "download";
	}
	
	//2：返回流的方法
   public InputStream getAttrInputStream(){
       return ServletActionContext.getServletContext().getResourceAsStream("/indexstatic/sendfile/"+fileName);
   }
   
   //3:下载显示的中文名，（浏览器显示的文件名）
   public String getDownFileName(){
       try{
           //import java.net.URLEncoder;
           fileName = URLEncoder.encode(fileName,"UTF-8");
       }catch(Exception e){
           throw new RuntimeException();
       }
       
       return fileName;
   }

}
