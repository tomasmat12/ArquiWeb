package edu.isistan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.isistan.dao.Direccion;
import edu.isistan.dao.Persona;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example"); // Se saca del persistence.xml  --> <persistence-unit name="Example">
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Direccion dire = new Direccion ("Tandil","Av Brasil 148");
		em.persist(dire);
		Persona pers1 = new Persona(1,"Mati",35, dire);
		Persona pers2 = new Persona(2,"Vale",33, dire);
		em.persist(pers1);
		em.persist(pers2);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

}
