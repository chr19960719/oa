package xcl.oa.receivefile.service.impl;

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
		ReceiveFile receiveFile = new ReceiveFile();
		receiveFile.setIsLook(0);
		receiveFile.setIsDelete(0);
		receiveFile.setSendFile(sendFile);
		String[] empid = employees.split(",");
		for(int i=0;i<empid.length;i++) {
			Integer employeeID = Integer.valueOf(empid[i]);
			System.out.println("用户id"+employeeID);
			Employee employee = employeeDao.findById(employeeID);
			receiveFile.setEmployee(employee);
			receiveFileDao.save(receiveFile);
		}
		
	}

}
