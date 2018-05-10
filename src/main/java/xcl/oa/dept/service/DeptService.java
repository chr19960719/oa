package xcl.oa.dept.service;

import java.util.List;

import xcl.oa.dept.vo.Dept;

public interface DeptService {

	public List<Dept> findAll();

	public void save(Dept dept);
	
}
