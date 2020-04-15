package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Joy;
import service.Joy_Service;

import model.Item;
import service.Item_Service;

import model.Total;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class Controller {
	
	@Autowired
	private Joy_Service joyService;
	@Autowired
	private Item_Service itemService;

	@GetMapping("joys-list")
	public List<Joy> allJoys() {
		return joyService.getJoys();
	}
	
	@PostMapping("create-joy")
	public boolean createJoy(@RequestBody Joy joy) {
		return joyService.createJoy(joy);
	}

	@GetMapping("joy/{joy_id}")
	public List<Joy> allJoyById(@PathVariable("joy_id") int joy_id, Joy joy) {
		joy.setJoy_id(joy_id);
		return joyService.getJoyByID(joy);
	}

	@PostMapping("update-joy/{joy_id}")
	public boolean updateJoy(@RequestBody Joy joy, @PathVariable("joy_id") int joy_id) {
		joy.setJoy_id(joy_id);
		return joyService.updateJoy(joy);
	}
	
	@DeleteMapping("delete-joy/{joy_id}")
	public boolean deleteJoy(@PathVariable("joy_id") int joy_id, Joy joy) {
		deleteItemsOfJoy(joy_id);
		joy.setJoy_id(joy_id);
		return joyService.deleteJoy(joy);
	}
	
	//deleting items together with joy
	public boolean deleteItemsOfJoy(int parent_item_id) {
		List<Item> allItems = allItems();
		
		for (Item item : allItems) {
			if (item.getItem_parent_id() == parent_item_id) {
//				System.out.println(item.getItem_name());
				itemService.deleteItem(item);
			}
		}
		return true;
	}
	
	@GetMapping("items")
	public List<Item> allItems() {
		return itemService.getItems();
	}
	
	@PostMapping("create-item")
	public boolean createItem(@RequestBody Item item) {
		return itemService.createItem(item);
	}
	
	@DeleteMapping("delete-item/{item_id}")
	public boolean deleteItem(@PathVariable("item_id") int item_id, Item item) {
		item.setItem_id(item_id);
		return itemService.deleteItem(item);
	}
	
	@GetMapping("totals")
	public List<Item> allTotals() {
		List<Item> allItems = allItems();
		List<Item> totalItems = allItems();
//		List<Total> totals = new ArrayList<Total>();
		
		for (Item a : allItems) {
			for (Item t : totalItems) {
				
			}
		}		
				
//				if (t.getItem_name().contentEquals(a.getItem_name())) {
//					totalItems.remove(t);
//					System.out.println(a.getItem_name() + "   " + t.getItem_name());
//				}
			
//			if (totals.isEmpty()) {
//				totals.add(new Total(all.getItem_name(), all.getItem_amount()));
//				System.out.println("a");
//			}
//			
//			for (Total t : totals) {
//				
//				if(!all.getItem_name().equals(t.getItem_name())) {
//					totals.add(new Total(all.getItem_name(), all.getItem_amount()));
//					System.out.println("b");
//				}
//			
//			}

		System.out.println(totalItems);
		return totalItems;
	}
}