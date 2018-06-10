package xcl.oa.type.dao;

import java.util.List;

import xcl.oa.type.vo.Type;

public interface TypeDao {
	Type findById(Integer typeID);
	//dao层查找所有角色
	public List<Type> findAll();
}
