package edu.uic.ids.model;

import java.sql.ResultSet;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import org.apache.commons.fileupload.*;
import org.apache.myfaces.custom.fileupload.UploadedFile;

@ManagedBean
@SessionScoped
public class UploadFileBean {
	
	private UploadedFile uploadedFile; 	
	private String fileName;
	private String fileType;
	private int columnCount;
	private int rowCount;
	private ResultSet testResultSet;
	private ResultSet courseResultSet;
	private ResultSet studentResultSet;
	private ResultSet instructorResultSet;
	private ResultSet testScheduleResultSet;
	private List <String> coursesColumnList;
	private List <String> testColumnList;
	private List <String> testScheduleColumnList;
	private List <String> studentColumnList;
	private List <String> instructorColumnList;
	private boolean renderCourseUploadMessage;
	private boolean renderInstructorUploadMessage;
	private boolean renderStudentUploadMessage;
	private boolean renderTestScheduleMessage;
	private boolean renderQuestionPaperMessage;
	private boolean renderErrorMessage;
	private String errorMessage;
	//private FileItem uploadedFile;
	
	private String courseName;
	private String courseCode;
	private String selectedCrn;
	private String startDate;
	private String endDate;
	private String duration;
	private String examType;
	private int pointsPerQuestion;
	private String overrideTest;
	private String fileLabel;
	private String fileFunction;
	private String headerRow;
	
	public UploadFileBean(){
		renderCourseUploadMessage=false;
		renderInstructorUploadMessage=false;
		renderStudentUploadMessage=false;
		renderTestScheduleMessage=false;
		renderQuestionPaperMessage=false;
		renderErrorMessage=false;
		
	}
	
	
	public String reset(){
		renderCourseUploadMessage=false;
		renderInstructorUploadMessage=false;
		renderStudentUploadMessage=false;
		renderTestScheduleMessage=false;
		renderQuestionPaperMessage=false;
		renderErrorMessage=false;
		return "SUCCESS";
	}
	
	//getter and setter-----------------------------------------------------
	public UploadedFile getUploadedFile() {
		System.out.println("GET UPLOADED FILE = " + uploadedFile);
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public ResultSet getTestResultSet() {
		return testResultSet;
	}

	public void setTestResultSet(ResultSet testResultSet) {
		this.testResultSet = testResultSet;
	}

	public boolean isRenderCourseUploadMessage() {
		return renderCourseUploadMessage;
	}


	public void setRenderCourseUploadMessage(boolean renderCourseUploadMessage) {
		this.renderCourseUploadMessage = renderCourseUploadMessage;
	}


	public boolean isRenderInstructorUploadMessage() {
		return renderInstructorUploadMessage;
	}


	public void setRenderInstructorUploadMessage(boolean renderInstructorUploadMessage) {
		this.renderInstructorUploadMessage = renderInstructorUploadMessage;
	}


	public boolean isRenderStudentUploadMessage() {
		return renderStudentUploadMessage;
	}


	public void setRenderStudentUploadMessage(boolean renderStudentUploadMessage) {
		this.renderStudentUploadMessage = renderStudentUploadMessage;
	}


	public boolean isRenderTestScheduleMessage() {
		return renderTestScheduleMessage;
	}


	public void setRenderTestScheduleMessage(boolean renderTestScheduleMessage) {
		this.renderTestScheduleMessage = renderTestScheduleMessage;
	}


	public boolean isRenderQuestionPaperMessage() {
		return renderQuestionPaperMessage;
	}


	public void setRenderQuestionPaperMessage(boolean renderQuestionPaperMessage) {
		this.renderQuestionPaperMessage = renderQuestionPaperMessage;
	}

	public boolean isRenderErrorMessage() {
		return renderErrorMessage;
	}


	public void setRenderErrorMessage(boolean renderErrorMessage) {
		this.renderErrorMessage = renderErrorMessage;
	}


	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public int getColumnCount() {
		return columnCount;
	}


	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}


	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}


	public ResultSet getCourseResultSet() {
		return courseResultSet;
	}


	public void setCourseResultSet(ResultSet courseResultSet) {
		this.courseResultSet = courseResultSet;
	}


	public ResultSet getStudentResultSet() {
		return studentResultSet;
	}


	public void setStudentResultSet(ResultSet studentResultSet) {
		this.studentResultSet = studentResultSet;
	}


	public ResultSet getInstructorResultSet() {
		return instructorResultSet;
	}


	public void setInstructorResultSet(ResultSet instructorResultSet) {
		this.instructorResultSet = instructorResultSet;
	}


	public ResultSet getTestScheduleResultSet() {
		return testScheduleResultSet;
	}


	public void setTestScheduleResultSet(ResultSet testScheduleResultSet) {
		this.testScheduleResultSet = testScheduleResultSet;
	}


	public List<String> getCoursesColumnList() {
		return coursesColumnList;
	}


	public void setCoursesColumnList(List<String> coursesColumnList) {
		this.coursesColumnList = coursesColumnList;
	}


	public List<String> getTestColumnList() {
		return testColumnList;
	}


	public void setTestColumnList(List<String> testColumnList) {
		this.testColumnList = testColumnList;
	}


	public List<String> getTestScheduleColumnList() {
		return testScheduleColumnList;
	}


	public void setTestScheduleColumnList(List<String> testScheduleColumnList) {
		this.testScheduleColumnList = testScheduleColumnList;
	}


	public List<String> getStudentColumnList() {
		return studentColumnList;
	}


	public void setStudentColumnList(List<String> studentColumnList) {
		this.studentColumnList = studentColumnList;
	}


	public List<String> getInstructorColumnList() {
		return instructorColumnList;
	}


	public void setInstructorColumnList(List<String> instructorColumnList) {
		this.instructorColumnList = instructorColumnList;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	


	public String getSelectedCrn() {
		return selectedCrn;
	}


	public void setSelectedCrn(String selectedCrn) {
		this.selectedCrn = selectedCrn;
	}

/*
	public List<String> getCrnList() {
		return crnList;
	}


	public void setCrnList(List<String> crnList) {
		this.crnList = crnList;
	}
*/

	public String getFileLabel() {
		return fileLabel;
	}


	public void setFileLabel(String fileLabel) {
		this.fileLabel = fileLabel;
	}


	public String getFileFunction() {
		return fileFunction;
	}


	public void setFileFunction(String fileFunction) {
		this.fileFunction = fileFunction;
	}


	public String getHeaderRow() {
		return headerRow;
	}


	public void setHeaderRow(String headerRow) {
		this.headerRow = headerRow;
	}


	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	

	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getExamType() {
		return examType;
	}


	public void setExamType(String examType) {
		this.examType = examType;
	}


	public int getPointsPerQuestion() {
		return pointsPerQuestion;
	}


	public void setPointsPerQuestion(int pointsPerQuestion) {
		this.pointsPerQuestion = pointsPerQuestion;
	}


	public String getOverrideTest() {
		return overrideTest;
	}


	public void setOverrideTest(String overrideTest) {
		this.overrideTest = overrideTest;
	}


	
}