package edu.uic.ids.model;

import java.io.Serializable;

public class UserLoginBean implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	//inputs
			private String userType;
			private String userName;
			private String password;
			private boolean renderMessage;
	//outputs
			private String errorMessage;		
	//controls
			private boolean status;
			
		public UserLoginBean(){
			errorMessage = "";
		}
		
		public UserLoginBean(String userType , String userName  , String password ){
			super();
			this.userType = userType;
			this.userName = userName;
			this.password = password;
		}	
		
		public UserLoginBean clone() throws CloneNotSupportedException {
			UserLoginBean cloned = (UserLoginBean) super.clone();
			return cloned;
		}
	

		//getters and setters
		public String getUserType() {
			return userType;
		}

		public void setUserType(String userType) {
			this.userType = userType;
		}

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

		public String getErrorMessage() {
			return errorMessage;
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

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		
		
		

}
