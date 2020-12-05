package com.inventory.org.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.org.dao.InventoryDao;
import com.inventory.org.dto.ItemDto;
import com.inventory.org.model.CreateItemRequest;
import com.inventory.org.model.Item;
import com.inventory.org.model.UpdateItemRequest;
import com.inventory.org.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryDao inventoryDao;

	@Override
	public List<ItemDto> getItems() {
		List<Item> items = inventoryDao.getItems();
		return items.stream().map(item -> {
			ItemDto itemDto = new ItemDto();
			BeanUtils.copyProperties(item, itemDto);
			return itemDto;
		}).collect(Collectors.toList());
	}

	@Override
	public ItemDto getItem(String itemId) {
		Item item = inventoryDao.getItem(itemId);
		ItemDto itemDto = new ItemDto();
		BeanUtils.copyProperties(item, itemDto);
		return itemDto;
	}

	@Override
	public String createItem(CreateItemRequest req) {
		return inventoryDao.createItem(req);
	}

	@Override
	public String updateItem(UpdateItemRequest req) {
		return inventoryDao.updateItem(req);
	}

	@Override
	public String deleteItem(String itemId) {
		return inventoryDao.deleteItem(itemId);
	}

}
