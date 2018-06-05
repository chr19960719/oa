package xcl.oa.task.service;

import java.util.List;

import xcl.oa.task.vo.Task;

public interface TaskService {
	List<Task> findAll();

	Task addTask(Task task);
}
