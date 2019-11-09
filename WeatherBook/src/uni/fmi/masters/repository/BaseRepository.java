package uni.fmi.masters.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.exceptions.TransactionException;

public abstract class BaseRepository<T> {

	private Class<T> typeParameter;
	
	public BaseRepository(Class<T> typeParameter) {
		this.typeParameter = typeParameter;
	}
	
	public EntityManager getEntityManager() {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("UserPU");
		
		return factory.createEntityManager();		
	}
	
	public boolean insert(T entity) {
		EntityManager em = getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			
			return true;
		}catch(TransactionException e) {
			em.getTransaction().rollback();
			
			return false;
		}finally {
			em.close();
		}		
	}
	
	public boolean update(T entity) {
		
		EntityManager em = getEntityManager();
		
		
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			
			return true;		
		}catch(TransactionException e) {
			
			em.getTransaction().rollback();
			return false;
			
		}finally {
			em.close();
		}	
	}
	
	public boolean delete (T entity) {
		EntityManager em = getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			
			return true;
		}catch(TransactionException e) {
			System.err.println(e.getMessage());
			
			return false;
		}finally {
			em.close();
		}
	}
	
	public T findById(int id) {
		
		EntityManager em = getEntityManager();
		
		T result = em.find(typeParameter, id);
		
		em.close();		
		return result;
		
	}
	
	public List<T> findAllBy(String column, String value){
		
		EntityManager em = getEntityManager();
		
		try {
			String q = "SELECT entity FROM " + typeParameter.getSimpleName()
			
				+ " entity WHERE " + column + " = '" + value  + "'";
			
			TypedQuery<T> query = em.createQuery(q, typeParameter);
			
			return query.getResultList();
		}finally {
			em.close();
		}
		
	}
	
	
	
}
