package com.inventory.org.row.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.inventory.org.model.Item;
@Component
public class ItemRowMapper implements RowMapper<Item> {

	@Override
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setItemId(rs.getInt("ITEM_ID"));
        item.setItemDesc(rs.getString("ITEM_DESC"));
        item.setItemName(rs.getString("ITEM_NAME"));
        item.setItemCount(rs.getString("ITEM_COUNT"));
		return item;
	}

}
