package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Item;

@Repository
public class Item_DAO_Imp implements Item_DAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Item> getItems() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Item> query = currentSession.createQuery("from Item", Item.class);
		List<Item> list = query.getResultList();
		return list;
	}
	
	@Override
	public boolean createItem(Item item) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().save(item);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

//	@Override
//	public List<Joy> getJoyByID(Joy joy) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		Query<Joy> query = currentSession.createQuery("from Joy where joy_id=:joy_id", Joy.class);
//		query.setParameter("joy_id", joy.getJoy_id());
//		List<Joy> list = query.getResultList();
//		return list;
//	}
//
//	@Override
//	public boolean updateJoy(Joy joy) {
//		boolean status = false;
//		try {
//			sessionFactory.getCurrentSession().update(joy);
//			status = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return status;
//	}
//	
	@Override
	public boolean deleteItem(Item item) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().delete(item);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}