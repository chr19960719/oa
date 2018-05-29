package xcl.oa.notice.service;

import java.util.List;

import xcl.oa.notice.vo.Notice;

public interface NoticeService {
	//service层添加公告的方法
	public void save(Notice notice);
	//service层根据id查询公告的方法
	public Notice findById(Integer noteID);
	//service层删除公告的方法
	public void delete(Notice notice);
	//service层查询所有公告的方法
	public List<Notice> findAll();

}
