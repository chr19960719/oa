package xcl.oa.receivefile.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import xcl.oa.receivefile.dao.ReceiveFileDao;
import xcl.oa.receivefile.vo.ReceiveFile;

public class IReceiveFileDao extends HibernateDaoSupport implements ReceiveFileDao{

	@Override
	public ReceiveFile save(ReceiveFile receiveFile) {
		//System.out.println("存入文件的用户"+receiveFile.getEmployee().getEmployeeID());
		this.getHibernateTemplate().save(receiveFile);
		this.getHibernateTemplate().flush();
		return receiveFile;
	}

	@Override
	public ReceiveFile findById(Integer receiveID) {
		return this.getHibernateTemplate().get(ReceiveFile.class, receiveID);
	}

	@Override
	public void update(ReceiveFile file) {
		this.getHibernateTemplate().update(file);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}

}
