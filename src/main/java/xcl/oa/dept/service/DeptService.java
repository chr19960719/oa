package xcl.oa.dept.service;

import java.util.List;

import xcl.oa.dept.vo.Dept;

public interface DeptService {
	//service层查找所有部门
	public List<Dept> findAll();
	//service层添加部门
	public void save(Dept dept);
	//service层根据id查找部门
	public Dept findById(int deptID);
	//service层修改部门
	public void update(Dept dept);
	
}
