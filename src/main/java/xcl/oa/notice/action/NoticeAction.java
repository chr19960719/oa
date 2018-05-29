package xcl.oa.notice.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import xcl.oa.notice.service.NoticeService;
import xcl.oa.notice.vo.Notice;

public class NoticeAction extends ActionSupport implements ModelDriven<Notice>{
	
	private Notice notice = new Notice();
	@Override
	public Notice getModel() {
		return notice;
	}
	//注入公告service
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	//查看所有公告的方法
	public String findAll() {
		List<Notice> noticelist = noticeService.findAll();
		return "findAll";
	}
	//添加公告的方法
	public String save() {
		noticeService.save(notice);
		return "save";
	}
	//删除公告的方法
	public String delete() {
		//根据id查询公告
		notice = noticeService.findById(notice.getNoteID());
		//删除公告
		noticeService.delete(notice);
		return "delete";
	}
}
