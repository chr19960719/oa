package xcl.oa.sendfile.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import xcl.oa.employee.vo.Employee;
import xcl.oa.receivefile.vo.ReceiveFile;

public class SendFile implements Serializable{
	private Integer fileID;//文件ID
	private String fileTime;//文件发送时间
	private String fileName;//文件名
	private String fileText;//文件描述
	private Integer issend;//发送状态 0：未发送  1：已发送
	private Employee employee;//外键文件发送人
	private Set<ReceiveFile> receiveFiles = new HashSet<ReceiveFile>();
	
	public Integer getFileID() {
		return fileID;
	}
	public void setFileID(Integer fileID) {
		this.fileID = fileID;
	}
	public String getFileTime() {
		return fileTime;
	}
	public void setFileTime(String fileTime) {
		this.fileTime = fileTime;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileText() {
		return fileText;
	}
	public void setFileText(String fileText) {
		this.fileText = fileText;
	}
	public Integer getIssend() {
		return issend;
	}
	public void setIssend(Integer issend) {
		this.issend = issend;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Set<ReceiveFile> getReceiveFiles() {
		return receiveFiles;
	}
	public void setReceiveFiles(Set<ReceiveFile> receiveFiles) {
		this.receiveFiles = receiveFiles;
	}
	
}
