package xcl.oa.receivefile.service;

import xcl.oa.sendfile.vo.SendFile;

public interface ReceiveFileService {
	public void save(SendFile sendFile,String employees);
}
