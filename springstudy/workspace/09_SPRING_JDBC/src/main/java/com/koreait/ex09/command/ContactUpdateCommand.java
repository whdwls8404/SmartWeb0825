package com.koreait.ex09.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.ex09.dao.ContactDAO;
import com.koreait.ex09.dto.Contact;

public class ContactUpdateCommand implements ContactCommand {

	@Autowired
	private ContactDAO contactDAO;
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();	
		Contact contact = (Contact) map.get("contact");
		contactDAO.updateContact(contact);

	}

}
