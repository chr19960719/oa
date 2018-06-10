package xcl.oa.employee.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

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
import xcl.oa.receivefile.vo.ReceiveFile;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	
	private Map<String,Object> result;
	public Map<String, Object> getResult() {
		return result;
	}
	
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	private int deptID;
	private int jobID;
	private String Level;
	
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public void setLevel(String level) {
		Level = level;
	}

	private File pho;
	private String phoFileName;
	public void setPho(File pho) {
		this.pho = pho;
	}
	public void setPhoFileName(String phoFileName) {
		this.phoFileName = phoFileName;
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
		// 查询所有职位
		List<Job> joblist = jobService.findAll();
		//查询所有部门
		List<Dept> deptlist = deptService.findAll();
		
		result = new HashMap<String, Object>();
        result.put("employee", employeelist);
        result.put("joblist", joblist);
        result.put("deptlist", deptlist);
		return SUCCESS;
	}
	//添加员工的方法
	public String save() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
		if(pho != null){
			// 将商品图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath(
					"/employeeImg");
			//String path = "D:\\eclipse-workspace\\oa\\src\\main\\webapp\\employeeImg";
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + phoFileName);
			// 文件上传:
			FileUtils.copyFile(pho, diskFile);
	
			employee.setPhoto("employeeImg/" + phoFileName);
		}
		//根据部门id查找部门
		Dept dept = deptService.findById(deptID);
		//根据职位id查找部门
		Job job = jobService.findById(jobID);
		employee.setDept(dept);
		employee.setJob(job);
		//添加员工
		employeeService.save(employee);
		return "save";
	}
	//编辑员工的方法
	public String edit() {
		//根据id查询员工
		employee = employeeService.findById(employee.getEmployeeID());
		// 查询所有职位
		List<Job> joblist = jobService.findByDid(employee.getDept().getDeptID());
		//查询所有部门
		List<Dept> deptlist = deptService.findAll();
		
		result = new HashMap<String, Object>();
        result.put("employee", employee);
        result.put("joblist", joblist);
        result.put("deptlist", deptlist);
		// 页面跳转到编辑页面
		return SUCCESS;
	}
	//修改员工的方法
	public String update() throws IOException {
		if(pho != null){
			// 将商品图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			/*String path = ServletActionContext.getServletContext().getRealPath(
					"/employeeImg");*/
			String path = "D:\\eclipse-workspace\\oa\\src\\main\\webapp\\employeeImg";
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + phoFileName);
			// 文件上传:
			FileUtils.copyFile(pho, diskFile);
	
			employee.setPhoto("employeeImg/" + phoFileName);
		}
		//根据部门id查找部门
		Dept dept = deptService.findById(deptID);
		//根据职位id查找职位
		Job job = jobService.findById(jobID);
		employee.setDept(dept);
		employee.setJob(job);
		//判断用户级别
		if(Level.equals("普通用户"))
			employee.setUserLevel(0);
		else if(Level.equals("中级用户"))
			employee.setUserLevel(1);
		else
			employee.setUserLevel(2);
		//修改用户
		employeeService.update(employee);
		
		return "update";
	}
	//删除员工的方法
	public String delete() {
		//根据员工id查询员工的方法
		employee = employeeService.findById(employee.getEmployeeID());
		//设置员工删除状态为1,0表示未删除,1表示已删除
		employee.setIsDelete(1);
		//更新员工信息
		employeeService.update(employee);
		return "delete";
	}
	//根据部门id查找职位的方法
	public String findJobByDeptID(){
		//根据部门id查找职位
		List<Job> joblist = jobService.findByDid(deptID);
		result = new HashMap<String, Object>();
        result.put("joblist", joblist);
		return SUCCESS;
	}
	//获取已登录用户的个人信息
	public String getinfo() {
		result = new HashMap<String, Object>();
		Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		Employee employee = employeeService.findById(e.getEmployeeID());
		// 查询所有职位
		List<Job> joblist = jobService.findByDid(employee.getDept().getDeptID());
		//查询所有部门
		List<Dept> deptlist = deptService.findAll();
		result.put("joblist", joblist);
        result.put("deptlist", deptlist);
		result.put("employee", employee);
		return SUCCESS;
	}
}
