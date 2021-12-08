package com.koreait.ex09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.ex09.command.ContactDeleteCommand;
import com.koreait.ex09.command.ContactInsertCommand;
import com.koreait.ex09.command.ContactListCommand;
import com.koreait.ex09.command.ContactUpdateCommand;
import com.koreait.ex09.command.ContactViewCommand;
import com.koreait.ex09.dto.Contact;

@Controller
@RequestMapping(value="contact")
public class ContactController {

	// field
	private ContactListCommand contactListCommand;
	private ContactViewCommand contactViewCommand;
	private ContactInsertCommand contactInsertCommand;
	private ContactUpdateCommand contactUpdateCommand;
	private ContactDeleteCommand contactDeleteCommand;
	
	public ContactController(ContactListCommand contactListCommand, ContactViewCommand contactViewCommand,
			ContactInsertCommand contactInsertCommand, ContactUpdateCommand contactUpdateCommand,
			ContactDeleteCommand contactDeleteCommand) {
		super();
		this.contactListCommand = contactListCommand;
		this.contactViewCommand = contactViewCommand;
		this.contactInsertCommand = contactInsertCommand;
		this.contactUpdateCommand = contactUpdateCommand;
		this.contactDeleteCommand = contactDeleteCommand;
	}

	// method
	@GetMapping(value="findAllContact")
	public String findAllContact(Model model) {
		contactListCommand.execute(model);
		return "contact/list";
	}
	
	@GetMapping(value="contactPage")
	public String contactPage() {
		return "contact/insert";
	}
	
	@PostMapping(value="addContact")
	public String addContact(Contact contact, Model model) {
		model.addAttribute("contact", contact);
		contactInsertCommand.execute(model);
		return "redirect:findAllContact";
	}
	
	@GetMapping(value="findContact")
	public String findContact(Contact contact, Model model) {
		model.addAttribute("contact", contact);
		contactViewCommand.execute(model);
		return "contact/detail";
	}
	
	@GetMapping(value="updateContact")
	public String updateContact(Contact contact, Model model) {
		model.addAttribute("contact", contact);
		contactUpdateCommand.execute(model);
		return "redirect:findContact?no=" + contact.getNo();
	}
	
	@GetMapping(value="deleteContact")
	public String deleteContact(Contact contact, Model model) {
		model.addAttribute("contact", contact);
		contactDeleteCommand.execute(model);
		return "redirect:findAllContact";
	}
	
}