package xcl.oa.record.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import xcl.oa.record.dao.RecordDao;
import xcl.oa.record.vo.Record;

public class IRecordDao extends HibernateDaoSupport implements RecordDao{

	@Override
	public void updata(Integer id) {
		String hql = "from Record r where r.type.typeID = ?";
		List<Record> list= this.getHibernateTemplate().find(hql,id);
		for(Record record: list) {
			System.out.println(record.getRecordID());
			this.getHibernateTemplate().delete(record);
		}
		this.getHibernateTemplate().flush();
		this.getHibernateTemplate().clear();
	}

	@Override
	public void save(Record record) {
		this.getHibernateTemplate().save(record);
	}
	
}
