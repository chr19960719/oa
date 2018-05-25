package xcl.oa.job.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import xcl.oa.employee.vo.Employee;
import xcl.oa.job.dao.JobDao;
import xcl.oa.job.vo.Job;

public class IJobDao extends HibernateDaoSupport implements JobDao {
	//dao层添加新职位的方法
	public void save(Job job) {
		this.getHibernateTemplate().save(job);
	}
	//dao层查找所有职位的方法
	public List<Job> findAll()
	{
		String hql = "from job";
		List<Job> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	//dao层根据id查找职位的方法
	public Job findById(Integer jobID) {
		return this.getHibernateTemplate().get(Job.class, jobID);
	}
}
