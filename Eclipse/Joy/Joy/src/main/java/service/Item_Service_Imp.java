package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.Item_DAO;
import model.Item;

@Service
@Transactional
public class Item_Service_Imp implements Item_Service {

	@Autowired
	private Item_DAO itemDao;

	@Override
	public List<Item> getItems() {
		return itemDao.getItems();
	}
	
	@Override
	public boolean createItem(Item item) {
		return itemDao.createItem(item);
	}
	
//	@Override
//	public List<Joy> getJoyByID(Joy joy) {
//		return joyDao.getJoyByID(joy);
//	}

//	@Override
//	public boolean updateJoy(Joy joy) {
//		return joyDao.updateJoy(joy);
//	}

	@Override
	public boolean deleteItem(Item item) {
		return itemDao.deleteItem(item);
	}
}