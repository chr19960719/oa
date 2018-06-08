package xcl.oa.type.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import xcl.oa.employee.vo.Employee;
import xcl.oa.record.vo.Record;
import xcl.oa.type.service.TypeService;
import xcl.oa.type.vo.Type;

public class TypeAction extends ActionSupport implements ModelDriven<Type>{

	private Type type = new Type();
	public Type getModel() {
		return type;
	}
	
	private TypeService typeService;
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
	
	private Map<String,Object> result;
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	public String getFunction() {
		result = new HashMap<String, Object>();
		Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		Type t = typeService.findById(e.getUserLevel());
		Set<Record> set = t.getRecords();
		result.put("power", set);
		result.put("type", t);
		return SUCCESS;
	}

}
