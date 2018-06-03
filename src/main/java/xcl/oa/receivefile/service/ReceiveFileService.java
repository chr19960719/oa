package xcl.oa.receivefile.service;

import xcl.oa.receivefile.vo.ReceiveFile;
import xcl.oa.sendfile.vo.SendFile;

public interface ReceiveFileService {
	//保存接收的消息
	public void save(SendFile sendFile,String employees);
	//获取消息
	public ReceiveFile findById(Integer receiveID);
	//设置为已读
	public void isLook(ReceiveFile file);
}
