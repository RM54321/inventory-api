package com.inventory.org.model;

import java.io.Serializable;

public class CreateItemRequest implements Serializable {

	private static final long serialVersionUID = -7329996524957487912L;

	private String itemName;
	private String itemCount;
	private String itemDesc;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCount() {
		return itemCount;
	}

	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
}
