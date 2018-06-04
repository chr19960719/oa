package xcl.oa.task.dao;

import java.util.List;

import xcl.oa.task.vo.Task;

public interface TaskDao {
	List<Task> findAll();
}
