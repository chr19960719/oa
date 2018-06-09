package xcl.oa.function.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import xcl.oa.function.dao.FunctionDao;
import xcl.oa.function.vo.Function;

public class IFunctionDao extends HibernateDaoSupport implements FunctionDao{

	@Override
	public Function findById(Integer functionID) {		
		return this.getHibernateTemplate().get(Function.class, functionID);
	}

}
