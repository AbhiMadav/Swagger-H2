package com.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.ActionProperty;
import com.utility.DataServiceHelper;

public class ActionPropertyService implements IActionPropertyService{

	public static ActionPropertyService actionPropertyService = new ActionPropertyService();
	public static final String GET_PROPERTIES="SELECT * FROM ACTIONCONFIRGURATION ";
	public static final String INSERT_PROPERTY="Insert into ACTIONCONFIRGURATION (ORDER_ITEM_STS_CD, FFM_CLASS_ID, SITE_ID, NEXT_COMMAND_NAME) ";
	
	@Override
	public List<ActionProperty> getAllProperties() throws ClassNotFoundException, SQLException {
		List<ActionProperty> listOfProperties = new ArrayList<ActionProperty>();
		listOfProperties=DataServiceHelper.getInstance().executeQuery(GET_PROPERTIES);
		return listOfProperties;
	}

	@Override
	public void createProperty(ActionProperty property) throws ClassNotFoundException, SQLException {
		String valueString = " VALUES('" + 
								property.getOrderItemStatus() + "','" +
								property.getFfmClassId() + "'," + 
								property.getSiteId() + ",'" +
								property.getNextControllerCommandName() + "');";
		DataServiceHelper.getInstance().executeUpdateQuery(INSERT_PROPERTY + valueString);
	}

	@Override
	public void updateProperty(ActionProperty property) throws ClassNotFoundException, SQLException {
		String updateQuery = "Update ACTIONCONFIRGURATION "+
							" Set ORDER_ITEM_STS_CD = '" + property.getOrderItemStatus() + "'," +
							" FFM_CLASS_ID = '" + property.getFfmClassId() + "'," +
							" SITE_ID = " + property.getSiteId() + "," +
							" NEXT_COMMAND_NAME = '" + property.getNextControllerCommandName() + "'" +
							" WHERE ID = " + property.getId() + ";";
		DataServiceHelper.getInstance().executeUpdateQuery(updateQuery);
	}

	@Override
	public void removeProperty(int propertyId) throws ClassNotFoundException, SQLException {
		String deleteQuery = "Delete FROM ACTIONCONFIRGURATION WHERE ID = " + propertyId;
		DataServiceHelper.getInstance().executeUpdateQuery(deleteQuery);
	}
	
	public static ActionPropertyService getInstance(){
		return actionPropertyService;
	}

}
