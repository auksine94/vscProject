package controller;

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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class Controller {
	
	@Autowired
	private Joy_Service joyService;

	@GetMapping("joys-list")
	public List<Joy> alljoys() {
		return joyService.getJoys();
	}
	
	@PostMapping("create-joy")
	public boolean createJoy(@RequestBody Joy joy) {
		return joyService.createJoy(joy);
	}

	@GetMapping("joy/{joy_id}")
	public List<Joy> alljoyByID(@PathVariable("joy_id") int joy_id, Joy joy) {
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
		joy.setJoy_id(joy_id);
		return joyService.deleteJoy(joy);
	}
}