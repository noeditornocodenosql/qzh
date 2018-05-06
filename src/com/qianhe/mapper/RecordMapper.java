package com.qianhe.mapper;

import java.util.List;

import com.qianhe.model.Page;
import com.qianhe.model.Record;

public interface RecordMapper {

	public List<Record> findAllRecords(Page page);
	public void savaRecord(Record record);
	public int findAllRecordCounts();
	
}
