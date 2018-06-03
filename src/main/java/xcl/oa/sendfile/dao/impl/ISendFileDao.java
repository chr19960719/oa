package xcl.oa.sendfile.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import xcl.oa.sendfile.dao.SendFileDao;
import xcl.oa.sendfile.vo.SendFile;

public class ISendFileDao extends HibernateDaoSupport implements SendFileDao{

	@Override
	public SendFile save(SendFile sendFile) {
		this.getHibernateTemplate().save(sendFile);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear(); 
		//System.out.println("存入的id"+sendFile.getFileID());
		return sendFile;
	}

	@Override
	public SendFile findById(Integer fileID) {
		return this.getHibernateTemplate().get(SendFile.class, fileID);
	}

}
