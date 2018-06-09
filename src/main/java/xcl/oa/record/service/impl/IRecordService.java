package xcl.oa.record.service.impl;

import org.springframework.transaction.annotation.Transactional;

import xcl.oa.function.dao.FunctionDao;
import xcl.oa.function.vo.Function;
import xcl.oa.record.dao.RecordDao;
import xcl.oa.record.service.RecordService;
import xcl.oa.record.vo.Record;
import xcl.oa.type.dao.TypeDao;
import xcl.oa.type.vo.Type;

@Transactional
public class IRecordService implements RecordService{
	private RecordDao recordDao;
	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}
	private FunctionDao functionDao;
	public void setFunctionDao(FunctionDao functionDao) {
		this.functionDao = functionDao;
	}
	private TypeDao typeDao;
	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}
	@Override
	public void updata(Integer id) {
		recordDao.updata(id);
	}
	@Override
	public void add(Integer typeID, String function) {
		Record record = new Record();
		Type type = typeDao.findById(typeID);
		record.setType(type);
		String[] fid = function.split(",");
		for(int i=0;i<fid.length;i++) {
			Integer functionID = Integer.valueOf(fid[i]);
			Function f = functionDao.findById(functionID);
			record.setFunction(f);
			recordDao.save(record);
		}
	}
}
