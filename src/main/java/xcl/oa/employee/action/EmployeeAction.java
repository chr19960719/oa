package xcl.oa.employee.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import xcl.oa.dept.service.DeptService;
import xcl.oa.dept.vo.Dept;
import xcl.oa.employee.service.EmployeeService;
import xcl.oa.employee.vo.Employee;
import xcl.oa.job.service.JobService;
import xcl.oa.job.vo.Job;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}
	//注入员工service
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	//注入职位service
	private JobService jobService;
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}
	//注入部门service
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	//查询所有员工的方法
	public String findAll() {
		List<Employee> employeelist = employeeService.findAll();
		return "findAll";
	}
	//添加员工的方法
	public String save() {
		employeeService.save(employee);
		return "save";
	}
	//编辑员工的方法
	public String edit() {
		//根据id查询员工
		employee = employeeService.findById(employee.getEmployeeID());
		// 查询所有职位
		List<Job> joblist = jobService.findAll();
		//查询所有部门
		List<Dept> deptlist = deptService.findAll();
		// 页面跳转到编辑页面:
		return "editSuccess";
	}
	//根据员工id查询员工的方法
	public String findById(Integer employeeID) {
		employee = employeeService.findById(employeeID);
		return "findById";
	}

}
