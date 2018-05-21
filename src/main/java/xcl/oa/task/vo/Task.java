package xcl.oa.task.vo;

import java.io.Serializable;

import xcl.oa.employee.vo.Employee;

public class Task implements Serializable{
	private Integer taskID;//任务ID
	private String taskName;//任务名称
	private String taskInfo;//任务介绍
	private String getTime;//添加任务时间
	private String taskState;//任务状态
	private Employee employee;//外键任务添加人
	public Integer getTaskID() {
		return taskID;
	}
	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskInfo() {
		return taskInfo;
	}
	public void setTaskInfo(String taskInfo) {
		this.taskInfo = taskInfo;
	}
	public String getGetTime() {
		return getTime;
	}
	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}
	public String getTaskState() {
		return taskState;
	}
	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
