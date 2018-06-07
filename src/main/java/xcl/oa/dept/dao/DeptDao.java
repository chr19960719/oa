package xcl.oa.dept.dao;

import java.util.List;

import xcl.oa.dept.vo.Dept;

public interface DeptDao {
	//dao层查找所有部门
	public List<Dept> findAll();
	//dao层添加部门
	public void save(Dept dept);
	//dao层根据id查找部门
	public Dept findById(int deptID);
	//dao层修改部门
	public void update(Dept dept);

}
