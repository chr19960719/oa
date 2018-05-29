package xcl.oa.job.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import xcl.oa.dept.service.DeptService;
import xcl.oa.dept.vo.Dept;
import xcl.oa.job.service.JobService;
import xcl.oa.job.vo.Job;

public class JobAction extends ActionSupport implements ModelDriven<Job>{
	private Job job = new Job();
	@Override
	public Job getModel() {
		return job;
	}
	//注入职位service
	private JobService jobService;
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}
	//注入部门service
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	//添加新职位的方法
	public String save() {
		jobService.save(job);
		return "save";
	}
	//修改职位信息的方法
	public String edit() {
		//根据id查询职位
		job = jobService.findById(job.getJobID());
		//查询所有部门
		List<Dept> deptlist = deptService.findAll();
		// 页面跳转到编辑页面:
		return "editSuccess";
	}
	//删除职位的方法
	public String delete() {
		//根据职位id查询职位
		job = jobService.findById(job.getJobID());
		//删除职位
		jobService.delete(job);
		return "delete";
	}
	//查询所有职位的方法
	public String findAll() {
		jobService.findAll();
		return "findAll";
	}

}
