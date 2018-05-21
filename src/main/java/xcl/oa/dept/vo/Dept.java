package xcl.oa.dept.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import xcl.oa.employee.vo.Employee;
import xcl.oa.job.vo.Job;

public class Dept implements Serializable{
	private Integer deptID;//部门id
	private String deptName;//部门名称
	private String deptText;//部分描述
	private Set<Employee> employees = new HashSet<Employee>();
	private Set<Job> jobs = new HashSet<Job>();
	
	public Integer getDeptID() {
		return deptID;
	}
	public void setDeptID(Integer deptID) {
		this.deptID = deptID;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptText() {
		return deptText;
	}
	public void setDeptText(String deptText) {
		this.deptText = deptText;
	}
	@Override
	public String toString() {
		return "Dept [deptID=" + deptID + ", deptName=" + deptName + ", deptText=" + deptText + "]";
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Set<Job> getJobs() {
		return jobs;
	}
	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}
	
}
