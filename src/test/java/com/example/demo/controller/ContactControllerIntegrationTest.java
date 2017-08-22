package com.example.demo.controller;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.service.TestContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ContactControllerIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @TestContact
  @Test
  public void getContacts_ByNotRegex_returnContacts() throws Exception {
    //Arrange
    final String[] EXPECTED_CONTACT_NAMES = {"Kostya", "Kiril", "Lev", "Max"};
    final int RESULT_SET_SIZE = 4;
    final String NAMEFILTER_REQUEST_PARAM = "^A.*$";
    final String TESTED_URL = "/hello/contacts";

    //Act && Assert
    mvc.perform(get(TESTED_URL)
        .param("nameFilter", NAMEFILTER_REQUEST_PARAM)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(RESULT_SET_SIZE)))
        .andExpect(jsonPath("$[*].name", containsInAnyOrder(EXPECTED_CONTACT_NAMES)));
  }

  @TestContact
  @Test
  public void getContacts_ByNotRegexWithNoContacts_returnEmptyResult() throws Exception {
    //Arrange
    final int RESULT_SET_SIZE = 0;
    final String NAMEFILTER_REQUEST_PARAM = "^.*[aei].*$";
    final String TESTED_URL = "/hello/contacts";

    //Act && Assert
    mvc.perform(get(TESTED_URL)
        .param("nameFilter", NAMEFILTER_REQUEST_PARAM)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(RESULT_SET_SIZE)));
  }

  @TestContact
  @Test
  public void getContacts_WithNoRegexParam_returnBadRequest() throws Exception {
    //Arrange
    final String TESTED_URL = "/hello/contacts";

    //Act && Assert
    mvc.perform(get(TESTED_URL)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

}
