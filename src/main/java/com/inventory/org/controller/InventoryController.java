package com.inventory.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.org.dto.ItemDto;
import com.inventory.org.model.CreateItemRequest;
import com.inventory.org.model.UpdateItemRequest;
import com.inventory.org.service.InventoryService;

@RestController
@RequestMapping(value = "/inventories/")
public class InventoryController {
	@Autowired
	InventoryService inventoryService;

	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<ItemDto>> getItems() {
		return ResponseEntity.ok(inventoryService.getItems());
	}

	@RequestMapping(value = "/items/{itemId}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<ItemDto> getItem(@PathVariable("itemId") String itemId) {
		return ResponseEntity.ok(inventoryService.getItem(itemId));
	}

	@RequestMapping(value = "/items/create", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> createItem(@RequestBody CreateItemRequest req) {
		return ResponseEntity.ok(inventoryService.createItem(req));
	}

	@RequestMapping(value = "/items/{itemId}/update", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<String> updateItem(@RequestBody UpdateItemRequest req,
			@PathVariable("itemId") Integer itemId) {
		req.setItemId(itemId);
		return ResponseEntity.ok(inventoryService.updateItem(req));
	}

	@RequestMapping(value = "/items/{itemId}/delete", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<String> deleteItem(@PathVariable("itemId") String itemId) {
		return ResponseEntity.ok(inventoryService.deleteItem(itemId));
	}
}
