package uni.fmi.masters.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import uni.fmi.masters.beans.CommentBean;
import uni.fmi.masters.beans.UserBean;

public class JPACommentRepository extends BaseRepository<CommentBean>{

	public JPACommentRepository() {
		super(CommentBean.class);
	}
	
	public List<CommentBean> getAllCommentsByUser(UserBean user){
		
		EntityManager em = getEntityManager();
		
		List<CommentBean> result = new ArrayList<>();
		
		try {
			String q = "FROM CommentBean WHERE user.id = :userid";
			
			TypedQuery<CommentBean> query = 
					em.createQuery(q, CommentBean.class);
			
			query.setParameter("userid", user.getId());
			
			result = query.getResultList();
			
		}catch(Exception e) {
			
			System.err.println(e.getMessage());
			
		}finally {
			em.close();
		}
		
		return result;
		
	}
	

}
