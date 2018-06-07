package xcl.oa.dept.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import xcl.oa.dept.dao.DeptDao;
import xcl.oa.dept.vo.Dept;

public class IDeptDao extends HibernateDaoSupport implements DeptDao{
	//dao层查找所有部门
	@Override
	public List<Dept> findAll(){
		String hql = "from Dept";
		List<Dept> list = this.getHibernateTemplate().find(hql);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	//dao层添加部门
	@Override
	public void save(Dept dept) {
		this.getHibernateTemplate().save(dept);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}
	//dao层根据id查找部门
	public Dept findById(int deptID) {
		return this.getHibernateTemplate().get(Dept.class, deptID);
	}
	//dao层修改部门
	public void update(Dept dept) {
		this.getHibernateTemplate().update(dept);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}

}
