package xcl.oa.task.service;

import java.util.List;

import xcl.oa.task.vo.Task;

public interface TaskService {

	List<Task> findAll();

	//添加事务
	Task addTask(Task task);

	//删除事务
	void deleteTask(Integer id);

	//更新事务
	Task updataTask(Task task);
	
	//根据事务id查找事务
	Task findById(Integer id);

	//获取list集合
	List<Task> getListTask(Integer eID);
	
}
