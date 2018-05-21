package xcl.oa.job.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import xcl.oa.job.vo.Job;

public class JobAction extends ActionSupport implements ModelDriven<Job>{
	private Job job = new Job();
	@Override
	public Job getModel() {
		return job;
	}

}
