package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.Joy_DAO;
import model.Joy;

@Service
@Transactional
public class Joy_Service_Imp implements Joy_Service {

	@Autowired
	private Joy_DAO joyDao;

	@Override
	public List<Joy> getJoys() {
		return joyDao.getJoys();
	}
	
	@Override
	public boolean createJoy(Joy joy) {
		return joyDao.createJoy(joy);
	}
	
	@Override
	public List<Joy> getJoyByID(Joy joy) {
		return joyDao.getJoyByID(joy);
	}

	@Override
	public boolean updateJoy(Joy joy) {
		return joyDao.updateJoy(joy);
	}

	@Override
	public boolean deleteJoy(Joy joy) {
		return joyDao.deleteJoy(joy);
	}
}