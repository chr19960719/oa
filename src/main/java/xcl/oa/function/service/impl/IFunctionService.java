package xcl.oa.function.service.impl;

import xcl.oa.function.dao.FunctionDao;
import xcl.oa.function.service.FunctionService;

public class IFunctionService implements FunctionService{
	
	private FunctionDao functionDao;
	public void setFunctionDao(FunctionDao functionDao) {
		this.functionDao = functionDao;
	}

}
