package com.inventory.org.dao.impl;

import java.sql.Types;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.inventory.org.dao.InventoryDao;
import com.inventory.org.model.CreateItemRequest;
import com.inventory.org.model.Item;
import com.inventory.org.model.UpdateItemRequest;
import com.inventory.org.row.mapper.ItemRowMapper;
@Repository
public class InventoryDaoImpl extends JdbcDaoSupport implements InventoryDao {

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public List<Item> getItems() {
		String sql = "select * from inventory.item";
		return getJdbcTemplate().query(sql, new ItemRowMapper());
	}

	@Override
	public Item getItem(String itemId) {
		String sql = "select * from inventory.item where item_id = ?";
		return getJdbcTemplate().queryForObject(sql, new Object[] {Integer.parseInt(itemId)}, new ItemRowMapper());
	}

	@Override
	public String createItem(CreateItemRequest req) {

		String sql = "insert into inventory.item (ITEM_NAME, " + "    ITEM_DESC, " + "    ITEM_COUNT) "
				+ "VALUES (?, ?, ?)";
		Object[] params = new Object[] { req.getItemName(), req.getItemDesc(), req.getItemCount() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		int row = getJdbcTemplate().update(sql, params, types);
		return row == 1 ? "SUCCESS" : "FAILURE";
	}

	@Override
	public String updateItem(UpdateItemRequest req) {
		String sql = "update inventory.item Set ITEM_NAME = ?,ITEM_DESC = ?,ITEM_COUNT = ? where ITEM_ID = ?";
		Object[] params = new Object[] { req.getItemName(), req.getItemDesc(), req.getItemCount(),req.getItemId()};
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.INTEGER};
		int row = getJdbcTemplate().update(sql, params, types);
		return row == 1 ? "SUCCESS" : "FAILURE";
	}

	@Override
	public String deleteItem(String itemId) {
		String sql = "delete from inventory.item where item_id = ?";
		int[] types = new int[] { Types.INTEGER};
		int row = getJdbcTemplate().update(sql, new Object[] {Integer.parseInt(itemId)}, types);
		return row == 1 ? "SUCCESS" : "FAILURE";
	}

}
