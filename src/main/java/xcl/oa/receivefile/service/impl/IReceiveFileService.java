package xcl.oa.receivefile.service.impl;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import xcl.oa.employee.dao.EmployeeDao;
import xcl.oa.employee.vo.Employee;
import xcl.oa.receivefile.dao.ReceiveFileDao;
import xcl.oa.receivefile.service.ReceiveFileService;
import xcl.oa.receivefile.vo.ReceiveFile;
import xcl.oa.sendfile.vo.SendFile;

@Transactional
public class IReceiveFileService implements ReceiveFileService{

	private ReceiveFileDao receiveFileDao;
	public void setReceiveFileDao(ReceiveFileDao receiveFileDao) {
		this.receiveFileDao = receiveFileDao;
	}
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public void save(SendFile sendFile, String employees) {
		String[] empid = employees.split(",");
		for(int i=0;i<empid.length;i++) {
			ReceiveFile receiveFile = new ReceiveFile();
			receiveFile.setIsLook(0);
			receiveFile.setIsDelete(0);
			receiveFile.setSendFile(sendFile);			
			Integer employeeID = Integer.valueOf(empid[i]);
			Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("existUser");
			if(e.getEmployeeID()==employeeID)
				continue;
			Employee employee = employeeDao.findById(employeeID);
			receiveFile.setEmployee(employee);
			ReceiveFile r = receiveFileDao.save(receiveFile);
			System.out.println("============================================================================================================================================================"+r.getSendFile().getFileName()+r.getReceiveID());
		}
		
	}

	@Override
	public ReceiveFile findById(Integer receiveID) {
		return receiveFileDao.findById(receiveID);
	}

	@Override
	public void isLook(ReceiveFile file) {
		receiveFileDao.update(file);
	}

	@Override
	public List<ReceiveFile> list(Integer eID) {
		return receiveFileDao.list(eID);
	}

}
