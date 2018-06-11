package xcl.oa.job.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import xcl.oa.job.dao.JobDao;
import xcl.oa.job.service.JobService;
import xcl.oa.job.vo.Job;

@Transactional
public class IJobService implements JobService {
	
	//注入职位Dao
	private JobDao jobDao;
	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}
	//service层查找所有职位的方法
	public List<Job> findAll() {
		return jobDao.findAll();
	}
	//service层添加职位的方法
	public void save(Job job) {
		jobDao.save(job);
	}
	//service层根据id查找职位的方法
	public Job findById(Integer jobID) {
		return jobDao.findById(jobID);
	}
	//service层删除职位的方法
	public void delete(Job job) {
		jobDao.delete(job);
	}
	//service层根据部门id查找职位的方法
	public List<Job> findByDid(Integer deptID){
		return jobDao.findByDid(deptID);
	}
	//service层修改职位的方法
	public void update(Job job) {
		jobDao.update(job);
	}

}
