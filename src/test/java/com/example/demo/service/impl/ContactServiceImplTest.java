package com.example.demo.service.impl;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;
import com.example.demo.service.TestContact;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ContactServiceImplTest {

  @Autowired
  private ContactService contactService;

  @TestContact
  @Test
  public void getContactsNotByRegex_Regex_returnContacts() {
    //Arrange
    final int EXPECTED_CONTACT_COUNT = 4;
    final String REGEX = "^A.*$";

    //Act
    Iterable<Contact> contacts = contactService.getContactsNotByRegex(REGEX);
    final int RESULT_SIZE = (int) contacts.spliterator().getExactSizeIfKnown();

    //Assert
    Assert.assertEquals(EXPECTED_CONTACT_COUNT, RESULT_SIZE);
  }

  @TestContact
  @Test
  public void getContactsNotByRegex_RegexWithNoContacts_returnEmptyResult() {
    //Arrange
    final int EXPECTED_CONTACT_COUNT = 0;
    final String REGEX = "^.*[aei].*$";

    //Act
    Iterable<Contact> contacts = contactService.getContactsNotByRegex(REGEX);
    final int RESULT_SIZE = (int) contacts.spliterator().getExactSizeIfKnown();

    //Assert
    Assert.assertEquals(EXPECTED_CONTACT_COUNT, RESULT_SIZE);
  }
}
