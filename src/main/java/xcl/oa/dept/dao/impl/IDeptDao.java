package xcl.oa.dept.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import xcl.oa.dept.dao.DeptDao;
import xcl.oa.dept.vo.Dept;

public class IDeptDao extends HibernateDaoSupport implements DeptDao{

	@Override
	public List<Dept> findAll(){
		String hql = "from Dept";
		List<Dept> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public void save(Dept dept) {
		this.getHibernateTemplate().save(dept);
	}

}
