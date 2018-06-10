package xcl.oa.type.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import xcl.oa.type.dao.TypeDao;
import xcl.oa.type.vo.Type;

public class ITypeDao extends HibernateDaoSupport implements TypeDao{

	@Override
	public Type findById(Integer typeID) {
		return this.getHibernateTemplate().get(Type.class, typeID);
	}
	
	//dao层查找所有角色
	public List<Type> findAll(){
		String hql = "from Type";
		List<Type> list = this.getHibernateTemplate().find(hql);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
