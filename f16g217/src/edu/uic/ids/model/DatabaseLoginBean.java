package edu.uic.ids.model;
import java.io.Serializable;


public class DatabaseLoginBean implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	//inputs
		private String userName;
		private String password;
		private String host;
		private String rdbms;
		private String dbSchema;
		private String portNo;
		private boolean renderMessage;
		
	//outputs
		private String errorMessage;
		
	//controls
		private boolean status;
		
	public DatabaseLoginBean(){
		errorMessage = "";
		renderMessage = false;
	}
	
	public DatabaseLoginBean(String userName , String password , String host , String rdbms , String dbSchema , String portNo){
		super();
		this.userName = userName;
		this.password = password;
		this.host = host;
		this.rdbms = rdbms;
		this.dbSchema = dbSchema;
		this.portNo = portNo;
	}	
	
	public DatabaseLoginBean clone() throws CloneNotSupportedException {
		DatabaseLoginBean cloned = (DatabaseLoginBean) super.clone();
		return cloned;
	}


	
	//getters and setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getRdbms() {
		return rdbms;
	}

	public void setRdbms(String rdbms) {
		this.rdbms = rdbms;
	}

	public String getDbSchema() {
		return dbSchema;
	}

	public void setDbSchema(String dbSchema) {
		this.dbSchema = dbSchema;
	}

	public String getPortNo() {
		return portNo;
	}

	public void setPortNo(String portNo) {
		this.portNo = portNo;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isStatus() {
		return status;
	}

	public boolean isRenderMessage() {
		return renderMessage;
	}

	public void setRenderMessage(boolean renderMessage) {
		this.renderMessage = renderMessage;
	}
	
}
