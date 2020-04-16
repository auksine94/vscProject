package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
//		1
		List<Item> groupedWithStream = groupWithStream(allItems);
//		2
        List<Item> groupedBasic = groupBasic(allItems);
//		3        
        List<Item> calculatedList = calculateItems(allItems);
		
		
		return calculatedList;
	}
//	1
    private static List<Item> groupWithStream(List<Item> items) {
        return items
                .stream()
                .collect(Collectors.groupingBy(Item::getItem_name, Collectors.summingInt(Item::getItem_amount)))
                .entrySet()
                .stream()
                .map(entry -> new Item(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
    
// 2   
    private static List<Item> groupBasic(List<Item> items) {
        Map<String, Integer> groupedNames = groupByName(items);
        
        return createItems(groupedNames);
    }

    private static Map<String, Integer> groupByName(List<Item> items) {
        Map<String, Integer> groupedNames = new HashMap<>();
        for (Item item : items) {
            int numberOfItems = groupedNames.getOrDefault(item.getItem_name(), 0);
            groupedNames.put(item.getItem_name(), numberOfItems + item.getItem_amount());
        }
        return groupedNames;
    }

    private static List<Item> createItems(Map<String, Integer> grouped) {
        List<Item> groupedItems = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : grouped.entrySet()) {
            groupedItems.add(new Item(entry.getKey(), entry.getValue()));
        }
        return groupedItems;
    }
	
//	3
    public static List<Item> calculateItems(List<Item> items) {
        Map<String, Integer> calculatedItems = new HashMap<>();
        for (Item item : items) {
            if (calculatedItems.containsKey(item.getItem_name())) {
                calculatedItems.put(item.getItem_name(), calculatedItems.get(item.getItem_name()) + item.getItem_amount());
            }
            else {
                calculatedItems.put(item.getItem_name(), item.getItem_amount());
            }
        }
        return createItems(calculatedItems);
    }
}