package xcl.oa.type.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import xcl.oa.type.dao.TypeDao;
import xcl.oa.type.vo.Type;

public class ITypeDao extends HibernateDaoSupport implements TypeDao{

	@Override
	public Type findById(Integer typeID) {
		return this.getHibernateTemplate().get(Type.class, typeID);
	}

}
