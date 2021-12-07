package com.koreait.ex08.service;

import java.util.List;

import com.koreait.ex08.domain.Contact;

public interface ContactService {
	public List<Contact> findAllContact();
	public void addContact(Contact contact);
	public Contact findContact(Contact contact);
	public void updateContact(Contact contact);
	public void deleteContact(Contact contact);
}
