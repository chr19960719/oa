package xcl.oa.employee.dao;

import java.util.List;
import xcl.oa.employee.vo.Employee;

public interface EmployeeDao {
	//dao层查询所有员工的方法
	public List<Employee> findAll();
	//dao层添加员工的方法
	public void save(Employee employee);
	//dao层根据id查询员工的方法
	public Employee findById(Integer employeeID);
	//dao层删除员工的方法
	public void delete(Employee employee);

}
