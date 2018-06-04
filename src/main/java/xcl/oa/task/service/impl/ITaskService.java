package xcl.oa.task.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import xcl.oa.task.dao.TaskDao;
import xcl.oa.task.service.TaskService;
import xcl.oa.task.vo.Task;

@Transactional
public class ITaskService implements TaskService{

	private TaskDao taskDao;
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}
	
	@Override
	public List<Task> findAll() {
		return taskDao.findAll();
	}

}
