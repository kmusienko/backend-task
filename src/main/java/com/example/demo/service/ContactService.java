package com.example.demo.service;

import com.example.demo.entity.Contact;

public interface ContactService {

  Iterable<Contact> getContactsNotByRegex(String regex);

}
