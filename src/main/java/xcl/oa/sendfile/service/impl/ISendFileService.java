package xcl.oa.sendfile.service.impl;

import org.springframework.transaction.annotation.Transactional;

import xcl.oa.sendfile.dao.SendFileDao;
import xcl.oa.sendfile.service.SendFileService;
import xcl.oa.sendfile.vo.SendFile;

@Transactional
public class ISendFileService implements SendFileService{

	private SendFileDao sendFileDao;
	public void setSendFileDao(SendFileDao sendFileDao) {
		this.sendFileDao = sendFileDao;
	}
	
	@Override
	public SendFile save(SendFile sendFile) {
		return sendFileDao.save(sendFile);
	}

}
