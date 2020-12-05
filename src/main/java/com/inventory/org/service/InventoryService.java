package com.inventory.org.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.org.dto.ItemDto;
import com.inventory.org.model.CreateItemRequest;
import com.inventory.org.model.UpdateItemRequest;

@Service
public interface InventoryService {
	
	public List<ItemDto> getItems();
	
	public ItemDto getItem(String itemId);
	
	public String createItem(CreateItemRequest req);
	
	public String updateItem(UpdateItemRequest req);
	
	public String deleteItem(String itemId);

}
