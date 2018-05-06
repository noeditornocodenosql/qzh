package com.qianhe.service;

import java.util.List;
import com.qianhe.model.Page;
import com.qianhe.model.Record;

public interface RecordService {
	
	public List<Record> findAllRecords(Page page);
	public void savaRecord(String message,String operator);
	public int findAllRecordCounts();

}
