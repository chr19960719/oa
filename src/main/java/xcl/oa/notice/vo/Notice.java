package xcl.oa.notice.vo;

import java.io.Serializable;

import xcl.oa.employee.vo.Employee;

public class Notice implements Serializable{
	private Integer noteID;//公告ID
	private String noteName;//公告名称
	private String noteInfo;//公告介绍
	private String noteTime;//公告时间
	private Employee employee;//外键公告发布人
	public Integer getNoteID() {
		return noteID;
	}
	public void setNoteID(Integer noteID) {
		this.noteID = noteID;
	}
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public String getNoteInfo() {
		return noteInfo;
	}
	public void setNoteInfo(String noteInfo) {
		this.noteInfo = noteInfo;
	}
	public String getNoteTime() {
		return noteTime;
	}
	public void setNoteTime(String noteTime) {
		this.noteTime = noteTime;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
