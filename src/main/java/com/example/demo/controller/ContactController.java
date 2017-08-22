package com.example.demo.controller;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class ContactController {

  private ContactService contactService;

  @Autowired
  public void setContactService(ContactService contactService) {
    this.contactService = contactService;
  }

  /**
   * Gets contacts that DO NOT match the nameFilter param
   * @param regex is the regular expression that is received as request param
   * @return contacts that DO NOT math regex
   */
  @GetMapping(value = "/contacts", produces = "application/json")
  public Iterable<Contact> getContacts(
      @RequestParam(value = "nameFilter") String regex)  {
      return contactService.getContactsNotByRegex(regex);
  }
}
