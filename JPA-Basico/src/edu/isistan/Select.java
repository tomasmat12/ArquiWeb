package edu.isistan;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.isistan.dao.Persona;

public class Select {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example"); // Se saca del persistence.xml  --> <persistence-unit name="Example">
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Persona per = em.find(Persona.class, 1);
		System.out.println(per);
		@SuppressWarnings({ "unused", "unchecked" })
		List<Persona> personas = em.createQuery("SELECT p FROM Persona p").getResultList();
		personas.forEach(p -> System.out.println(p));
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		
	}

}
