package com.qianhe.service.impl;

import com.qianhe.mapper.ContactMapper;
import com.qianhe.model.Contact;
import com.qianhe.service.ContactService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ContactServiceImpl implements ContactService {

	@Resource
	private ContactMapper contactMapper;

	public Contact getAllContact() {
		return this.contactMapper.getAllContact();
	}

	@Override
	public void updateContact(Contact contact) {
		contactMapper.updateContact(contact);
	}
}
