package com.jsp.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.pan.Pan;
import com.jsp.person.Person;

public class PersonController {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("milind");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
//		By using one to one unidirectional relation we can create connection between two tables
//		i.e. we can have foreign key to establish connection in between two tables
		
		Pan pan = new Pan();
		pan.setPan_no("KKYUH0000A");
		
		Person person = new Person();
		person.setName("Pawan");
		person.setDob("11/11/2000");
		person.setPan(pan);
		
		entityTransaction.begin();
		entityManager.persist(pan);       //insert into object 1
		entityManager.persist(person);    //insert into object 2
		entityTransaction.commit();
		
		System.out.println("All good");
	}
}
