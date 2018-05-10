package xcl.oa.dept.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import xcl.oa.dept.service.DeptService;
import xcl.oa.dept.vo.Dept;

public class DeptAction extends ActionSupport implements ModelDriven<Dept>{
	private Dept dept = new Dept();
	public Dept getModel() {
		return dept;
	}
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	public String findAll() {
		List<Dept> deptlist = deptService.findAll();
		System.out.println(deptlist);
		return "success";
	}
	
	public String save() {
		deptService.save(dept);
		return "success";
	}
	
	public String savedept() {
		return "save";
	}
}
