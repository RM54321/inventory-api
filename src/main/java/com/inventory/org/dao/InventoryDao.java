package com.inventory.org.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inventory.org.model.CreateItemRequest;
import com.inventory.org.model.Item;
import com.inventory.org.model.UpdateItemRequest;

@Repository
public interface InventoryDao {
	
	public List<Item> getItems();
	
	public Item getItem(String itemId);
	
    public String createItem(CreateItemRequest req);
	
	public String updateItem(UpdateItemRequest req);
	
	public String deleteItem(String itemId);

}
