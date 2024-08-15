package com.trungtamjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.trungtamjava.model.User;

//@Component
@Repository  // Tao ra 1 doi tuong new UserDaoImpl() - BEAN Spring Container
//@Service
public class UserDaoImpl  implements UserDao {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public void add(User user) throws SQLException {
		String sql = "INSERT INTO user(username, password, name, role) VALUES (?, ?, ?, ?);";
		Connection conn = dataSource.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);

		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getName());
		preparedStatement.setString(4, user.getRole());

		preparedStatement.executeUpdate();
	}

	@Override
	public void update(User user) throws SQLException {
		String sql = "UPDATE user SET username = ?, password = ? , name = ?, role = ? WHERE id = ?";
		Connection conn = dataSource.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);

		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getName());
		preparedStatement.setString(4, user.getRole());
		preparedStatement.setInt(5, user.getId());

		preparedStatement.executeUpdate();
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM user WHERE id = ?";

		Connection conn = dataSource.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);

		preparedStatement.setInt(1, id);

		preparedStatement.executeUpdate();
	}

	@Override
	public User get(int id) {
		try {
			String sql = "SELECT * FROM user WHERE id = ?";

			Connection conn = dataSource.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User c = new User();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setRole(rs.getString("role"));
				return c;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getByUsername(String username) {
		try {
			String sql = "SELECT * FROM user WHERE username = ?";

			Connection conn = dataSource.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User c = new User();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setRole(rs.getString("role"));
				return c;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> search(String name) throws SQLException {
		List<User> users = new ArrayList<User>();

		String sql = "SELECT * FROM user WHERE username LIKE ?";

		Connection conn = dataSource.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);

		preparedStatement.setString(1, "%" + name + "%");

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			users.add(rowMapper(resultSet));
		}

		return users;
	}

	private User rowMapper(ResultSet rs) throws SQLException {
		User c = new User();

		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setUsername(rs.getString("username"));
		c.setPassword(rs.getString("password"));
		c.setRole(rs.getString("role"));

		return c;
	}

}
