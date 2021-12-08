package com.koreait.ex09.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.ex09.dao.ContactDAO;
import com.koreait.ex09.dto.Contact;

public class ContactListCommand implements ContactCommand {

	@Autowired
	private ContactDAO contactDAO;
	
	@Override
	public void execute(Model model) {
		
		List<Contact> list = contactDAO.selectContactList();
		model.addAttribute("list", list);

	}

}
