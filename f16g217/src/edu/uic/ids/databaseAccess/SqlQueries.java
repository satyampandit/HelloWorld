package edu.uic.ids.databaseAccess;

public class SqlQueries {
	
	//private static String schema = "CREATE DATABASE IF NOT EXISTS f16g217;";
	
	private static String userLoginTable = "CREATE TABLE IF NOT EXISTS f16g217_userLogin ("
			  +"`userLoginNo` Integer Primary Key auto_increment,"
			  +"`userName` VARCHAR(45) NOT NULL unique,"
			  +"`password` VARCHAR(45) NOT NULL,"
			  +"`userType` VARCHAR(45) NOT NULL);";

	private static String insertIntoUserLoginTable1 = "INSERT INTO f16g217_userlogin (`userName`, `password`, `userType`) VALUES ('admin', 'admin', 'admin') ON DUPLICATE KEY UPDATE userLoginNo = 1;";
	private static String insertIntoUserLoginTable2 = "INSERT INTO f16g217_userlogin (`userName`, `password`, `userType`) VALUES ('U1', 'U1', 'student') ON DUPLICATE KEY UPDATE userLoginNo = 2;";
	private static String insertIntoUserLoginTable3 = "INSERT INTO f16g217_userlogin (`userName`, `password`, `userType`) VALUES ('U2', 'U2', 'student') ON DUPLICATE KEY UPDATE userLoginNo = 3;";
	private static String insertIntoUserLoginTable4 = "INSERT INTO f16g217_userlogin (`userName`, `password`, `userType`) VALUES ('U3', 'U3', 'student') ON DUPLICATE KEY UPDATE userLoginNo = 4;";
	private static String insertIntoUserLoginTable5 = "INSERT INTO f16g217_userlogin (`userName`, `password`, `userType`) VALUES ('U4', 'U4', 'student') ON DUPLICATE KEY UPDATE userLoginNo = 5;";
	private static String insertIntoUserLoginTable6 = "INSERT INTO f16g217_userlogin (`userName`, `password`, `userType`) VALUES ('U5', 'U5', 'student') ON DUPLICATE KEY UPDATE userLoginNo = 6;";
	private static String insertIntoUserLoginTable7 = "INSERT INTO f16g217_userlogin (`userName`, `password`, `userType`) VALUES ('U6', 'U6', 'student') ON DUPLICATE KEY UPDATE userLoginNo = 7;";
	private static String insertIntoUserLoginTable8 = "INSERT INTO f16g217_userlogin (`userName`, `password`, `userType`) VALUES ('instructor', 'instructor', 'instructor') ON DUPLICATE KEY UPDATE userLoginNo = 8;";
	
	private static String studentTable = "CREATE TABLE IF NOT EXISTS f16g217_student ("
			+ "  `Last_Name` VARCHAR(45),"
			+ "  `First_Name` VARCHAR(45) NOT NULL,"
			+ "  `Username` VARCHAR(45) NOT NULL,"
			+ "  `Student_ID` VARCHAR(45) NOT NULL,"
			+ "  `Last_Access` VARCHAR(45),"
			+ "  `Availability` VARCHAR(45) NOT NULL,"
			+ "  `Total` DOUBLE,"
			+ "  `Exam01` DOUBLE,"
			+ "  `Exam02` DOUBLE,"
			+ "  `Exam03` DOUBLE,"
			+ "   `Project` DOUBLE,"
			+ "  `crn` VARCHAR(45) NOT NULL);";
	
/*	private static String instructorTable = "CREATE TABLE IF NOT EXISTS  `f16g217`.`instructor` ("
			 + "`lastName` VARCHAR(45)  NOT NULL,"
			 + "`firstName` VARCHAR(45) NOT NULL,"
			 +"  `userName` VARCHAR(45) NOT NULL,"
			 +"  `UIN` VARCHAR(45) PRIMARY KEY NOT NULL);";*/
	
