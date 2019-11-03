package uni.fmi.masters.repository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.exceptions.TransactionException;

import uni.fmi.masters.beans.UserBean;

public class JPAUserRepository {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("UserPU");
		
		return factory.createEntityManager();
	}
	
	public boolean createUser(UserBean user) {
		EntityManager em = getEntityManager();
		
		user.setPassword(hashMe(user.getPassword()));
		
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();	
		
		}catch(TransactionException e) {
			em.getTransaction().rollback();
			
			System.err.println(e.getMessage());
			return false;			
		}finally {
			em.close();
		}
		
		return  true;		
	}
	
	public UserBean loginUser(String username, String password) {
		
		EntityManager em = getEntityManager();
		
		password = hashMe(password);
		
		String query = "SELECT u FROM UserBean u WHERE "
				+ "u.username = :user AND u.password = :pass";
		
		TypedQuery<UserBean> q = em.createQuery(query, UserBean.class);
		
		q.setParameter("user", username);
		q.setParameter("pass", password);
		
		List<UserBean> result = q.getResultList();
		
		em.close();
		
		return result.isEmpty() ? null : result.get(0);
		
	}
	
	private String hashMe(String text) {
		
		StringBuilder sb = new StringBuilder();
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			md.update(text.getBytes());
			
			byte[] bytes = md.digest();
			
			for(int i = 0; i < bytes.length; i++) {
				sb.append((char)bytes[i]);
			}
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		return sb.toString();
		
	}

}
