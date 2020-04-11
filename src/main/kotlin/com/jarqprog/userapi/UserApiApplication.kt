package com.jarqprog.userapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UserApiApplication

fun main(args: Array<String>) {
	runApplication<UserApiApplication>(*args)
}


//repository.deleteAll()
//        // save a couple of customers
//        repository.save(new UserTemp("Alice", "Smith"));
//        repository.save(new UserTemp("Bob", "Smith"));
//
//        // fetch all customers
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        for (UserTemp customer : repository.findAll()) {
//            System.out.println(customer);
//        }
//        System.out.println();
//
//        // fetch an individual customer
//        System.out.println("Customer found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByFirstName("Alice"));
//
//        System.out.println("Customers found with findByLastName('Smith'):");
//        System.out.println("--------------------------------");
//        for (UserTemp customer : repository.findByLastName("Smith")) {
//            System.out.println(customer);
//        }