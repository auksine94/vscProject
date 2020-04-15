package service;

import java.util.List;

import model.Item;

public interface Item_Service {

	public List<Item> getItems();
	public boolean createItem(Item item);
//	public List<Joy> getJoyByID(Joy joy);
//	public boolean updateJoy(Joy joy);
	public boolean deleteItem(Item item);
}