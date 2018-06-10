package xcl.oa.receivefile.dao;

import xcl.oa.receivefile.vo.ReceiveFile;

public interface ReceiveFileDao {

	public ReceiveFile save(ReceiveFile receiveFile);

	public ReceiveFile findById(Integer receiveID);

	public void update(ReceiveFile file);
}
