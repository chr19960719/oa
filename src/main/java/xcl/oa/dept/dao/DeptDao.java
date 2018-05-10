package xcl.oa.dept.dao;

import java.util.List;

import xcl.oa.dept.vo.Dept;

public interface DeptDao {

	public List<Dept> findAll();

	public void save(Dept dept);

}