	private static String coursesTable = "CREATE TABLE IF NOT EXISTS  f16g217_courses ("
			+ "  `crn` VARCHAR(45),"
			+ "  `code` VARCHAR(45) NOT NULL,"
			+ "  `description` VARCHAR(45) NOT NULL);";

	private static String testRepositoryTable = "CREATE TABLE IF NOT EXISTS f16g217_testrepository ("
			+ " `questionType` VARCHAR(45)  NOT NULL,"
			+ "  `examId` int NOT NULL,"
			+ "  `question` VARCHAR(45) NOT NULL,"
			+ "  `answer` VARCHAR(45) NOT NULL,"
			+ "  `tolerance` VARCHAR(45) NOT NULL);";
	
	private static String testScheduleTable = "  CREATE TABLE IF NOT EXISTS f16g217_testschedule ("
			+ "  `examId`  int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
			+ "  `examType`  VARCHAR(45) NOT NULL,"
			+ "  `CRN` VARCHAR(45)  NOT NULL,"
			+ "  `courseCode` VARCHAR(45) NOT NULL,"
			+ "  `TotalMarks` int NOT NULL,"
			+ "  `AvailabilityStartDate` VARCHAR(10) NOT NULL,"
			+ "  `AvailabilityEndDate` VARCHAR(10) NOT NULL,"
			+ "  `Duration` VARCHAR(45) NOT NULL);";
	
	private static String transactionLogTable = "CREATE TABLE IF NOT EXISTS f16g217_transactionLog ( "
			+ " transactionLogID Integer Primary Key auto_increment, "
			+ " userName VARCHAR(45) NOT NULL, "
			+ " startTime  VARCHAR(45) NOT NULL, "
			+ " endTime  VARCHAR(45) NOT NULL, "
			+ " ip VARCHAR(45) NOT NULL);";
	
	private static String gradesTable = "CREATE TABLE IF NOT EXISTS f16g217_Grades ("
			+ " gradeID Integer Primary Key auto_increment,"
			+ " examType VARCHAR(45) NOT NULL,"
			+ " crn VARCHAR(45) NOT NULL,"
			+ " a int NOT NULL,"
			+ " b int NOT NULL,"
			+ " c int NOT NULL,"
			+ " d int NOT NULL,"
			+ " e int NOT NULL);";
	
	//getters-----------------------------------------------------------------------
	public static String getUserLoginTable() {
		return userLoginTable;
	}

	public static String getInsertIntoUserLoginTable1() {
		return insertIntoUserLoginTable1;
	}

	public static String getInsertIntoUserLoginTable2() {
		return insertIntoUserLoginTable2;
	}

	public static String getInsertIntoUserLoginTable3() {
		return insertIntoUserLoginTable3;
	}
	
	public static String getInsertIntoUserLoginTable4() {
		return insertIntoUserLoginTable4;
	}

	public static String getInsertIntoUserLoginTable5() {
		return insertIntoUserLoginTable5;
	}

	public static String getInsertIntoUserLoginTable6() {
		return insertIntoUserLoginTable6;
	}

	public static String getInsertIntoUserLoginTable7() {
		return insertIntoUserLoginTable7;
	}

	public static String getInsertIntoUserLoginTable8() {
		return insertIntoUserLoginTable8;
	}

	
	public static String getTransactionLogTable() {
		return transactionLogTable;
	}

	public static String getStudentTable() {
		return studentTable;
	}

	/*public static String getInstructorTable() {
		return instructorTable;
	}*/

	public static String getCoursesTable() {
		return coursesTable;
	}

	public static String getTestRepositoryTable() {
		return testRepositoryTable;
	}

	public static String getTestScheduleTable() {
		return testScheduleTable;
	}

	public static String getGradesTable() {
		return gradesTable;
	}

	/*public static String getSchema() {
		return schema;
	}*/
	
	
	
}
