package xcl.oa.type.vo;

import java.io.Serializable;
import java.util.Set;

import xcl.oa.record.vo.Record;

public class Type implements Serializable{
	private Integer typeID;//角色等级
	private String typeName;//角色名称
	private String typeInfo;//角色介绍
	private Set<Record> records;
	public Integer getTypeID() {
		return typeID;
	}
	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeInfo() {
		return typeInfo;
	}
	public void setTypeInfo(String typeInfo) {
		this.typeInfo = typeInfo;
	}
	public Set<Record> getRecords() {
		return records;
	}
	public void setRecords(Set<Record> records) {
		this.records = records;
	}
	
}
