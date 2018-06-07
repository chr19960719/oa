package xcl.oa.employee.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import xcl.oa.employee.dao.EmployeeDao;
import xcl.oa.employee.vo.Employee;
import xcl.oa.job.vo.Job;

public class IEmployeeDao extends HibernateDaoSupport implements EmployeeDao{
	//dao层查询所有员工的方法
	public List<Employee> findAll(){
		String hql = "from Employee";
		List<Employee> list = this.getHibernateTemplate().find(hql);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	//dao层添加员工的方法
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}
	//dao层根据id查询员工的方法
	public Employee findById(Integer employeeID) {
		return this.getHibernateTemplate().get(Employee.class,employeeID);
	}
	//dao层删除员工的方法
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}
	//dao层修改员工的方法
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}
	//dao层根据职位id查找员工的方法
	public List<Employee> findByJid(Integer jobID){
		String hql = "from Employee e where e.job.jobID=?";
		List<Employee> list = this.getHibernateTemplate().find(hql, jobID);
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
}