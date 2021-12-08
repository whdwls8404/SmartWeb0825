package com.koreait.ex09.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex09.dao.ContactRepository;
import com.koreait.ex09.dto.Contact;

public class ContactServiceImpl implements ContactService {

	// field
	@Autowired
	private ContactRepository repository;
	
	@Override
	public List<Contact> findAllContact() {
		return repository.selectContactList();
	}
	
	@Override
	public void addContact(Contact contact) {
		repository.insertContact(contact);
	}

	@Override
	public Contact findContact(Contact contact) {
		return repository.selectContactByNo(contact);
	}
	
	@Override
	public void updateContact(Contact contact) {
		repository.updateContact(contact);
	}
	
	@Override
	public void deleteContact(Contact contact) {
		repository.deleteContact(contact);
	}
	
}