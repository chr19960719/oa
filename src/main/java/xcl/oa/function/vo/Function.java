package xcl.oa.function.vo;

import java.io.Serializable;

public class Function implements Serializable{
	private Integer functionID;//功能id
	private String functionName;//功能名称
	private String url;//功能跳转地址
	private Integer multilevel;//上级权限，没有默认为0
	public Integer getFunctionID() {
		return functionID;
	}
	public void setFunctionID(Integer functionID) {
		this.functionID = functionID;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getMultilevel() {
		return multilevel;
	}
	public void setMultilevel(Integer multilevel) {
		this.multilevel = multilevel;
	}
	
}
