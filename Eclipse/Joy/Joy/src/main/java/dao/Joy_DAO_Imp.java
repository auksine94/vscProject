package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Joy;

@Repository
public class Joy_DAO_Imp implements Joy_DAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Joy> getJoys() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Joy> query = currentSession.createQuery("from Joy", Joy.class);
		List<Joy> list = query.getResultList();
		return list;
	}
	
	@Override
	public boolean createJoy(Joy joy) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().save(joy);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Joy> getJoyByID(Joy joy) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Joy> query = currentSession.createQuery("from Joy where joy_id=:joy_id", Joy.class);
		query.setParameter("joy_id", joy.getJoy_id());
		List<Joy> list = query.getResultList();
		return list;
	}

	@Override
	public boolean updateJoy(Joy joy) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().update(joy);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public boolean deleteJoy(Joy joy) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().delete(joy);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}