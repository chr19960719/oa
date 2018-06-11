package xcl.oa.receivefile.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import xcl.oa.receivefile.dao.ReceiveFileDao;
import xcl.oa.receivefile.vo.ReceiveFile;

public class IReceiveFileDao extends HibernateDaoSupport implements ReceiveFileDao{

	@Override
	public ReceiveFile save(ReceiveFile receiveFile) {
		System.out.println("存入文件的用户" + receiveFile.getEmployee().getEmployeeID());

		try {
			Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.clear();
			session.merge(receiveFile);
			System.out.println("============================================================================"
					+ receiveFile.getReceiveID());
		} catch (HibernateException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		this.getHibernateTemplate().flush();
		return receiveFile;
	}

	@Override
	public ReceiveFile findById(Integer receiveID) {
		return this.getHibernateTemplate().get(ReceiveFile.class, receiveID);
	}

	@Override
	public void update(ReceiveFile file) {
		try {
			Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.clear();
			session.update(file);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}

}
