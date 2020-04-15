package model;

public class Total {
	
	private String item_name;
	private int item_total;

	public Total(String item_name, int item_total) {
		this.item_name = item_name;
		this.item_total = item_total;
	}
	
	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_total() {
		return item_total;
	}

	public void setItem_total(int item_total) {
		this.item_total = item_total;
	}
}