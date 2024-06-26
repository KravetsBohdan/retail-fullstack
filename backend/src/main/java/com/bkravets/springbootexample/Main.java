package com.bkravets.springbootexample;

import com.bkravets.springbootexample.customer.Customer;
import com.bkravets.springbootexample.customer.CustomerDao;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(@Qualifier("jdbc") CustomerDao customerDao) {
        return args -> {

            Faker faker = new Faker();

            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String fullName = firstName + " " + lastName;
            String email = firstName.toLowerCase() + "." +  lastName.toLowerCase() + "@gmail.com";
            int age = faker.number().numberBetween(16, 99);

            Customer randomCustomer = new Customer(fullName, email, age);

            customerDao.insertCustomer(randomCustomer);


        };
    }

































}
