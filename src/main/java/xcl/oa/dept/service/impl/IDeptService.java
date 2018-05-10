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
	@Override
	public List<Dept> findAll() {
		return deptDao.findAll();
	}

	@Override
	public void save(Dept dept) {
		deptDao.save(dept);
	}

}
