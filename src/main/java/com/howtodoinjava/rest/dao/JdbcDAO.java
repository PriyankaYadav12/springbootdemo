package com.howtodoinjava.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.howtodoinjava.rest.JDBC.ConnectionFact;
import com.howtodoinjava.rest.model.DevopsEmployee;

@Repository
public class JdbcDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	public JdbcDAO() {

	}

	private Connection getConnection() throws SQLException {
		//Connection conn;
		
		Connection conn = null;
		
		String driverClassName = "com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/Devops";
		String dbUser = "root";
		String dbPwd = "Root@123";  
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		//conn = ConnectionFact.getInstance().getConnection(); //coming from jdbcDAO
		return conn;
		
	}
	public void add(DevopsEmployee devopsEmployee) {
		try {
			String queryString = "INSERT INTO devops(id, firstName, lastName, email) VALUES(?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, devopsEmployee.getId());
			ptmt.setString(2, devopsEmployee.getFirstName());
			ptmt.setString(3, devopsEmployee.getLastName());
			ptmt.setString(4, devopsEmployee.getEmail());
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	public void update(DevopsEmployee devopsEmployee) {

		try {
			String queryString = "UPDATE devops SET Name=? WHERE id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, devopsEmployee.getFirstName());
			ptmt.setInt(2, devopsEmployee.getId());
			ptmt.executeUpdate();
			System.out.println("Table Updated Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
	
	public void delete(int id) {

		try {
			String queryString = "DELETE FROM devops WHERE id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			ptmt.executeUpdate();
			System.out.println("Data deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	public String findAll() {
		
		try {
			String queryString = "SELECT * FROM devops";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("id " + resultSet.getInt("id")
						+ ", firstName " + resultSet.getString("firstName") + ", lastName "
						+ resultSet.getString("lastName") + ", email "
						+ resultSet.getString("Email"));
			}
			return "ffg";
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
	


