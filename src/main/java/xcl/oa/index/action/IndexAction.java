package xcl.oa.index.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import xcl.oa.employee.service.EmployeeService;
import xcl.oa.employee.vo.Employee;

public class IndexAction extends ActionSupport implements ModelDriven<Employee>{

	private Employee employee = new Employee();
	public Employee getModel() {
		return employee;
	}
	
	@Autowired
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	private Map<String,Object> result;
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	private Integer userId;
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String login() {
		result = new HashMap<String, Object>();
		try {
			Employee e = employeeService.findById(userId);
			if(!e.getPwd().equals(employee.getPwd())) {
				result.put("msg", "用户名或密码不正确");
				result.put("code", 404);
			}else {
				ServletActionContext.getRequest().getSession()
				.setAttribute("existUser", e);
				result.put("code", 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return SUCCESS;
	}
	
	public String get() {
		Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		System.out.println("用户ID："+e.getEmployeeID());
		return SUCCESS;
	}

}
