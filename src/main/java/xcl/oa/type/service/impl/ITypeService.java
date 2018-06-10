package xcl.oa.type.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import xcl.oa.type.dao.TypeDao;
import xcl.oa.type.service.TypeService;
import xcl.oa.type.vo.Type;

@Transactional
public class ITypeService implements TypeService{

	@Autowired
	private TypeDao typeDao;
	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}
	
	@Override
	public Type findById(Integer typeID) {
		return typeDao.findById(typeID);
	}
	
	//service层查找所有角色
	public List<Type> findAll(){
		return typeDao.findAll();
	}
	
}
