package xcl.oa.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import xcl.oa.employee.dao.EmployeeDao;
import xcl.oa.employee.service.EmployeeService;
import xcl.oa.employee.vo.Employee;
import xcl.oa.job.vo.Job;

@Transactional
public class IEmployeeService implements EmployeeService {
	
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	//service层查询所有员工的方法
	public List<Employee> findAll(){
		return employeeDao.findAll();
	}
	//service层添加员工的方法
	public void save(Employee employee) {
		employeeDao.save(employee);
	}
	//service层根据id查询员工的方法
	public Employee findById(Integer employeeID) {
		return employeeDao.findById(employeeID);
	}
	//service层删除员工的方法
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}
	//service层修改员工的方法
	public void update(Employee employee) {
		employeeDao.update(employee);
	}
	//service层根据职位id查找员工
	public List<Employee> findByJid(Integer jobID){
		return employeeDao.findByJid(jobID);
	}

}
