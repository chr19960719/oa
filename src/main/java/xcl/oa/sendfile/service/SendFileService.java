package xcl.oa.sendfile.service;

import xcl.oa.sendfile.vo.SendFile;

public interface SendFileService {
	public SendFile save(SendFile sendFile);
	public SendFile findById(Integer fileID);
}
