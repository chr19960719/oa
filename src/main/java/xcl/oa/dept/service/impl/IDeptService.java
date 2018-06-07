package xcl.oa.dept.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import xcl.oa.dept.dao.DeptDao;
import xcl.oa.dept.service.DeptService;
import xcl.oa.dept.vo.Dept;

@Transactional
public class IDeptService implements DeptService{
	
	private DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	//service层查找所有部门
	@Override
	public List<Dept> findAll() {
		return deptDao.findAll();
	}
	//service层添加部门
	@Override
	public void save(Dept dept) {
		deptDao.save(dept);
	}
	//service层根据id查找部门
	public Dept findById(int deptID) {
		return deptDao.findById(deptID);
	}
	//service层修改部门
	public void update(Dept dept) {
		deptDao.update(dept);
	}

}
