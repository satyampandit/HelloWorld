package edu.uic.ids.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;
import java.util.*;

public class DatabaseAccessMenuBean implements Serializable, Cloneable { 

	private static final long serialVersionUID = 1L;
	private String tableName;
	private List <String> columnNames;
	private List <String> tableViewList;
	private List <String> columnNamesSelected;
	private String sqlQuery;
	private ResultSet resultSet;
	private ResultSet resultSet1;
	private int rowCount;
	private int columnCount;
	private boolean renderList;
	private String errorMessage;
	
	public DatabaseAccessMenuBean(){
		errorMessage = "";
		renderList = false;
		rowCount = 0;
		columnCount = 0;
	}
	
	public DatabaseAccessMenuBean clone() throws CloneNotSupportedException {
		DatabaseAccessMenuBean cloned = (DatabaseAccessMenuBean) super.clone();
		return cloned;
	}
	
	public String clear(){
		tableName = null;
		columnNamesSelected = null;
		sqlQuery = null;
		rowCount = 0;
		columnCount= 0;
		renderList = false;
		return "SUCCESS";
	}
	
	//getters and setters---------------------------------------------------
	
	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}
	
	public String getSqlQuery() {
		return sqlQuery;
	}

	public void setSqlQuery(String sqlQuery) {
		this.sqlQuery = sqlQuery;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
	public boolean isRenderList() {
		return renderList;
	}

	public void setRenderList(boolean renderList) {
		this.renderList = renderList;
	}

	public String getTableName() {
		return tableName;
		
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<String> getColumnNames() {
		return columnNames;
	}
	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}
	public List<String> getTableViewList() {
		return tableViewList;
	}
	public void setTableViewList(List<String> tableViewList) {
		this.tableViewList = tableViewList;
		System.out.println("tableview List ------ > " + this.tableViewList);
	}
	public List<String> getColumnNamesSelected() {
		return columnNamesSelected;
	}
	public void setColumnNamesSelected(List<String> columnNamesSelected) {
		this.columnNamesSelected = columnNamesSelected;
	}
	public String getErrorMessage() {
		return errorMessage;
	}

	public ResultSet getResultSet1() {
		/*try {
			System.out.println("-------- Result set1 in result set1 = " + resultSet1.getFetchSize());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return resultSet1;
	}

	public void setResultSet1(ResultSet resultSet1) {
		this.resultSet1 = resultSet1;
	}
	
	
}
