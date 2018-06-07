package xcl.oa.job.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import xcl.oa.dept.service.DeptService;
import xcl.oa.dept.vo.Dept;
import xcl.oa.employee.service.EmployeeService;
import xcl.oa.employee.vo.Employee;
import xcl.oa.job.service.JobService;
import xcl.oa.job.vo.Job;

public class JobAction extends ActionSupport implements ModelDriven<Job>{
	
	private Map<String,Object> result;
	public Map<String, Object> getResult() {
		return result;
	}
	
	private Job job = new Job();
	@Override
	public Job getModel() {
		return job;
	}
	private int deptID;
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	//注入职位service
	private JobService jobService;
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}
	//注入员工service
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	//注入部门service
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	//添加新职位的方法
	public String save() {
		Dept dept = deptService.findById(deptID);
		job.setDept(dept);
		jobService.save(job);
		return "save";
	}
	//修改职位信息的方法
	public String edit() {
		//根据id查询职位
		job = jobService.findById(job.getJobID());
		//查询所有部门
		List<Dept> deptlist = deptService.findAll();
		result = new HashMap<String, Object>();
        result.put("job", job);
        result.put("deptlist", deptlist);
		// 页面跳转到编辑页面:
		return SUCCESS;
	}
	//删除职位的方法
	public String delete() {
		//根据职位id查询职位
		job = jobService.findById(job.getJobID());
		job.setIsDelete(1);
		//删除职位
		jobService.update(job);
		return "delete";
	}
	//查询所有职位的方法
	public String findAll() {
		//查询所有职位
		List<Job> joblist = jobService.findAll();
		//查询所有部门
		List<Dept> deptlist = deptService.findAll();
		result = new HashMap<String, Object>();
        result.put("deptlist", deptlist);
        result.put("joblist", joblist);
		return SUCCESS;
	}
	//修改职位方法
	public String update() {
		//根据部门id查找部门
		Dept dept = deptService.findById(deptID);
		//根据职位id查找所有员工
		List<Employee> employeelist = employeeService.findByJid(job.getJobID());
		for(int i = 0;i<employeelist.size();i++) {
			employeelist.get(i).setDept(dept);
			employeeService.update(employeelist.get(i));
		}
		job.setDept(dept);
		//修改职位
		jobService.update(job);
		return "update";
	}
	}
