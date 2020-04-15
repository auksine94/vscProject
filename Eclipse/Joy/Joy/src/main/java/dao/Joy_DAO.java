package dao;
//data access object
import java.util.List;

import model.Joy;

public interface Joy_DAO {

	public List<Joy> getJoys();
	public boolean createJoy(Joy joy);
	public List<Joy> getJoyByID(Joy joy);
	public boolean updateJoy(Joy joy);
	public boolean deleteJoy(Joy joy);
}