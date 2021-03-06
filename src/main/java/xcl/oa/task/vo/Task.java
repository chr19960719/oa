package xcl.oa.task.vo;

import java.io.Serializable;

import xcl.oa.employee.vo.Employee;

public class Task implements Serializable{
	private Integer id;//任务ID
	private String title;//任务名称
	private String taskInfo;//任务介绍
	private String getTime;//添加任务时间
	private Integer taskState;//任务状态
	private Employee employee;//外键任务添加人
	private String start;//任务开启时间
	private String end;//任务结束时间
	private Integer allDay;//是否是全天任务
	private String color;//任务颜色

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
	public Integer getTaskState() {
		return taskState;
	}
	public void setTaskState(Integer taskState) {
		this.taskState = taskState;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Integer getAllDay() {
		return allDay;
	}
	public void setAllDay(Integer allDay) {
		this.allDay = allDay;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
