package xcl.oa.job.dao;

import java.util.List;

import xcl.oa.job.vo.Job;

public interface JobDao {
	//dao层添加新职位的方法
	public void save(Job job);
	//dao层查找所有职位的方法
	public List<Job> findAll();
	//dao层根据id查找职位的方法
	public Job findById(Integer jobID);
	//dao层删除职位的方法
	public void delete(Job job);

}
