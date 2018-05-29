package xcl.oa.notice.dao;

import java.util.List;

import xcl.oa.notice.vo.Notice;

public interface NoticeDao {
	//dao层添加公告的方法
	public void save(Notice notice);
	//dao层根据id查询公告的方法
	public Notice findById(Integer noteID);
	//dao层删除公告的方法
	public void delete(Notice notice);
	//dao层查询所有公告的方法
	public List<Notice> findAll();
	

}
