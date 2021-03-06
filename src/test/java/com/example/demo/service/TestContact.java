package com.example.demo.service;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.transaction.Transactional;
import org.springframework.test.context.jdbc.Sql;

/**
 * Use to avoid of reoccurrence Sql and Transactional annotations in each testing method of class
 * that test methods from ContactService interface
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Sql("/test-data-contact.sql")
@Sql(scripts = "/test-clean-table.sql",
    executionPhase = AFTER_TEST_METHOD)
@Transactional
public @interface TestContact {

}
