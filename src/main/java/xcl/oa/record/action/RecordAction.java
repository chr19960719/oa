package xcl.oa.record.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import xcl.oa.record.service.RecordService;
import xcl.oa.record.vo.Record;

public class RecordAction extends ActionSupport implements ModelDriven<Record>{

	private Record record = new Record();
	public Record getModel() {
		return record;
	}
	
	private RecordService recordService;
	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}
	
	private String typeID;
	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}
	private String function;
	public void setFunction(String function) {
		this.function = function;
	}
	
	public String updata() {
		recordService.updata(Integer.valueOf(typeID));
		recordService.add(Integer.valueOf(typeID), function);
		return null;
	}
	

}
