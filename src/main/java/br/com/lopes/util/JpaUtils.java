package br.com.lopes.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

public class JpaUtils {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
	private static EntityManager entityManager = factory.createEntityManager();
	
	private static Logger log = Logger.getLogger(JpaUtils.class.getName());
	
	public static EntityManager getEntityManager() {
		
		if (entityManager == null || !entityManager.isOpen()){
			entityManager = factory.createEntityManager();			
		}
		return entityManager;
	}
	
	public void beginTransaction(){
        entityManager.getTransaction().begin();
    }
     
    public void commit(){
        entityManager.getTransaction().commit();
    }
     
    public void close(){
        entityManager.close();
        factory.close();
    }
     
    public void rollBack(){
        entityManager.getTransaction().rollback();
    }
        
}
