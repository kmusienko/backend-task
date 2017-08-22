package com.example.demo.service.impl;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{

  private ContactRepository contactRepository;

  @Autowired
  public void setContactRepository(ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }

  /**
   * Gets contacts that DO NOT match the regular expression
   * @param regex is the regular expression
   * @return contacts
   */
  @Override
  public Iterable<Contact> getContactsNotByRegex(String regex) {
    List<Contact> contactsNotByRegex = new ArrayList<>();
    Pattern pattern = Pattern.compile(regex);
    for (Contact contact : contactRepository.findAll()) {
      if (!pattern.matcher(contact.getName()).matches()) {
        contactsNotByRegex.add(contact);
      }
    }
    return contactsNotByRegex;
  }
}
