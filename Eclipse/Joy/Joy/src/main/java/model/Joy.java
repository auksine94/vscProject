package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "joy")
public class Joy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int joy_id;
	private String joy_name;
	private String joy_desc;
	private String joy_flag;
	private String joy_img_url;

	public int getJoy_id() {
		return joy_id;
	}

	public void setJoy_id(int joy_id) {
		this.joy_id = joy_id;
	}

	public String getJoy_name() {
		return joy_name;
	}

	public void setJoy_name(String joy_name) {
		this.joy_name = joy_name;
	}

	public String getJoy_desc() {
		return joy_desc;
	}

	public void setJoy_desc(String joy_desc) {
		this.joy_desc = joy_desc;
	}

	public String getJoy_flag() {
		return joy_flag;
	}

	public void setJoy_flag(String joy_flag) {
		this.joy_flag = joy_flag;
	}
	
	public String getJoy_img_url() {
		return joy_img_url;
	}

	public void setJoy_img_url(String joy_img_url) {
		this.joy_img_url = joy_img_url;
	}
}