package xcl.oa.task.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import xcl.oa.task.dao.TaskDao;
import xcl.oa.task.vo.Task;

public class ITaskDao extends HibernateDaoSupport implements TaskDao {

	@Override
	public List<Task> findAll() {
		String hql = "from Task";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public Task addTask(Task task) {
		this.getHibernateTemplate().save(task);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear(); 
		return task;
	}

}
