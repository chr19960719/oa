package xcl.oa.receivefile.vo;

import java.io.Serializable;

import xcl.oa.employee.vo.Employee;
import xcl.oa.sendfile.vo.SendFile;

public class ReceiveFile implements Serializable {
	private Integer receiveID;//接收表id
	private Integer isLook;//查看状态 0：未查看  1：已查看
	private Integer isDelete;//是否删除 0：未删除  1：已删除
	private Employee employee;//外键文件接收人
	private SendFile sendFile;//外键接收的文件
	public Integer getReceiveID() {
		return receiveID;
	}
	public void setReceiveID(Integer receiveID) {
		this.receiveID = receiveID;
	}
	public Integer getIsLook() {
		return isLook;
	}
	public void setIsLook(Integer isLook) {
		this.isLook = isLook;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public SendFile getSendFile() {
		return sendFile;
	}
	public void setSendFile(SendFile sendFile) {
		this.sendFile = sendFile;
	}
	
}
