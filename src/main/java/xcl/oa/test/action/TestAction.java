package xcl.oa.test.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
import xcl.oa.dept.service.DeptService;
import xcl.oa.dept.vo.Dept;

public class TestAction extends ActionSupport{
	
	private String fileText;
	public void setFileText(String fileText) {
		this.fileText = fileText;
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
	
	
	
	@Autowired
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
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
        String path = ServletActionContext.getServletContext().getRealPath(
				"/indexstatic/sendfile");
        if(file!=null) {
        // 创建文件类型对象:
     	File diskFile = new File(path + "//" + fileFileName);
     		// 文件上传:
     	FileUtils.copyFile(file, diskFile);
     	System.out.println("文件名："+fileFileName);
        }
     	System.out.println("文件内容："+fileText);
     	 try {
	            response.getWriter().print("你好");
	            response.getWriter().close();
	        } catch (Exception e) {
	            //log.fatal(e);
	        }
        return NONE;
	}
	
	public String json() {
		HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        JSONObject json = new JSONObject();
        List<Dept> list = deptService.findAll();
        json.put("list", list);
        try {
            response.getWriter().print(json.toString());
            response.getWriter().close();
        } catch (Exception e) {
            //log.fatal(e);
        }
		return NONE;
	}
}
