package com.qianhe.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.qianhe.mapper.RecordMapper;
import com.qianhe.model.Page;
import com.qianhe.model.Record;
import com.qianhe.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService{
	
	@Resource
	private RecordMapper recordMapper;

	@Override
	public List<Record> findAllRecords(Page page) {
		return recordMapper.findAllRecords(page);
	}

	@Override
	public void savaRecord(String message,String operator) {
		Record record=new Record();
		record.setMessage(message);
		record.setTime(new Date());
		record.setOperator(operator);
		recordMapper.savaRecord(record);
		
	}

	@Override
	public int findAllRecordCounts() {
		return recordMapper.findAllRecordCounts();
	}


}
