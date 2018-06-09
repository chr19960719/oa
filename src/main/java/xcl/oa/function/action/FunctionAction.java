package xcl.oa.function.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import xcl.oa.function.vo.Function;

public class FunctionAction extends ActionSupport implements ModelDriven<Function>{

	private  Function function = new Function();
	public Function getModel() {	
		return function;
	}

}
