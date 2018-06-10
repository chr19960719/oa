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
	
	private Integer typeID;
	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}
	private String array;
	public void setArray(String array) {
		this.array = array;
	}
	
	public String updata() {
		System.out.println("typeID: "+typeID);
		System.out.println("array: "+array);
		recordService.updata(typeID);
		recordService.add(typeID, array);
		return null;
	}
	

}
