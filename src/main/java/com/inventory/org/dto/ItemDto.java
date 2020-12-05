package com.inventory.org.dto;
import java.io.Serializable;

public class ItemDto implements Serializable {

	private static final long serialVersionUID = -6077012587854377363L;
	
	private Integer itemId;
	private String itemName;
	private String itemCount;
	private String itemDesc;
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
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
