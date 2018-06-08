package xcl.oa.task.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import xcl.oa.employee.dao.EmployeeDao;
import xcl.oa.employee.vo.Employee;
import xcl.oa.task.dao.TaskDao;
import xcl.oa.task.service.TaskService;
import xcl.oa.task.vo.Task;

@Transactional
public class ITaskService implements TaskService{

	private TaskDao taskDao;
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}
	
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public List<Task> findAll() {
		return taskDao.findAll();
	}

	@Override
	public Task addTask(Task task) {	
		Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		task.setEmployee(employeeDao.findById(e.getEmployeeID()));
		task.setTaskState(0);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		task.setGetTime(date);
		return taskDao.addTask(task);
	}

	@Override
	public void deleteTask(Integer id) {
		Task task = taskDao.findById(id);
		Employee e = employeeDao.findById(task.getEmployee().getEmployeeID());
		e.getTasks().remove(task);
		task.setEmployee(null);
		taskDao.deleteTask(task);
	}

	@Override
	public Task updataTask(Task task) {
		return taskDao.updataTask(task);
	}

	@Override
	public Task findById(Integer id) {
		return taskDao.findById(id);
	}

}
