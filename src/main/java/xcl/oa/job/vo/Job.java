package xcl.oa.job.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import xcl.oa.dept.vo.Dept;
import xcl.oa.employee.vo.Employee;

public class Job implements Serializable{
	private Integer jobID;//职位ID
	private String jobName;//职位名称
	private String jobText;//职位介绍
	private Dept dept;//外键部门
	private Integer isDelete;//删除状态
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	private Set<Employee> employees = new HashSet<Employee>();
	public Integer getJobID() {
		return jobID;
	}
	public void setJobID(Integer jobID) {
		this.jobID = jobID;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobText() {
		return jobText;
	}
	public void setJobText(String jobText) {
		this.jobText = jobText;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
}
