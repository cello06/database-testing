package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;

import java.sql.*;
import java.util.*;

public class DBUtils {

	private static final Logger LOGGER = LogManager.getLogger(DBUtils.class);

	private static final String URL = ConfigManager.getProperty("db_URL");

	private static final String USERNAME = ConfigManager.getProperty("db_username");

	private static final String PASSWORD = System.getenv("db_password");

	static {
		try {
			Class.forName("org.postgresql.Driver");
			LOGGER.info("Postgresql JDBC driver is loaded");
		}
		catch (ClassNotFoundException e) {
			LOGGER.error("Postgresql JDBC driver is not loaded");
		}
	}

	public static Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		catch (SQLException e) {
			LOGGER.error("Connection object can not be received");
			throw new SQLException();
		}
	}

	public static <T> List<T> executeQuery(String query, RowMapper<T> rowMapper) {
		List<T> resultList = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet rs = preparedStatement.executeQuery();) {
			while (rs.next()) {
				resultList.add(rowMapper.mapRow(rs));
			}
		}
		catch (Exception e) {
			LOGGER.error("Problem occurred in executeQuery method!");
		}
		return resultList;
	}

	public static List<Map<String, Object>> executeQuery(String query) {
		List<Map<String, Object>> resultList = new ArrayList<>();

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet rs = preparedStatement.executeQuery();) {

			ResultSetMetaData metaData = rs.getMetaData();

			while (rs.next()) {
				Map<String, Object> currentRow = new HashMap<>();
				int countOfColumn = metaData.getColumnCount();

				for (int i = 1; i <= countOfColumn; i++) {
					currentRow.put(metaData.getColumnName(i), rs.getObject(i));
				}
				resultList.add(currentRow);
			}

		}
		catch (Exception e) {
			LOGGER.error("Error in executeQuery method (return type : Map list)");
		}

		return resultList;
	}

}
