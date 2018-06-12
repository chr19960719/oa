package xcl.oa.dept.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

import xcl.oa.employee.vo.Employee;
import xcl.oa.job.vo.Job;

public class Dept implements Serializable{
	private Integer deptID;//部门id
	private Integer isDelete;//部门删除状态
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
	@JSON(serialize=false)
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@JSON(serialize=false)
	public Set<Job> getJobs() {
		return jobs;
	}
	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
