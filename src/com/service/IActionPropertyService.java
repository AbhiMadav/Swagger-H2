package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.ActionProperty;

public interface IActionPropertyService {

	public List<ActionProperty> getAllProperties() throws ClassNotFoundException, SQLException;

	public void createProperty(ActionProperty property) throws ClassNotFoundException, SQLException;

	public void updateProperty(ActionProperty property) throws ClassNotFoundException, SQLException;

	public void removeProperty(int propertyId) throws ClassNotFoundException, SQLException;

}
