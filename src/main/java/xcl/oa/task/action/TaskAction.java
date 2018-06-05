package xcl.oa.task.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import xcl.oa.employee.service.EmployeeService;
import xcl.oa.task.service.TaskService;
import xcl.oa.task.vo.Task;

public class TaskAction extends ActionSupport implements ModelDriven<Task>{

	private Map<String,Object> result;
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	private Task task = new Task();
	public Task getModel() {
		return task;
	}
	
	private TaskService taskService;
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public String getAllTask() {
		result = new HashMap<String, Object>();
		try {
			List<Task> list = taskService.findAll();
			result.put("task", list);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "查找失败");
		}
		return SUCCESS;
	}
	
	public String addTask() {
		return SUCCESS;
	}

}
