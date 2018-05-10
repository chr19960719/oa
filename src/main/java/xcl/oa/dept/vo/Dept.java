package xcl.oa.dept.vo;

public class Dept {
	private Integer deptID;//部门id
	private String deptName;//部门名称
	private String deptText;//部分描述
	public Integer getDeptID() {
		return deptID;
	}
	public void setDeptID(Integer deptID) {
		this.deptID = deptID;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptText() {
		return deptText;
	}
	public void setDeptText(String deptText) {
		this.deptText = deptText;
	}
	@Override
	public String toString() {
		return "Dept [deptID=" + deptID + ", deptName=" + deptName + ", deptText=" + deptText + "]";
	}
	
}
