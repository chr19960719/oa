package xcl.oa.employee.service.impl;

import java.util.List;
import xcl.oa.employee.dao.EmployeeDao;
import xcl.oa.employee.service.EmployeeService;
import xcl.oa.employee.vo.Employee;

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
	

}
