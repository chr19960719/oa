package xcl.oa.notice.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import xcl.oa.employee.vo.Employee;
import xcl.oa.notice.dao.NoticeDao;
import xcl.oa.notice.vo.Notice;

public class INoticeDao extends HibernateDaoSupport implements NoticeDao {
	
	//dao层添加公告的方法
	public void save(Notice notice) {
		this.getHibernateTemplate().save(notice);
	}
	
	//dao层根据id查询公告的方法
	public Notice findById(Integer noteID) {
		return this.getHibernateTemplate().get(Notice.class, noteID);
	}
	
	//dao层删除公告的方法
	public void delete(Notice notice) {
		this.getHibernateTemplate().delete(notice);
	}
	
	//dao层查询所有公告的方法
	public List<Notice> findAll(){
		String hql = "from notice";
		List<Notice> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
