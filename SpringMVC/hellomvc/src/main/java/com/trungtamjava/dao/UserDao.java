package com.trungtamjava.dao;

import java.sql.SQLException;
import java.util.List;

import com.trungtamjava.model.User;

public interface UserDao {
	void add(User user) throws SQLException;

	void update(User user) throws SQLException;

	void delete(int id) throws SQLException;

	User get(int id);// duy nhat

	User getByUsername(String username);// unique,duy nhat

	List<User> search(String name) throws SQLException;

}
