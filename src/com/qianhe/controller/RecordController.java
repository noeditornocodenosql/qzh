package com.qianhe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qianhe.model.Page;
import com.qianhe.model.Record;
import com.qianhe.service.RecordService;

@Controller
public class RecordController {
	
	@Autowired
	private RecordService recordService;
	
	@RequestMapping({ "/b/record/{pageNow}" })
	public ModelAndView findAllRecords(@PathVariable Integer pageNow){
		ModelAndView mav=new ModelAndView("WEB-INF/backstage/managerlog");
		List<Record> recordList = null;
		Page page = null;
		int totalCount = (int) recordService.findAllRecordCounts();
		if (pageNow != null) {
			page = new Page(totalCount, pageNow);
			recordList = recordService.findAllRecords(page);
		} else {
			page = new Page(totalCount, 1);
			recordList = recordService.findAllRecords(page);
		}
		mav.addObject(page);
		mav.addObject(recordList);
		return mav;
	}

}
