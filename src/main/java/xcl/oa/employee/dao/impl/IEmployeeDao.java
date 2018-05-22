package xcl.oa.employee.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import xcl.oa.employee.dao.EmployeeDao;
import xcl.oa.employee.vo.Employee;

public class IEmployeeDao extends HibernateDaoSupport implements EmployeeDao{
	//dao层查询所有员工的方法
	public List<Employee> findAll(){
		String hql = "from employees";
		List<Employee> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	//dao层添加员工的方法
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}
	//dao层根据id查询员工的方法
	public Employee findById(Integer employeeID) {
		return this.getHibernateTemplate().get(Employee.class,employeeID);
	}
	
}
