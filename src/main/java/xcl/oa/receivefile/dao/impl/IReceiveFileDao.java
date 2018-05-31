package xcl.oa.receivefile.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import xcl.oa.receivefile.dao.ReceiveFileDao;
import xcl.oa.receivefile.vo.ReceiveFile;

public class IReceiveFileDao extends HibernateDaoSupport implements ReceiveFileDao{

	@Override
	public void save(ReceiveFile receiveFile) {
		this.getHibernateTemplate().save(receiveFile);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}

}
