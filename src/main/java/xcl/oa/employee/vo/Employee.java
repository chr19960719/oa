package xcl.oa.employee.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import xcl.oa.dept.vo.Dept;
import xcl.oa.job.vo.Job;
import xcl.oa.receivefile.vo.ReceiveFile;
import xcl.oa.sendfile.vo.SendFile;
import xcl.oa.task.vo.Task;

public class Employee implements Serializable{
	private Integer employeeID;//用户ID
	private Integer isDelete;//删除状态
	private String employeeName;//用户名字
	private String sex;//用户性别
	private String birthday;//用户生日
	private String address;//地址
	private String NOcode;//身份证号
	private String learn;//学历
	private String mobile;//手机号
	private String email;//邮箱
	private String workState;//状态
	private String photo;//照片
	private String agreement;//就职协议
	private String pwd;//密码
	private Integer userLevel;//用户级别
	private Job job;//外键职位
	private Dept dept;//外键部门
	private Set<SendFile> sendFiles = new HashSet<SendFile>();
	private Set<ReceiveFile> receiveFiles = new HashSet<ReceiveFile>();
	private Set<Task> tasks = new HashSet<Task>();
	
	public Set<Task> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	public Set<SendFile> getSendFiles() {
		return sendFiles;
	}
	public void setSendFiles(Set<SendFile> sendFiles) {
		this.sendFiles = sendFiles;
	}
	public Set<ReceiveFile> getReceiveFiles() {
		return receiveFiles;
	}
	public void setReceiveFiles(Set<ReceiveFile> receiveFiles) {
		this.receiveFiles = receiveFiles;
	}
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNOcode() {
		return NOcode;
	}
	public void setNOcode(String nOcode) {
		NOcode = nOcode;
	}
	public String getLearn() {
		return learn;
	}
	public void setLearn(String learn) {
		this.learn = learn;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWorkState() {
		return workState;
	}
	public void setWorkState(String workState) {
		this.workState = workState;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAgreement() {
		return agreement;
	}
	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
