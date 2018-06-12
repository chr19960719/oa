package xcl.oa.task.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import xcl.oa.employee.service.EmployeeService;
import xcl.oa.employee.vo.Employee;
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
	
	//获取所有任务
	public String getAllTask() {
		result = new HashMap<String, Object>();
		try {
			Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("existUser");
			Employee employee = employeeService.findById(e.getEmployeeID());
			Set<Task> set = employee.getTasks();			
			int num = 0;
			for(Task t:set) {
				if(t.getTaskState()==0) {
					num++;
				}
			}
			result.put("num", num);
			result.put("task", set);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "查找失败");
		}
		return SUCCESS;
	}
	
	//获取所有任务
	public String getListTask() {
		result = new HashMap<String, Object>();
		try {
			Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("existUser");
			List<Task> list = taskService.getListTask(Integer.valueOf(e.getEmployeeID()));			
			int num = 0;
			for(Task t:list) {
				if(t.getTaskState()==0) {
					num++;
				}
			}
			result.put("num", num);
			result.put("task", list);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "查找失败");
		}
		return SUCCESS;
	}
	
	//添加任务
	public String addTask() {
		result = new HashMap<String, Object>();
		try {
			task = taskService.addTask(task);
			result.put("a_task", task);
		}catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "添加失败");
		}
		return SUCCESS;
	}
	
	//删除任务
	public String deleteTask() {
		result = new HashMap<String, Object>();
		try {
			taskService.deleteTask(task.getId());
			result.put("msg", "删除成功");
		}catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "删除失败");
		}
		return SUCCESS;
	}
	
	//更新任务
	public String updataTask() {
		result = new HashMap<String, Object>();
		try {
			Task t = taskService.findById(task.getId());
			t.setAllDay(task.getAllDay());
			t.setEnd(task.getEnd());
			t.setStart(task.getStart());
			t.setTaskInfo(task.getTaskInfo());
			t.setTaskState(task.getTaskState());
			t.setTitle(task.getTitle());
			task = taskService.updataTask(t);
			result.put("a_task", task);
		}catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "更新失败");
		}
		return SUCCESS;
	}

}
