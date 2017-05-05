package edu.uic.ids.databaseAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

import org.apache.commons.math3.stat.StatUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import edu.uic.ids.model.DatabaseLoginBean;
import edu.uic.ids.model.RosterAccessMenuBean;
import edu.uic.ids.model.ScoreAnalysisBean;
import edu.uic.ids.model.TestBean;
import edu.uic.ids.model.UserLoginBean;
import edu.uic.ids.model.UploadFileBean;
import edu.uic.ids.model.DatabaseAccessMenuBean;
import edu.uic.ids.model.ChartBean;

@ManagedBean
@SessionScoped
public class DatabaseAccess {

	//Database access parameters
		private Connection connection;
		private DatabaseMetaData databaseMetaData;
		private ResultSet resultSet;
		private ResultSet resultSetCopy;
		private ResultSetMetaData resultSetMetaData;
		private Statement statement;
		private Statement statement1;
		private static final String [] TABLE_TYPES={"TABLE","VIEW"};
		private String jdbcDriver;
		private String url;
		private DatabaseLoginBean databaseLoginBean;
		private UserLoginBean userLoginBean;
		private UploadFileBean uploadFileBean;
		private RosterAccessMenuBean rosterAccessMenuBean;
		private DatabaseAccessMenuBean databaseAccessMenuBean;
		private ScoreAnalysisBean scoreAnalysisBean;
		private TestBean testBean;
		private ChartBean chartBean;
		private List<TestBean> testBeanList;
		private Date startTime;
		private Date endTime; 

		//private TestPaperBean testPaperBean;
		
		FacesContext context = FacesContext.getCurrentInstance();
		Map <String, Object> m = context.getExternalContext().getSessionMap();
		 HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		
		//Constructor 
		public DatabaseAccess(){
		}
		
//		public DatabaseAccess(DatabaseLoginBean databaseLoginBean) {
//			
//			//this.databaseLoginBean = databaseLoginBean;
//			
//		}
		
	    String createURL(String[] args) {
			StringBuilder tempURL = new StringBuilder();
			for (int count = 0; count < args.length; count++) {
				tempURL.append(args[count]);
			}
			return tempURL.toString();
		}
	   
		
		
		//createConnection Method----------------------------------------------------------------------------------
		public String createConnection(){
			
			//System.out.println("getDbms = " + databaseAccessInformation.getDbms());
			try{
				System.out.println("Inside Database Access Class");
				Class.forName(jdbcDriver);
				System.out.println("username = " +  databaseLoginBean.getUserName() + "         password = " +  databaseLoginBean.getPassword() );
				this.setConnection(DriverManager.getConnection(url, databaseLoginBean.getUserName(), databaseLoginBean.getPassword()));
				this.setStatement(connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));
				this.setStatement1(connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));
				this.setDatabaseMetaData(connection.getMetaData());
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~CONNECTED TO DATABASE~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				
				
			//Check userLogin table with existing tables
				DatabaseMetaData dbm = connection.getMetaData();
				// check if "employee" table is there
				ResultSet tables = dbm.getTables(null, null, "f16g217_userLogin", null);
				if (tables.next()) {
				  // Table exists
					System.out.println("~~~~~~Table already exists!~~~~~~~");
				}
				else {
					String userLoginQuery = SqlQueries.getUserLoginTable();
					executeQuery(userLoginQuery);
					System.out.println("~~~~~~Created Table userLogin!~~~~~~~");
				}	
				String insertIntoUserLogin1 = SqlQueries.getInsertIntoUserLoginTable1();
				executeQuery(insertIntoUserLogin1);
				String insertIntoUserLogin2 = SqlQueries.getInsertIntoUserLoginTable2();
				executeQuery(insertIntoUserLogin2);
				String insertIntoUserLogin3 = SqlQueries.getInsertIntoUserLoginTable3();
				executeQuery(insertIntoUserLogin3);
				String insertIntoUserLogin4 = SqlQueries.getInsertIntoUserLoginTable4();
				executeQuery(insertIntoUserLogin4);
				String insertIntoUserLogin5 = SqlQueries.getInsertIntoUserLoginTable5();
				executeQuery(insertIntoUserLogin5);
				String insertIntoUserLogin6 = SqlQueries.getInsertIntoUserLoginTable6();
				executeQuery(insertIntoUserLogin6);
				String insertIntoUserLogin7 = SqlQueries.getInsertIntoUserLoginTable7();
				executeQuery(insertIntoUserLogin7);
				String insertIntoUserLogin8 = SqlQueries.getInsertIntoUserLoginTable8();
				executeQuery(insertIntoUserLogin8);
			
			//Check student table with existing tables
				ResultSet tables1 = dbm.getTables(null, null, "f16g217_student", null);
				if (tables1.next())
					System.out.println("~~~~~~Table already exists!~~~~~~~");
				else {
					String userLoginQuery = SqlQueries.getStudentTable();
					executeQuery(userLoginQuery);
					System.out.println("~~~~~~Created Table student!~~~~~~~");
				}	
				
			//Check instructor table with existing tables
			/*	ResultSet tables2 = dbm.getTables(null, null, "instructor", null);
				if (tables2.next()) 
					System.out.println("~~~~~~Table already exists!~~~~~~~");
				else {
					String userLoginQuery = SqlQueries.getInstructorTable();
					executeQuery(userLoginQuery);
					System.out.println("~~~~~~Created Table instructor!~~~~~~~");
				}*/
				
			//Check courses table with existing tables
				ResultSet tables3 = dbm.getTables(null, null, "f16g217_courses", null);
				if (tables3.next())
					System.out.println("~~~~~~Table already exists!~~~~~~~");
				else {
					String userLoginQuery = SqlQueries.getCoursesTable();
					executeQuery(userLoginQuery);
					System.out.println("~~~~~~Created Table courses!~~~~~~~");
				}	
				
			//Check testrepository table with existing tables
				ResultSet tables4 = dbm.getTables(null, null, "f16g217_testrepository", null);
				if (tables4.next()) 
					System.out.println("~~~~~~Table already exists!~~~~~~~");
				else {
					String userLoginQuery = SqlQueries.getTestRepositoryTable();
					executeQuery(userLoginQuery);
					System.out.println("~~~~~~Created Table testrepository!~~~~~~~");
				}	
				
			//Check testschedule table with existing tables
				ResultSet tables5 = dbm.getTables(null, null, "f16g217_testschedule", null);
				if (tables5.next()) 
					System.out.println("~~~~~~Table already exists!~~~~~~~");
				else {
					String userLoginQuery = SqlQueries.getTestScheduleTable();
					executeQuery(userLoginQuery);
					System.out.println("~~~~~~Created Table testschedule!~~~~~~~");
				}	
				
				//Check transactionLog table with existing tables
				System.out.println("Transaction log tablecreation check!");
				ResultSet tables6 = dbm.getTables(null, null, "f16g217_transactionLog", null);
				if (tables6.next()) 
					System.out.println("~~~~~~Table transactionLog already exists!~~~~~~~");
				else {
					String userLoginQuery = SqlQueries.getTransactionLogTable();
					executeQuery(userLoginQuery);
					System.out.println("~~~~~~Created Table transactionLog!~~~~~~~");
				}	
				
