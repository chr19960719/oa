package xcl.oa.job.service;

import java.util.List;
import xcl.oa.job.vo.Job;

public interface JobService {
	//service层查找所有职位的方法
	public List<Job> findAll();
	//service层添加职位的方法
	public void save(Job job);
	//service层根据id查找职位的方法
	public Job findById(Integer jobID);
	//service层删除职位的方法
	public void delete(Job job);

}
