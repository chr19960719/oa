package xcl.oa.dept.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import xcl.oa.dept.service.DeptService;
import xcl.oa.dept.vo.Dept;
import xcl.oa.job.service.JobService;
import xcl.oa.job.vo.Job;

public class DeptAction extends ActionSupport implements ModelDriven<Dept>{
	
	private Map<String,Object> result;
	public Map<String, Object> getResult() {
		return result;
	}
	
	private Dept dept = new Dept();
	public Dept getModel() {
		return dept;
	}
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	private JobService jobService;
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}
	//查找所有部门的方法
	public String findAll() {
		//查找所有部门
		List<Dept> deptlist = deptService.findAll();
		result = new HashMap<String, Object>();
        result.put("deptlist", deptlist);
		return SUCCESS;
	}
	//添加部门的方法
	public String save() {
		//添加部门
		deptService.save(dept);
		return "save";
	}
	//编辑部门的方法
	public String edit() {
		//根据部门id查找部门
		dept = deptService.findById(dept.getDeptID());
		result = new HashMap<String, Object>();
        result.put("dept", dept);
		return SUCCESS;
	}
	//删除部门的方法
	public String delete() {
		//根据部门id查找部门
		dept = deptService.findById(dept.getDeptID());
		//设置部门删除状态为1,0表示未删除,1表示已删除
		dept.setIsDelete(1);
		//修改部门
		deptService.update(dept);
		//删除部门下的所有职位
		List<Job> joblist = jobService.findByDid(dept.getDeptID());
		for(int i= 0;i<joblist.size();i++) {
			joblist.get(i).setIsDelete(1);
			jobService.update(joblist.get(i));
		}
		return "delete";
	}
	//修改部门的方法
	public String update() {
		//修改部门
		deptService.update(dept);
		return "update";
	}
}