				//Check transactionLog table with existing tables
				System.out.println("Grade Table Creation check!");
				ResultSet tables7 = dbm.getTables(null, null, "f16g217_Grades", null);
				if (tables7.next()) 
					System.out.println("~~~~~~Table f16g217_Grades already exists!~~~~~~~");
				else {
					String userLoginQuery = SqlQueries.getGradesTable();
					executeQuery(userLoginQuery);
					System.out.println("~~~~~~Created Table f16g217_Grades!~~~~~~~");
				}	
			}
			catch (ClassNotFoundException e) {
				//errorMessage = e.getMessage();
				System.err.println(e.getMessage() + "\n");
				System.err.println(e.toString() + "\n");
				e.printStackTrace();
				return "fail";
			} 
			catch (SQLException e) {
				/*System.err.println(e.getMessage() + "\n");
				System.err.println(e.toString() + "\n");
				e.printStackTrace();*/
				return e.getMessage();
			} 
			catch (Exception e) {
				System.err.println(e.getMessage() + "\n");
				System.err.println(e.toString() + "\n");
				e.printStackTrace();
				return "fail";
			}
			return "success";
		}
	
		//DatabaseLogin Method-----------------------------------------------------------------------------------
		public String dbLogin() {
			
			databaseLoginBean = (DatabaseLoginBean) m.get("databaseLoginBean");
			
			System.out.println("databaseLoginBean.getRdbms() = " + databaseLoginBean.getRdbms());
			switch (databaseLoginBean.getRdbms().toUpperCase()) {
			case "MYSQL": {
				this.jdbcDriver = "com.mysql.jdbc.Driver";
				String[] urlContainer = { "jdbc:mysql://", databaseLoginBean.getHost(), ":3306/", databaseLoginBean.getDbSchema() };
				this.url = createURL(urlContainer);
				System.out.println("URL = " + this.url);
				break;
			}
			case "DB2": {
				jdbcDriver = "com.ibm.db2.jcc.DB2Driver";
				String[] urlContainer = { "jdbc:db2://",  databaseLoginBean.getHost() , ":50000/", databaseLoginBean.getDbSchema() };
				this.setUrl(createURL(urlContainer));
				break;
			}
			case "ORACLE": {
				jdbcDriver = "oracle.jdbc.driver.OracleDriver";
				String[] urlContainer = { "jdbc:oracle:thin:@",  databaseLoginBean.getHost() , ":1521:", databaseLoginBean.getDbSchema() };
				this.setUrl(createURL(urlContainer));
				break;
			}
			default: {
				this.jdbcDriver = "com.mysql.jdbc.Driver";
				String[] urlContainer = { "jdbc:mysql://",  databaseLoginBean.getHost() , ":3306/",
						databaseLoginBean.getDbSchema() };
				this.url = createURL(urlContainer);
				//System.out.println("URL = " + this.url);
				break;
			}
			}
			
			System.out.println("username = " + databaseLoginBean.getUserName() + "     password = "+ databaseLoginBean.getPassword() + "      host = " + databaseLoginBean.getHost() + "      rdbms = " + databaseLoginBean.getRdbms() + "       dbSchema = " + databaseLoginBean.getDbSchema() + "        portNo = " + databaseLoginBean.getPortNo()) ;
			
			System.out.println("Creating connection-------");
			String result = createConnection();
			System.out.println("result = " + result);
			if(result.equals("success")){
				return "userLogin.jsp?faces-redirect=true";
			}else{
				 databaseLoginBean.setErrorMessage(result);
				 System.out.println("ERROR ---- " + databaseLoginBean.getErrorMessage());
				 databaseLoginBean.setRenderMessage(true);
		         return "FAIL";
			}
		}	
		
	//UserLogin Method------------------------------------------------------------------------------------------	
	public String userLogin(){
			try{
		    userLoginBean = (UserLoginBean) m.get("userLoginBean");
			System.out.println("userType = " + userLoginBean.getUserType() + "     userName = " + userLoginBean.getUserName() + "      password = " + userLoginBean.getPassword());
			System.out.println("Select * from f16g217_userLogin where userName = '"+ userLoginBean.getUserName() +"'and password = '"+ userLoginBean.getPassword() +"'and userType = '"+ userLoginBean.getUserType() +"' ;");
			String sqlQuery= "Select * from f16g217_userLogin where userName = '"+ userLoginBean.getUserName() +"'and password = '"+ userLoginBean.getPassword() +"'and userType = '"+ userLoginBean.getUserType() +"' ; ";

			executeQuery(sqlQuery);
			System.out.println("ResultSet = " + resultSet);
			
			if(resultSet.next()){
				System.out.println("User Login is valid");
				if(userLoginBean.getUserType().equalsIgnoreCase("student")){
					 startTime = new Date(session.getLastAccessedTime());
					 System.out.println("----startAccessTime = " + startTime);
					 //startDate = System.nanoTime();
					 //System.out.println("Start date = " + startDate);
					 String sql = "UPDATE f16g217_student SET Last_Access='"+ startTime.toString() +"' where Username = '"+ userLoginBean.getUserName() +"';";
					 System.out.println("SQL = " + sql);
					 statement1.executeUpdate(sql);
					 System.out.println("Query executed successfully!");
					 return "welcomeStudent.jsp?faces-redirect=true";
				}else if(userLoginBean.getUserType().equalsIgnoreCase("instructor")){
					 startTime = new Date(session.getLastAccessedTime());
					 System.out.println("----startAccessTime = " + startTime);
					return "welcomeInstructor.jsp?faces-redirect=true";
				}else{
					 startTime = new Date(session.getLastAccessedTime());
					 System.out.println("----startAccessTime = " + startTime);
					return "welcomeAdmin.jsp?faces-redirect=true";
				}
			}
			else{
					userLoginBean.setErrorMessage("User Login failed! Username or Password invalid. Try Again!");
					userLoginBean.setRenderMessage(true);
					System.out.println("User Login failed! Try Again");
					return "FAIL";
			}
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				userLoginBean.setErrorMessage("Something went wrong. Please try Again!");
				userLoginBean.setRenderMessage(true);
				return "FAIL";
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				userLoginBean.setErrorMessage("Something went wrong. Please try Again!");
				userLoginBean.setRenderMessage(true);
				return "FAIL";
			}
		}
		
		//method to execute SQL query-----------------------------------------------------------------------------------
		public String executeQuery(String sqlQuery) {
			System.out.println("Entered executeQuery-------");
			boolean statusCheck = false;
			try {
				if (connection != null && statement != null){
					System.out.println("Status check is true");
					statusCheck = true;
				}
				System.out.println("Status check is false");
				if (statusCheck) {
					System.out.println("Status check is true-------");
					if (sqlQuery.toUpperCase().startsWith("SELECT")) {
						System.out.println("Select statement is running-------");
						this.setResultSet(statement.executeQuery(sqlQuery));
						System.out.println("this.resultSet = " + this.getResultSet().getFetchSize());
						this.setResultSetCopy(statement1.executeQuery(sqlQuery));
						System.out.println("this.resultSetCopy = " + this.getResultSetCopy().getFetchSize());
						//System.out.println();
						this.setResultSetMetaData(resultSet.getMetaData());
						//System.out.println("this.resultSetMetaData = " + this.resultSetMetaData );
						return "SUCCESS";
					}
					else
					{
						System.out.println("Other statements are running--------");
						statement.executeUpdate(sqlQuery);
						return "SUCCESS";
					}
				}
				else{
					return "FAIL";
				}
			} 
			catch (SQLException e) {
				System.err.println(e.getMessage() + "\n");
				System.err.println(e.toString() + "\n");
				e.printStackTrace();
				return "FAIL";
				
			} 
			catch (Exception e) {
				System.err.println(e.getMessage() + "\n");
				System.err.println(e.toString() + "\n");
				e.printStackTrace();
				return "FAIL";
				
			}
		}
		
		//upload file in database---------------------------------------------------------------------------------------
		public String uploadFile() throws IOException{

			uploadFileBean = (UploadFileBean) m.get("uploadFileBean");
			System.out.println("upload file bean *************   " + uploadFileBean.getUploadedFile());
			uploadFileBean.setFileName(uploadFileBean.getUploadedFile().getName());
			InputStream inputStream = uploadFileBean.getUploadedFile().getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String fileType = uploadFileBean.getFileType();
			
			String lineReader = null;
			int count = 0;
			int RowNo = 0;
			String colText = null;
			ArrayList<String> valText = new ArrayList<String>();
			
			if(fileType.equalsIgnoreCase("csvType")){
				while((lineReader = br.readLine())!=null){
					System.out.println("LineReader ===== " + lineReader);
					if(count==0){
						colText = lineReader;
					}else{
						RowNo += 1; 
						String splitText[] = lineReader.split(",");
						String finalText = "";
						for (int i = 0 ; i < splitText.length ; i++){
							if(i == splitText.length-1){
								splitText[i] = "'" +  splitText[i]+ "'";
							}else{
								//if(i == 0 || i == 1){
									splitText[i] = "'" + splitText[i] + "',";
								//}else{
								//	splitText[i] =  splitText[i] + ",";
								//}
							}
							finalText += splitText[i];
							System.out.println("final text =====  " + finalText);
						}
						valText.add(finalText);
					}
					count += 1; 
				}
			}
			else{
				while((lineReader = br.readLine())!=null){
					System.out.println("LineReader ===== " + lineReader);
					if(count==0){
						colText = lineReader;
						colText = colText.replaceAll("\t", ",");
						System.out.println("Column header----- " + colText);
					}else{
						RowNo += 1; 
						String splitText[] = lineReader.split("\t");
						String finalText = "";
						for (int i = 0 ; i < splitText.length ; i++){
							if(i == splitText.length-1){
								splitText[i] = "'" +  splitText[i]+ "'";
							}else{
								//if(i == 0 || i == 1){
									splitText[i] = "'" + splitText[i] + "',";
								//}else{
								//	splitText[i] =  splitText[i] + ",";
								//}
							}
							finalText += splitText[i];
							System.out.println("final text =====  " + finalText);
						}
						valText.add(finalText);
					}
					count += 1; 
				}
			}
		
			
			
			System.out.println("------------------------------ROW NO : "+ RowNo +"------------------------------------");
			System.out.println("file name = " + uploadFileBean.getFileFunction());
			
			if(uploadFileBean.getFileFunction().equals("courseRoster")){
				for (int i=0 ; i<RowNo ; i++){
					String sqlQuery;
					if(uploadFileBean.getHeaderRow().equals("yes")){
						sqlQuery = "INSERT INTO f16g217_courses (" + colText + " ) VALUES (";
					}
					else{
						sqlQuery = "INSERT INTO f16g217_courses ( " + colText + " ) VALUES (";
					}
					sqlQuery = sqlQuery + valText.get(i) + " );";
					System.out.println("SqlQuery No - " + (i+1) +" :    " + sqlQuery);		
					executeQuery(sqlQuery);
					System.out.println("ResultSet = " + resultSet);
				}
				uploadFileBean.setErrorMessage("File uploaded successfully!");
				
				String sqlQuery1 = "SELECT * FROM f16g217_courses";
				try {
					executeQuery(sqlQuery1);
					ResultSetMetaData rsMetaData = resultSet.getMetaData();
					List<String> courseColList = new ArrayList<String>();				
					System.out.println("rsmetadata --- - --  "+ rsMetaData.getColumnCount());
					for(int i=1;i<=rsMetaData.getColumnCount();i++){
						
						courseColList.add(rsMetaData.getColumnLabel(i));
					}
					uploadFileBean.setCoursesColumnList(courseColList);
					uploadFileBean.setCourseResultSet(resultSet);
					uploadFileBean.setColumnCount(rsMetaData.getColumnCount());
					resultSet.last();
					uploadFileBean.setRowCount(resultSet.getRow());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				uploadFileBean.setRenderCourseUploadMessage(true);
				System.out.println("Reached end of file upload method");
				return "SUCCESS";
			}else if(uploadFileBean.getFileFunction().equals("test")){
				

				//Upload into testSchedule-------------------------------------------
				System.out.println("Entered insert into testSchedule------------------------" + uploadFileBean.getStartDate() + "     end date =  " + uploadFileBean.getEndDate());
				String sqlQuery3 = "SELECT * FROM f16g217_TESTSCHEDULE WHERE EXAMTYPE = '" + uploadFileBean.getExamType() + "' AND CRN = '" + uploadFileBean.getSelectedCrn() + "';";
				executeQuery(sqlQuery3);
				int examId = 0;
				int totalMarks =0;
				try {
					if(resultSet.getFetchSize()!=0){
						if(uploadFileBean.getOverrideTest().equals("yes")){
							totalMarks = RowNo * uploadFileBean.getPointsPerQuestion();
							System.out.println("Total marks = " + totalMarks);
							String sqlQuery2 = "INSERT INTO f16g217_testSchedule (examType, CRN,courseCode,TotalMarks,AvailabilityStartDate,AvailabilityEndDate,Duration ) VALUES ('"+ uploadFileBean.getExamType() +"','"+ uploadFileBean.getSelectedCrn() + "','" + uploadFileBean.getCourseCode() + "','" + totalMarks + "','" + uploadFileBean.getStartDate() + "','" + uploadFileBean.getEndDate() + "','" + uploadFileBean.getDuration() + "');";
							statement1.executeUpdate(sqlQuery2 , Statement.RETURN_GENERATED_KEYS);
							ResultSet rs = statement1.getGeneratedKeys();
							rs.next();
							//getting the inserted exam id 
							examId = rs.getInt(1);
						}
					}else{
						totalMarks = RowNo * uploadFileBean.getPointsPerQuestion();
						System.out.println("Total marks = " + totalMarks);
						String sqlQuery2 = "INSERT INTO f16g217_testSchedule (examType, CRN,courseCode,TotalMarks,AvailabilityStartDate,AvailabilityEndDate,Duration ) VALUES ('"+ uploadFileBean.getExamType() +"','"+ uploadFileBean.getSelectedCrn()+ "','" + uploadFileBean.getCourseCode()  + "','" + totalMarks + "','" + uploadFileBean.getStartDate() + "','" + uploadFileBean.getEndDate() + "','" + uploadFileBean.getDuration() + "');";
						statement1.executeUpdate(sqlQuery2 , Statement.RETURN_GENERATED_KEYS);
						ResultSet rs = statement1.getGeneratedKeys();
						rs.next();
						//getting the inserted exam id 
						examId = rs.getInt(1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("finished insert into testSchedule------------------------");
				//-------------------------------------------------------------------
				
				
				for (int i=0 ; i<RowNo ; i++){
					String sqlQuery = null;
					if(uploadFileBean.getHeaderRow().equals("yes")){
						//sqlQuery = "INSERT INTO testRepository (" + colText + " ) VALUES (";
						System.out.println("NOT WORKING RIGHT NOW");
					}
					else{
						sqlQuery = "INSERT INTO f16g217_testRepository (examId, questionType, question, answer, tolerance) VALUES (" + examId + ", ";
					}
					sqlQuery = sqlQuery + valText.get(i) + " );";
					System.out.println("SqlQuery No - " + (i+1) +" :    " + sqlQuery);		
					executeQuery(sqlQuery);
					System.out.println("ResultSet = " + resultSet);
				}
				uploadFileBean.setErrorMessage("File uploaded successfully!");
				
				
				String sqlQuery1 = "SELECT * FROM f16g217_testrepository";
				try {
					executeQuery(sqlQuery1);
					ResultSetMetaData rsMetaData = resultSet.getMetaData();
					List<String> testRepositoryColList = new ArrayList<String>();				
					System.out.println("rsmetadata --- - --  "+ rsMetaData.getColumnCount());
					for(int i=1;i<=rsMetaData.getColumnCount();i++){
						
						testRepositoryColList.add(rsMetaData.getColumnLabel(i));
					}
					uploadFileBean.setTestColumnList(testRepositoryColList);
					uploadFileBean.setTestResultSet(resultSet);
					uploadFileBean.setColumnCount(rsMetaData.getColumnCount());
					resultSet.last();
					uploadFileBean.setRowCount(resultSet.getRow());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				uploadFileBean.setRenderQuestionPaperMessage(true);
				System.out.println("Reached end of file upload method");
				return "SUCCESS";
			}
			/*else if(uploadFileBean.getFileName().contains("roster")){
				System.out.println("Entered courses ------>>>> " + colText);
				for (int i=0 ; i<RowNo ; i++){
					String sqlQuery = "INSERT INTO courses (" + colText + " ) VALUES (";
					sqlQuery = sqlQuery + valText.get(i) + " );";
					System.out.println("SqlQuery No - " + i+1 +" :    " + sqlQuery);		
					executeQuery(sqlQuery);
					System.out.println("ResultSet = " + resultSet);
				}
				uploadFileBean.setErrorMessage("File uploaded successfully!");
				
				String sqlQuery1 = "SELECT * FROM courses";
				executeQuery(sqlQuery1);
				try {
					uploadFileBean.setCourseResultSet(resultSet);
					uploadFileBean.setTestScheduleResultSet(resultSet);
					ResultSetMetaData rsMetaData = resultSet.getMetaData();
					List<String> coursesColList = new ArrayList<String>();	
					System.out.println("rsmetadata --- - --  "+ rsMetaData.getColumnCount());
					for(int i=1;i<=rsMetaData.getColumnCount();i++){
						
						coursesColList.add(rsMetaData.getColumnLabel(i));
					}
					uploadFileBean.setCoursesColumnList(coursesColList);
					uploadFileBean.setColumnCount(rsMetaData.getColumnCount());
					resultSet.last();
					uploadFileBean.setRowCount(resultSet.getRow());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				uploadFileBean.setRenderCourseUploadMessage(true);
				System.out.println("Reached end of file upload method");
				
				System.out.println("courseName = " + uploadFileBean.getCourseName() + "   crn = "+ uploadFileBean.getCrn() + "     fileLabel = "+ uploadFileBean.getFileLabel() + "     fileFunction = " + uploadFileBean.getFileFunction() + "     header row =  " + uploadFileBean.getHeaderRow());
				return "SUCCESS";
			}*/
			else if(uploadFileBean.getFileFunction().equals("studentRoster")){
				for (int i=0 ; i<RowNo ; i++){
					String sqlQuery = "INSERT INTO f16g217_student (" + colText + " ,crn) VALUES (";
					sqlQuery = sqlQuery + valText.get(i) + ", " + uploadFileBean.getSelectedCrn() + " );";
					System.out.println("SqlQuery No - " + i+1 +" :    " + sqlQuery);		
					executeQuery(sqlQuery);
					System.out.println("ResultSet = " + resultSet);
				}
				uploadFileBean.setErrorMessage("File uploaded successfully!");
				
				String sqlQuery1 = "SELECT * FROM f16g217_student";
				executeQuery(sqlQuery1);
				try {
					uploadFileBean.setStudentResultSet(resultSet);
					ResultSetMetaData rsMetaData = resultSet.getMetaData();
					uploadFileBean.setTestScheduleResultSet(resultSet);
					List<String> studentColList = new ArrayList<String>();				
					System.out.println("rsmetadata --- - --  "+ rsMetaData.getColumnCount());
					for(int i=1;i<=rsMetaData.getColumnCount();i++){
						
						studentColList.add(rsMetaData.getColumnLabel(i));
					}
					uploadFileBean.setStudentColumnList(studentColList);
					uploadFileBean.setColumnCount(rsMetaData.getColumnCount());
					resultSet.last();
					uploadFileBean.setRowCount(resultSet.getRow());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				uploadFileBean.setRenderStudentUploadMessage(true);
				System.out.println("Reached end of file upload method");
				return "SUCCESS";
			}
			/*else if(uploadFileBean.getFileName().contains("instructor")){
				for (int i=0 ; i<RowNo ; i++){
					String sqlQuery = "INSERT INTO instructor (" + colText + " ) VALUES (";
					sqlQuery = sqlQuery + valText.get(i) + " );";
					System.out.println("SqlQuery No - " + i+1 +" :    " + sqlQuery);		
					executeQuery(sqlQuery);
					System.out.println("ResultSet = " + resultSet);
				}
				uploadFileBean.setErrorMessage("File uploaded successfully!");
				
				String sqlQuery1 = "SELECT * FROM instructor";
				executeQuery(sqlQuery1);
				try {
					uploadFileBean.setInstructorResultSet(resultSet);
					ResultSetMetaData rsMetaData = resultSet.getMetaData();
					uploadFileBean.setTestScheduleResultSet(resultSet);
					List<String> instructorColList = new ArrayList<String>();				
					System.out.println("rsmetadata --- - --  "+ rsMetaData.getColumnCount());
					for(int i=1;i<=rsMetaData.getColumnCount();i++){
						
						instructorColList.add(rsMetaData.getColumnLabel(i));
					}
					uploadFileBean.setInstructorColumnList(instructorColList);
					uploadFileBean.setColumnCount(rsMetaData.getColumnCount());
					resultSet.last();
					uploadFileBean.setRowCount(resultSet.getRow());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				uploadFileBean.setRenderInstructorUploadMessage(true);
				System.out.println("Reached end of file upload method");
				return "SUCCESS";
			}*/
			else{
				uploadFileBean.setErrorMessage("File could not be uploaded! Try again.");
				uploadFileBean.setColumnCount(0);
				uploadFileBean.setRowCount(0);
				uploadFileBean.setRenderErrorMessage(true);
				System.out.println("File could not be uploaded! Try again");
				return "FAIL";
			}
		}
	
		//Reset the rendered Fields-------------------------------------------------------------
			public void resetRenders(){
				System.out.println("Method called ---RESET RENDERS----");
				System.out.println("uploadfilebean is null? == " + uploadFileBean);
				if(uploadFileBean != null ){
					uploadFileBean.setRenderCourseUploadMessage(false);
					uploadFileBean.setRenderInstructorUploadMessage(false);
					uploadFileBean.setRenderStudentUploadMessage(false);
					uploadFileBean.setRenderTestScheduleMessage(false);
					uploadFileBean.setRenderQuestionPaperMessage(false);
					uploadFileBean.setRenderErrorMessage(false);
					System.out.println("Method terminated ---RESET RENDERS----");
				}			
			}
		
		//Method to display tableList---------------------------------------------------------
				public String displayTableList(){
					System.out.println("****** Entered displayTableList method ******");
					databaseAccessMenuBean = (DatabaseAccessMenuBean) m.get("databaseAccessMenuBean");
					List<String> tableList = new ArrayList<String>();
					try {
						//String sqlQuery = "Show tables from "+ databaseLoginBean.getDbSchema() +";";
						//System.out.println("SQL Query is --> " + sqlQuery);
						//ResultSet rs = executeQuery(sqlQuery);
						ResultSet rs = databaseMetaData.getTables(null, databaseLoginBean.getDbSchema() , null, TABLE_TYPES); 
						while (rs.next()) {
							String tableName = rs.getString("TABLE_NAME");
							System.out.println("TableName =    "  + tableName );
							tableList.add(tableName);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("tableList = " + tableList);
					databaseAccessMenuBean.setTableViewList(tableList);
					//String s = databaseAccessMenuBean.displayTableViewList(tableList);
					//if(s.equalsIgnoreCase("SUCCESS"))
						return "Success";
					//else
					//	return "Fail";
				}

		
		//Method to display columns of selected table list----------------------------------------------------------
				public String displayTableColumnList(){
					System.out.println("****** Entered displayColumnList method ******");
					databaseAccessMenuBean = (DatabaseAccessMenuBean) m.get("databaseAccessMenuBean");
					List<String> columnList = new ArrayList<String>();
					System.out.println("table name selected = " + databaseAccessMenuBean.getTableName());
					try {
						ResultSet rs = databaseMetaData.getColumns(null, "%", databaseAccessMenuBean.getTableName() , null);
						while (rs.next()) {
							String columnName = rs.getString("COLUMN_NAME");
							System.out.println("Column name =    "  + columnName );
							columnList.add(columnName);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("tableList = " + columnList);
					databaseAccessMenuBean.setColumnNames(columnList);
					return "Success";
					//else
					//	return "Fail";
				}
				
		//Method to display table as SQL query----------------------------------------------------------------------
		public String displayTable(){
			databaseAccessMenuBean = (DatabaseAccessMenuBean) m.get("databaseAccessMenuBean");
			String sqlQuery = "SELECT * FROM " + databaseAccessMenuBean.getTableName() + ";";
			databaseAccessMenuBean.setSqlQuery(sqlQuery);
			return "Success";
		}
		
		//Method to display selected columns as SQL query-----------------------------------------------------------
		public String displaySelectedColumns(){
			
			databaseAccessMenuBean = (DatabaseAccessMenuBean) m.get("databaseAccessMenuBean");
			System.out.println("Entered the displaySelectedColumns method --- " + databaseAccessMenuBean.getColumnNamesSelected());
			String columnListString = databaseAccessMenuBean.getColumnNamesSelected().toString();
			columnListString = columnListString.substring(columnListString.indexOf("[")+1, columnListString.indexOf("]"));
			System.out.println("columns list string - >  " + columnListString);
			String sqlQuery = "SELECT "+ columnListString +" FROM " + databaseAccessMenuBean.getTableName() + ";";
			databaseAccessMenuBean.setSqlQuery(sqlQuery);
			return "Success";
		}
		
		//Method to display columns of selected table list----------------------------------------------------------
		public String processSQLQuery(){
			
			databaseAccessMenuBean = (DatabaseAccessMenuBean) m.get("databaseAccessMenuBean");
			databaseAccessMenuBean.setRenderList(false);
			String sqlQuery = databaseAccessMenuBean.getSqlQuery();
			System.out.println("Entered the processSQLQuery method --- " + sqlQuery);
			if(sqlQuery.contains("DROP") || sqlQuery.contains("drop")){
				executeQuery(sqlQuery);
			}else{
				System.out.println("entered else*****");
				try {
					executeQuery(sqlQuery);
					System.out.println("Result set size = " + resultSet.getFetchSize());
					databaseAccessMenuBean.setColumnCount(resultSetMetaData.getColumnCount());
					System.out.println("Returned successfully");
					int count = 0;
					while (resultSet.next()) {
					    ++count;
					    // Get data from the current row and use it
					}
					databaseAccessMenuBean.setRowCount(count);
					System.out.println("ResultSet in processSQL = " + resultSet.getFetchSize());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//databaseAccessMenuBean.setRowCount(resultSetMetaData.);
				
				
				databaseAccessMenuBean.setResultSet(resultSet);
				databaseAccessMenuBean.setRenderList(true);
			}
			
			return "Success";
		}
		
		
		//MEthod to obtain crnList---------------------------------------------------------------------------------
		public String populateCrnList(){
			
			System.out.println("Entered the populateCrnList method");
			List<String> crnList = new ArrayList<String>();	
			rosterAccessMenuBean = (RosterAccessMenuBean) m.get("rosterAccessMenuBean");
			scoreAnalysisBean = (ScoreAnalysisBean) m.get("scoreAnalysisBean");
			uploadFileBean = (UploadFileBean) m.get("uploadFileBean");
			
				if(rosterAccessMenuBean!=null || scoreAnalysisBean!=null){
				String sqlQuery = "SELECT (crn) FROM f16g217_COURSES;";
				try {
					executeQuery(sqlQuery);
					System.out.println(resultSet.getMetaData() + "      size = " + resultSet.getFetchSize());
					while(resultSet.next()){
						System.out.println("Entered WHILE");
						String crn = resultSet.getString("crn");
						crnList.add(crn);
					}
					System.out.println("CRN LIST= " +crnList);
					if(rosterAccessMenuBean!=null){
						rosterAccessMenuBean.setCrnList(crnList);
					}else{
						scoreAnalysisBean.setCrnList(crnList);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}System.out.println("Outside if");
				return "SUCCESS";
		}
		
		//MEthod to obtain viewRoster---------------------------------------------------------------------------------
		public String actionRoster(){
			System.out.println("Entered the viewRoster method");	
			rosterAccessMenuBean = (RosterAccessMenuBean) m.get("rosterAccessMenuBean");
			rosterAccessMenuBean.setRenderMessage(false);
			if(rosterAccessMenuBean.getAction().equals("view")){
				if(rosterAccessMenuBean.getRosterType().equals("studentRoster")){
					System.out.println("VIEW STUDENT ROSTER");
					rosterAccessMenuBean.setRenderTestRosterResultSet(false);
					String sqlQuery = "SELECT Last_Name, First_Name, Student_ID, Last_Access, "+ rosterAccessMenuBean.getSelectedExamType() +" FROM f16g217_student where crn='"+ rosterAccessMenuBean.getSelectedCrn() +"';";
					try {
						executeQuery(sqlQuery);
						ResultSetMetaData rsMetaData = resultSet.getMetaData();
						List<String> studentRosterColList = new ArrayList<String>();				
						System.out.println("rsmetadata --- - --  "+ rsMetaData.getColumnCount());
						for(int i=1;i<=rsMetaData.getColumnCount();i++){
							
							studentRosterColList.add(rsMetaData.getColumnLabel(i));
						}
						rosterAccessMenuBean.setStudentRosterColumns(studentRosterColList);
						rosterAccessMenuBean.setStudentRosterResultSet(resultSet);
						rosterAccessMenuBean.setRenderStudentRosterResultSet(true);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					System.out.println("VIEW TEST ROSTER");
					rosterAccessMenuBean.setRenderStudentRosterResultSet(false);
					String sqlQuery = "SELECT examType, CRN, courseCode, AvailabilityStartDate, AvailabilityEndDate, Duration, question, answer, tolerance "									
										+ "FROM f16g217_testschedule ts "
										+ "INNER JOIN f16g217_testrepository tr "
										+" ON ts.examId = tr.examId "
										+"WHERE ts.examType = '"+ rosterAccessMenuBean.getSelectedExamType() +"' "
										+"AND ts.CRN = '"+ rosterAccessMenuBean.getSelectedCrn() +"' ;";
					try {
						executeQuery(sqlQuery);
						ResultSetMetaData rsMetaData = resultSet.getMetaData();
						List<String> testRosterColList = new ArrayList<String>();				
						System.out.println("rsmetadata --- - --  "+ rsMetaData.getColumnCount());
						for(int i=1;i<=rsMetaData.getColumnCount();i++){
							
							testRosterColList.add(rsMetaData.getColumnLabel(i));
						}
						rosterAccessMenuBean.setTestRosterColumns(testRosterColList);
						rosterAccessMenuBean.setTestRosterResultSet(resultSet);
						rosterAccessMenuBean.setRenderTestRosterResultSet(true);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else{
				if(rosterAccessMenuBean.getRosterType().equals("studentRoster")){
					System.out.println("DELETE STUDENT ROSTER");
					rosterAccessMenuBean.setRenderTestRosterResultSet(false);
					rosterAccessMenuBean.setRenderStudentRosterResultSet(false);
					String sqlQuery = "DELETE FROM f16g217_student where crn='"+ rosterAccessMenuBean.getSelectedCrn() +"';";
					executeQuery(sqlQuery);
					rosterAccessMenuBean.setMessage("DELETED SUCCESSFULLY FROM STUDENT ROSTER");
					rosterAccessMenuBean.setRenderMessage(true);
				}else{
					System.out.println("DELETE TEST ROSTER");
					rosterAccessMenuBean.setRenderTestRosterResultSet(false);
					rosterAccessMenuBean.setRenderStudentRosterResultSet(false);
					String sqlQuery = "DELETE tr,ts "
										+ "FROM f16g217_testrepository tr "
										+ "INNER JOIN f16g217_testschedule ts "
										+ "ON tr.examId = ts.examId "
										+ "WHERE ts.CRN = '"+ rosterAccessMenuBean.getSelectedCrn() +"';";
					executeQuery(sqlQuery);
					rosterAccessMenuBean.setMessage("DELETED SUCCESSFULLY FROM TEST ROSTER");
					rosterAccessMenuBean.setRenderMessage(true);
				}
					
			}
			return "SUCCESS";
		}
		
		
		//Method to drop a table-----------------------------------------------------------------------------------
		public String dropTable(){
			databaseAccessMenuBean = (DatabaseAccessMenuBean) m.get("databaseAccessMenuBean");
			String sqlQuery = "DROP TABLE f16g217_"+ databaseAccessMenuBean.getTableName() +";";
			databaseAccessMenuBean.setSqlQuery(sqlQuery);
			return "SUCCESS";
		}
		
		//method to load test values in testBean--------------------------------------------------------------------
		public String getTestDetails(){
			testBean = (TestBean) m.get("testBean");
			String sqlQuery = "SELECT * FROM f16g217_TESTSCHEDULE;";
			executeQuery(sqlQuery);
			testBean.setResultSet(resultSet);
			testBean.setRenderList(true);
			System.out.println("Result set to test bean ---->>>> " + testBean.getResultSet());
			return "SUCCESS";
		}
		
		
		//method to take a test-------------------------------------------------------------------------------------
		public String takeTest(){
			System.out.println("ENTERED TAKETEST METHOD!!");
			
			UIComponent button = UIComponent.getCurrentComponent(FacesContext.getCurrentInstance());
			Map<String, Object> id = button.getAttributes();
			System.out.println("MAP = = = =  " + id.size() +"     ===="+ id.toString());
			String currentTestId =  id.get("label").toString();
			System.out.println("current test id --- " + currentTestId);
			testBeanList = new ArrayList<TestBean>();	
			testBean = (TestBean) m.get("testBean");
			//testPaperBean = (TestPaperBean) m.get("testPaperBean");
			String sqlQuery = "SELECT * FROM f16g217_TESTREPOSITORY WHERE EXAMID = " + currentTestId + ";";
			try {
				if (connection != null && statement1 != null){
					ResultSet rs = statement1.executeQuery(sqlQuery);
				
					while(rs.next()){
						TestBean tb = new TestBean();
						tb.setQuestion(rs.getString("question"));
						tb.setAnswer(rs.getDouble("answer"));
						tb.setTolerance(rs.getDouble("tolerance"));
						tb.setQuestionPaperRenderList(true);
						testBeanList.add(tb);
					}
					testBean.setQuestionPaperRenderList(true);
					//FacesContext.getCurrentInstance().getExternalContext().redirect("testPaper.jsp");
				}
				else{
					System.out.println("Statement is null ---");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				testBean.setOutputMessage(e.getMessage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				testBean.setOutputMessage(e.getMessage());
			}
			//testBean.setErrorMessage("TEST SUBMITTED SUCCESSFULLY!");	
			return "SUCCESS";
		}
			

		public String submitMethod(){
			System.out.println("Entered Submit method");
			userLoginBean = (UserLoginBean) m.get("userLoginBean");
			
			Double answer;
			Double resp; 
			Double tolerance;
			Double range1;
			Double range2;
			int finalScore = 0;
			
			if(testBeanList.isEmpty()){
				return "false";
			}
			for(TestBean ab:testBeanList){
				
				answer = ab.getAnswer();
				resp = ab.getUserAnswer();
				tolerance = ab.getTolerance();
				range1= answer + tolerance;
				range2 = answer - tolerance;
				int score =0;
				if (resp <= range1 && resp >= range2 )
				{
					score = 1;
					finalScore = finalScore + score;
				};
				System.out.println("Answer = " + answer + "   resp =  "+ resp + "   tolerance = " + tolerance + "      score= "+ score  +"    final score = " + finalScore);
			}
			String sqlQuery ="UPDATE f16g217_courses SET Exam01 = '" + finalScore + "' WHERE Username = '" + userLoginBean.getUserName()  + "';";// " insert into courses(Exam01) values(" + score  +")";
			System.out.println("SQL QUERY ->  " + sqlQuery);
			try {
				statement1.executeUpdate(sqlQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			testBean.setQuestionPaperRenderList(false);
			testBean.setOutputMessage("Exam Submitted Successfully!");
			testBean.setRenderMessage(true);
			testBean.setFinalScore(finalScore);
			System.out.println("FINAL SCORE IS =  " + testBean.getFinalScore());
			testBean.setScoreRender(true);
			return "true";
		}

		//Method to call download functionality--------------------------------------------------------------------
		public String downloadCall(){
			
			return "SUCCESS";
		}
		
		
		
		//Method to download file-----------------------------------------------------------------------------------
		public String downloadFileMethod(){
		System.out.println("ENTERED DOWNLOAD METHOD");
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		FileOutputStream fos = null;
		// assumes folder temp in WebContent
		String path = fc.getExternalContext().getRealPath("/files");
		String fileNameBase = "downloadFile"+".csv";
		String fileName = path + "/" + databaseLoginBean.getUserName()+ "_" + fileNameBase;
		File f = new File(fileName);
		// generate resultSet for ticker,
		// wrap resultSet in Result (or use rs directly),
		// and convert to Object [][] – just one approach.
		/*try {
			System.out.println("databaseAccessMenuBean.getResultSet1() === " + databaseAccessMenuBean.getResultSet1().getFetchSize()  + "    this.resultSet ==== " + this.resultSet.getFetchSize());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		//String sql = "SELECT * FROM f16g217_STUDENT;";
		try {
		//ResultSet rs = statement1.executeQuery(sql);
		/*while(resultSetCopy.next()){
			System.out.println("INSIDE WHILE LOOP!!! " + resultSetCopy.getString("Last_Name"));
		}*/
		Result result = ResultSupport.toResult(resultSetCopy);//databaseAccessMenuBean.getResultSet()
		Object [][] sData = result.getRowsByIndex();
		String columnNames [] = result.getColumnNames();
		//System.out.println("Column names = " + columnNames);
		StringBuffer sb = new StringBuffer();
		// generate file to export, save in temp folder
		
		fos = new FileOutputStream(fileName);
		// output header line
		for(int i=0; i<columnNames.length; i++) {
			System.out.println("Column names = " + columnNames);
		sb.append(columnNames[i].toString() + ",");
		}
		sb.append("\n");
		fos.write(sb.toString().getBytes());
		// output data lines
		for(int i = 0; i < sData.length; i++) {
		sb = new StringBuffer();
		for(int j=0; j<sData[0].length; j++) {
		sb.append(sData[i][j].toString() + ",");
		}
		// System.out.println();
		sb.append("\n");
		fos.write(sb.toString().getBytes());
		}
		fos.flush();
		fos.close();
		}
		// Needed catch blocks
		catch(Exception e){
			e.printStackTrace();
		}
		// Now export (download) file
		String mimeType = ec.getMimeType(fileName);
		FileInputStream in = null;
		byte b;
		ec.responseReset();
		ec.setResponseContentType(mimeType);
		ec.setResponseContentLength((int) f.length());
		ec.setResponseHeader(
		"Content-Disposition", "attachment; filename=\"" +
		fileNameBase + "\"");
		try {
		in = new FileInputStream(f);
		OutputStream output = ec.getResponseOutputStream();
		while(true) {
		b = (byte) in.read();
		if(b < 0)
		break;
		output.write(b);
		}
		}
		// needed catch blocks and finally block to close
		catch(Exception e){
			e.printStackTrace();
		}
		fc.responseComplete();
		return "SUCCESS";
		}
		
		
		
		
		
		public String descriptiveAnalysis(){
			System.out.println("Entered Descriptive Analysis method");
			scoreAnalysisBean = (ScoreAnalysisBean) m.get("scoreAnalysisBean");
			System.out.println("scoreAnalysisBean.getSelectedCrn()" +scoreAnalysisBean.getSelectedCrn());
			String sqlQuery = "SELECT Exam01,Exam02,Exam03,Project,Total FROM f16g217_STUDENT WHERE crn ="+ scoreAnalysisBean.getSelectedCrn() +";";
			executeQuery(sqlQuery);
			
			List<Double> exam01 = new ArrayList<Double>();
			List<Double> exam02 = new ArrayList<Double>();
			List<Double> exam03 = new ArrayList<Double>();
			List<Double> project = new ArrayList<Double>();
			List<Double> total = new ArrayList<Double>();
			/*double exam01[] = new double[61];
			double exam02[] = new double[61];
			double exam03[] = new double[61];
			double project[] = new double[61];
			double total[] = new double[61];*/
			try {
				System.out.println("Resultset size = " + resultSet.getFetchSize());
				while (resultSet.next()) {  
				   exam01.add(resultSet.getDouble("Exam01"));
				   exam02.add(resultSet.getDouble("Exam02"));
				   exam03.add(resultSet.getDouble("Exam03"));
				   project.add(resultSet.getDouble("Project"));
				   total.add(resultSet.getDouble("Total"));
				  
				}
				System.out.println("Exam01 = " + exam01);
				System.out.println("Exam02 = " + exam02);
				System.out.println("Exam03 = " + exam03);
				System.out.println("Project = " +project);
				System.out.println("Total = " + total);
				List<Double> output = new ArrayList<Double>();
				switch(scoreAnalysisBean.getExamType()){
				case "exam01":
					for(int i=0; i<exam01.size() ; i++){
						output.add(exam01.get(i));
					}
//					System.arraycopy( Arrays.toString(exam01), 0, output, 0, exam01.length );
					break;
				case "exam02":
					System.arraycopy(exam02, 0, output, 0, exam02.size() );
					break;
				case "exam03":
					System.arraycopy( exam03, 0, output, 0, exam03.size());
					break;
				case "project":
					System.arraycopy( project, 0, output, 0, project.size() );
					break;
				case "total":	
					System.arraycopy( total, 0, output, 0, total.size() );
					break;
				}
				System.out.println("Output array --- " + output);
				scoreAnalysisBean.setOutputList(output);
				double[] outputArray = new double[output.size()];
				for(int i=0;i<outputArray.length ; i++){
					outputArray[i] = output.get(i);
				}
				double minValue = StatUtils.min(outputArray);
				System.out.println("min Val = " + minValue);
				scoreAnalysisBean.setMinVal(minValue);
				double maxValue = StatUtils.max(outputArray);
				System.out.println("max Val = " + maxValue);
				scoreAnalysisBean.setMaxVal(maxValue);
				double mean = StatUtils.mean(outputArray);
				scoreAnalysisBean.setMean(mean);
				double variance = StatUtils.variance(outputArray, mean);
				scoreAnalysisBean.setVariance(variance);
				double std = Math.sqrt(variance);
				scoreAnalysisBean.setStd(std);
				double median = StatUtils.percentile(outputArray, 50.0);
				scoreAnalysisBean.setMedian(median);
				double q1 = StatUtils.percentile(outputArray, 25.0);
				scoreAnalysisBean.setQ1(q1);
				double q3 = StatUtils.percentile(outputArray, 75.0);
				scoreAnalysisBean.setQ3(q3);
				double iqr = q3 - q1;
				scoreAnalysisBean.setIqr(iqr);
				double range = maxValue - minValue;
				scoreAnalysisBean.setRange(range);			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "SUCCESS"; 
		}
		
		
		
		//Create a pie chart----------------------------------------------------------------------------
		public String processPieChart()
		{
			try{
			chartBean = (ChartBean) m.get("chartBean");
			calculateGrade();
			JFreeChart chart; 
			File out = null;
			
			FacesContext context = FacesContext.getCurrentInstance(); 
			String path = context.getExternalContext().getRealPath("/files"); 
			System.out.println("Path is ===== " + path);
			  
			out = new File(path + "/pieChart.png"); 
			System.out.println("Output path for piechart ===>> " + out);
			chart= createPieChart();
		    ChartUtilities.saveChartAsPNG(out, chart, 600, 450);
		    chartBean.setPieChartRender(true);
		    chartBean.setFullPathPieChart("/files/pieChart.png");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			 return "Success";
		}
		
		//Create a pie chart----------------------------------------------------------------------------
		public String processBarChart()
		{
			chartBean = (ChartBean) m.get("chartBean");
			calculateGrade();
			JFreeChart chart; 
			File out = null;
			try{
			FacesContext context = FacesContext.getCurrentInstance(); 
			String path = context.getExternalContext().getRealPath("/files"); 
			System.out.println("Path is ===== " + path);
			  
			out = new File(path + "/barChart.png"); 
			System.out.println("Output path for barchart ===>> " + out);
			chart= createBarChart();
		    ChartUtilities.saveChartAsPNG(out, chart, 600, 450);
		    chartBean.setBarChartRender(true);
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			chartBean.setFullPathBarChart("/files/barChart.png");
			 //System.out.println(fullpath);
			 return "Success";
		}
		
		//Calculate the grades=-------------------------------------------------------------------------
		public void calculateGrade(){
			System.out.println("Enetered the calculate grade method");
			String sql1= "SELECT TotalMarks FROM f16g217_testSchedule where examType = '" + scoreAnalysisBean.getExamType() + "' AND crn = '"+ scoreAnalysisBean.getSelectedCrn() +"';"; 
			System.out.println("SQL1 = " + sql1);
			executeQuery(sql1);
			try {
				int totalMarks = 0;
				while(resultSet.next()){
					totalMarks = resultSet.getInt("TotalMarks");
				}
				System.out.println("Total marks of the exam is = " + totalMarks);
				int a = 0 ,b = 0,c = 0, d = 0,e = 0;
				double aTemp = 0.9 * totalMarks;
				double bTemp = 0.8 * totalMarks;
				double cTemp = 0.7 * totalMarks;
				double dTemp = 0.6 * totalMarks;
				System.out.println("a = " + aTemp + "   b = " + bTemp + "    c = " + cTemp + "   d  = " + dTemp);
				
				String sqlq = "SELECT Exam01,Exam02,Exam03,Project,Total FROM f16g217_STUDENT WHERE crn ='"+ scoreAnalysisBean.getSelectedCrn() + "';";
				System.out.println("sqlq = " + sqlq);
				ResultSet rs = statement1.executeQuery(sqlq);
				List<Double> exam01 = new ArrayList<Double>();
				List<Double> exam02 = new ArrayList<Double>();
				List<Double> exam03 = new ArrayList<Double>();
				List<Double> project = new ArrayList<Double>();
				List<Double> total = new ArrayList<Double>();
			
				System.out.println("Resultset size = " + rs.getFetchSize());
				while (rs.next()) {  
				   exam01.add(rs.getDouble("Exam01"));
				   exam02.add(rs.getDouble("Exam02"));
				   exam03.add(rs.getDouble("Exam03"));
				   project.add(rs.getDouble("Project"));
				   total.add(rs.getDouble("Total"));
				}
				System.out.println("Exam01 = " + exam01);
				System.out.println("Exam02 = " + exam02);
				System.out.println("Exam03 = " + exam03);
				System.out.println("Project = " +project);
				System.out.println("Total = " + total);
				List<Double> output = new ArrayList<Double>();
				switch(scoreAnalysisBean.getExamType()){
				case "exam01":
					for(int i=0; i<exam01.size() ; i++){
						output.add(exam01.get(i));
					}
					break;
				case "exam02":
					System.arraycopy(exam02, 0, output, 0, exam02.size() );
					break;
				case "exam03":
					System.arraycopy( exam03, 0, output, 0, exam03.size());
					break;
				case "project":
					System.arraycopy( project, 0, output, 0, project.size() );
					break;
				case "total":	
					System.arraycopy( total, 0, output, 0, total.size() );
					break;
				}
				System.out.println("Output array --- " + output);
				
				for(int i=0;i<output.size() ; i++){
					if(output.get(i) >= aTemp ){
						a++;
					}else if(output.get(i) >= bTemp && output.get(i) < aTemp){
						b++;
					}else if(output.get(i) >= cTemp && output.get(i) < bTemp){
						c++;
					}else if(output.get(i) >= dTemp && output.get(i) < cTemp){
						d++;
					}else if(output.get(i) < dTemp){
						e++;
					}
				}
				System.out.println("GRADE COUNT --->   a = " + a + "   b = " + b + "    c = " + c + "   d  = " + d + "    e = " + e);
				String sql = "INSERT INTO f16g217_Grades (examType, crn, a,b,c,d,e) values('"+scoreAnalysisBean.getExamType()+"','"+scoreAnalysisBean.getSelectedCrn()+"','"+ a +"','"+ b +"','"+ c +"', '"+ d +"' , '"+ e +"');";
				System.out.println("SQL statement = " + sql);
				statement1.executeUpdate(sql);
				System.out.println("Values entered successfully , end of the method");
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//Plot a pie chart--------------------------------------------------------------------------
		public JFreeChart createPieChart() { 
		
	      executeQuery("select a,b,c,d,e FROM f16g217_Grades WHERE crn ='" + scoreAnalysisBean.getSelectedCrn() +"' and examType = '"+ scoreAnalysisBean.getExamType() +"';");
	      DefaultPieDataset dataset = new DefaultPieDataset( );
	      List<String> headers = new ArrayList<String>();
	      headers.add("90% (A)");
	      headers.add("80% (B)");
	      headers.add("70% (C)");
	      headers.add("60% (D)");
	      headers.add("<60% (E)");
	      List<Integer> values = new ArrayList<Integer>();
	      try {
			while(resultSet.next()){
				values.add(resultSet.getInt("a"));
				values.add(resultSet.getInt("b"));
				values.add(resultSet.getInt("c"));
				values.add(resultSet.getInt("d"));
				values.add(resultSet.getInt("e"));
			}
	    	for(int i = 0 ; i < headers.size() ; i++){
				dataset.setValue( headers.get(i) , values.get(i));
			}
			
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      JFreeChart chart = ChartFactory.createPieChart(
	         "Pie Chart",  // chart title           
	         dataset,         // data           
	         true,            // include legend          
	         true,           
	         false );
		 return chart;  
		    
		}
	
		
		//clear descriptive analysis variables-----------------------------------------------------------
		public String clearDescriptiveAnalysis(){
			try{
			scoreAnalysisBean = (ScoreAnalysisBean) m.get("scoreAnalysisBean");
			List<Double> output = new ArrayList<Double>();
			scoreAnalysisBean.setOutputList(output);
			scoreAnalysisBean.setMinVal(0);
			scoreAnalysisBean.setQ1(0);
			scoreAnalysisBean.setMedian(0);
			scoreAnalysisBean.setQ3(0);
			scoreAnalysisBean.setMaxVal(0);
			scoreAnalysisBean.setMean(0);
			scoreAnalysisBean.setVariance(0);
			scoreAnalysisBean.setStd(0);
			scoreAnalysisBean.setRange(0);
			scoreAnalysisBean.setIqr(0);
			return "SUCCESS";
			}catch(Exception e){
				e.printStackTrace();
				return "FAIL";
			}
		}
		
		//method to get the end time------------------------------------------------
		public void calculateEndTime() {
			System.out.println("USER ID = " + userLoginBean.getUserName() + "     start time = " +startTime);
			 endTime = new Date(session.getLastAccessedTime());
			 System.out.println("----endAccessTime = " + endTime.toString());
			try {
				InetAddress ip = InetAddress.getLocalHost();
				System.out.println("Current IP address : " + ip.getHostAddress().toString());
				
				String sqlQuery = "INSERT INTO f16g217_transactionlog (`userName`, `startTime`, `endTime` , `ip`) VALUES ('"+ userLoginBean.getUserName() +"', '"+ startTime.toString() +"', '"+ endTime.toString() +"', '"+ ip.getHostAddress().toString() +"' );";
				System.out.println("SQL QUERY = " + sqlQuery);
				executeQuery(sqlQuery);
				System.out.println("INSERTED INTO TRANSACTION LOG SUCCESSFULLY!");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//Plot a pie chart--------------------------------------------------------------------------
		public JFreeChart createBarChart() { 
		
	      executeQuery("select a,b,c,d,e,examType FROM f16g217_Grades WHERE crn ='" + scoreAnalysisBean.getSelectedCrn() +"';");
	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      List<String> headers = new ArrayList<String>();
	      headers.add("90% (A)");
	      headers.add("80% (B)");
	      headers.add("70% (C)");
	      headers.add("60% (D)");
	      headers.add("<60% (E)");
	      List<Integer> values = new ArrayList<Integer>();
	      String examType = "";
	      List<String> values2 = new ArrayList<String>();
	      System.out.println("values = " + values );
	      try {
			while(resultSet.next()){
				values.add(resultSet.getInt("a"));
				values.add(resultSet.getInt("b"));
				values.add(resultSet.getInt("c"));
				values.add(resultSet.getInt("d"));
				values.add(resultSet.getInt("e"));
				examType = resultSet.getString("examType");
				break;
			}
			for(int i=0; i<headers.size();i++){
				values2.add(examType);
			}
			 System.out.println("values = " + values + "     values2 = " + values2 +  "    headers = " + headers);
	    	for(int i = 0 ; i < headers.size() ; i++){
				dataset.setValue(values.get(i), headers.get(i) , values2.get(i));
			}
			
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      JFreeChart chart = ChartFactory.createBarChart3D("Bar Chart","Category", "Value", dataset, PlotOrientation.VERTICAL, true, true, false);
		 return chart;  
		    
		}
		
		
		
		//method to close connection to database releasing resources------------------------------------------------
		public void closeConnection() {
			System.out.println("Called Close connection method!");
			try {
				if(connection!=null){
					resultSet.close();
					statement.close();
					connection.close();
				}
			} 
			catch (SQLException e) {
				System.err.println(e.getMessage() + "\n");
				System.err.println(e.toString() + "\n");
				e.printStackTrace();
			} 
			catch (Exception e) {
				System.err.println(e.getMessage() + "\n");
				System.err.println(e.toString() + "\n");
				e.printStackTrace();
			}
		}
		
		//getters and setters-------------------------------------------------------------------------------------------
		public void setUrl(String url) {
			this.url = url;
		}

		public void setConnection(Connection connection) {
			this.connection = connection;
		}

		public void setDatabaseMetaData(DatabaseMetaData databaseMetaData) {
			this.databaseMetaData = databaseMetaData;
		}

		public void setStatement(Statement statement) {
			this.statement = statement;
		}
		
		public void setStatement1(Statement statement1) {
			this.statement1 = statement1;
		}
		
		public ResultSet getResultSet() {
			return resultSet;
		}

		public void setResultSet(ResultSet resultSet) {
			this.resultSet = resultSet;
		}

		public void setResultSetMetaData(ResultSetMetaData resultSetMetaData) {
			this.resultSetMetaData = resultSetMetaData;
		}

		public List<TestBean> getTestBeanList() {
			return testBeanList;
		}

		public void setTestBeanList(List<TestBean> testBeanList) {
			this.testBeanList = testBeanList;
		}

		public ResultSet getResultSetCopy() {
			return resultSetCopy;
		}

		public void setResultSetCopy(ResultSet resultSetCopy) {
			this.resultSetCopy = resultSetCopy;
		}
		
		
		
}
