package service;

import java.util.List;

import model.Joy;

public interface Joy_Service {

	public List<Joy> getJoys();
	public boolean createJoy(Joy joy);
	public List<Joy> getJoyByID(Joy joy);
	public boolean updateJoy(Joy joy);
	public boolean deleteJoy(Joy joy);
}