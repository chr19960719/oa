package xcl.oa.record.vo;

import java.io.Serializable;

import xcl.oa.function.vo.Function;
import xcl.oa.type.vo.Type;

public class Record implements Serializable{
	private Integer recordID;//关联id
	private Type type;//外键角色表
	private Function function;//外键功能表
	public Integer getRecordID() {
		return recordID;
	}
	public void setRecordID(Integer recordID) {
		this.recordID = recordID;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Function getFunction() {
		return function;
	}
	public void setFunction(Function function) {
		this.function = function;
	}
}
