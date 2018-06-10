package xcl.oa.type.service;

import java.util.List;

import xcl.oa.type.vo.Type;

public interface TypeService {
	Type findById(Integer typeID);
	//service层查找所有角色
	public List<Type> findAll();
}
