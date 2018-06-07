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
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}
	//dao层查找所有职位的方法
	public List<Job> findAll()
	{
		String hql = "from Job";
		List<Job> list = this.getHibernateTemplate().find(hql);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	//dao层根据id查找职位的方法
	public Job findById(Integer jobID) {
		return this.getHibernateTemplate().get(Job.class, jobID);
	}
	//dao层删除职位的方法
	public void delete(Job job) {
		this.getHibernateTemplate().delete(job);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}
	//dao层根据部门id查找职位的方法
	public List<Job> findByDid(Integer deptID){
		String hql = "from Job j where j.dept.deptID=?";
		List<Job> list = this.getHibernateTemplate().find(hql, deptID);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	//dao层修改职位的方法
	public void update(Job job) {
		this.getHibernateTemplate().update(job);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}
}
