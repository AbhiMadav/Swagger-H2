package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.model.ActionProperty;

public class DataServiceHelper {
	public static DataServiceHelper dataServiceHelper = null;
	private Connection con = null;
	DataSource dataSource = null;
	InitialContext initialContext = null;
	public static final String DB_URL = "jdbc:h2:C:/Users/amadav/workspace/DB/ActionConfiguration;IFEXISTS=TRUE;AUTO_SERVER=TRUE";
	public static final String DRIVER_NAME = "org.h2.Driver";

	public Connection getConnection() throws ClassNotFoundException,
	SQLException {
		Class.forName(DRIVER_NAME);
		con = DriverManager.getConnection(DB_URL, "sa", "sa");
		return con;
	}

	public void closeConnection() throws SQLException {
		if (isConnectionOpen()) {
			con.close();
			con = null;
		}
	}

	public boolean isConnectionOpen() {
		return (con != null);
	}

	public static DataServiceHelper getInstance() {
		if (dataServiceHelper == null) {
			dataServiceHelper = new DataServiceHelper();
		}
		return dataServiceHelper;
	}

	public void executeUpdateQuery(String query) throws SQLException,
	ClassNotFoundException {
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		stmt.execute(query);
		closeConnection();
	}

	public List<ActionProperty> executeQuery(String query)
			throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		List<ActionProperty> als = convertPojoList(rs);
		closeConnection();
		return als;
	}

	private List<ActionProperty> convertPojoList(ResultSet rs)
			throws SQLException {
		List<ActionProperty> asl = new ArrayList<ActionProperty>();
		while (rs.next()) {
			ActionProperty user = new ActionProperty(rs.getInt("ID"),
					rs.getString("ORDER_ITEM_STS_CD"),
					rs.getString("FFM_CLASS_ID"), rs.getInt("SITE_ID"),
					rs.getString("NEXT_COMMAND_NAME"));
			asl.add(user);
		}
		return asl;
	}
}