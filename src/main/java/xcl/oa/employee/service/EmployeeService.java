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
	//service层删除员工的方法
	public void delete(Employee employee);
	//service层修改员工的方法
	public void update(Employee employee);

}
