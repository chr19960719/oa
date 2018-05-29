package xcl.oa.notice.service.impl;

import java.util.List;

import xcl.oa.notice.dao.NoticeDao;
import xcl.oa.notice.service.NoticeService;
import xcl.oa.notice.vo.Notice;

public class INoticeService implements NoticeService {
	
	//注入公告Dao
	private NoticeDao noticeDao;
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	//service层添加公告的方法
	public void save(Notice notice) {
		noticeDao.save(notice);
	}
	
	//service层根据id查询公告的方法
	public Notice findById(Integer noteID) {
		return noticeDao.findById(noteID);
	}

	//service层删除公告的方法
	public void delete(Notice notice) {
		noticeDao.delete(notice);
	}
	
	//service层查询所有公告的方法
	public List<Notice> findAll(){
		return noticeDao.findAll();
	}
}
