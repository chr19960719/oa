package xcl.oa.employee.service;

import java.util.List;
import xcl.oa.employee.vo.Employee;

public interface EmployeeService {
	//service层查询所有员工的方法
	public List<Employee> findAll();
	//service层添加员工的方法
	public void save(Employee employee);
	//service层根据id查询员工的方法
	public Employee findById(Integer employeeID);

}