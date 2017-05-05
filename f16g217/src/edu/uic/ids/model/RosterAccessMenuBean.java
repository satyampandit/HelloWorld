package edu.uic.ids.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

public class RosterAccessMenuBean  implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	//inputs
	private String rosterType;
	private List <String> crnList ;//= Arrays.asList("sup1", "sup2", "sup3");
	private String selectedCrn;
	private List <String> examTypeList = Arrays.asList("Exam01", "Exam02", "Exam03", "Project");
	private String selectedExamType;
	private String action;
	private String message;
	private boolean renderMessage;
	
	private ResultSet testRosterResultSet;
	private boolean renderTestRosterResultSet;
	private List <String> testRosterColumns;
	
	private ResultSet studentRosterResultSet;
	private boolean renderStudentRosterResultSet;
	private List <String> studentRosterColumns;
	private String errorMessage;
	
	public RosterAccessMenuBean(){
		renderTestRosterResultSet = false;
		renderStudentRosterResultSet = false;
		renderMessage = false;
		errorMessage = "";
	}
	
	//getters and setters----------------------------------------------------
	public List<String> getCrnList() {
		System.out.println(crnList);
		return crnList;
	}
	public void setCrnList(List<String> crnList) {
		this.crnList = crnList;
	}
	public String getSelectedCrn() {
		return selectedCrn;
	}
	public void setSelectedCrn(String selectedCrn) {
		this.selectedCrn = selectedCrn;
	}
	public List<String> getExamTypeList() {
		return examTypeList;
	}
	public void setExamTypeList(List<String> examTypeList) {
		this.examTypeList = examTypeList;
	}
	public String getSelectedExamType() {
		return selectedExamType;
	}
	public void setSelectedExamType(String selectedExamType) {
		this.selectedExamType = selectedExamType;
	}

	public ResultSet getTestRosterResultSet() {
		return testRosterResultSet;
	}

	public void setTestRosterResultSet(ResultSet testRosterResultSet) {
		this.testRosterResultSet = testRosterResultSet;
	}

	public boolean isRenderTestRosterResultSet() {
		return renderTestRosterResultSet;
	}

	public void setRenderTestRosterResultSet(boolean renderTestRosterResultSet) {
		this.renderTestRosterResultSet = renderTestRosterResultSet;
	}

	public List<String> getTestRosterColumns() {
		return testRosterColumns;
	}

	public void setTestRosterColumns(List<String> testRosterColumns) {
		this.testRosterColumns = testRosterColumns;
	}

	public ResultSet getStudentRosterResultSet() {
		return studentRosterResultSet;
	}

	public void setStudentRosterResultSet(ResultSet studentRosterResultSet) {
		this.studentRosterResultSet = studentRosterResultSet;
	}

	public boolean isRenderStudentRosterResultSet() {
		return renderStudentRosterResultSet;
	}

	public void setRenderStudentRosterResultSet(boolean renderStudentRosterResultSet) {
		this.renderStudentRosterResultSet = renderStudentRosterResultSet;
	}

	public List<String> getStudentRosterColumns() {
		return studentRosterColumns;
	}

	public void setStudentRosterColumns(List<String> studentRosterColumns) {
		this.studentRosterColumns = studentRosterColumns;
	}

	public String getRosterType() {
		return rosterType;
	}

	public void setRosterType(String rosterType) {
		this.rosterType = rosterType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRenderMessage() {
		return renderMessage;
	}

	public void setRenderMessage(boolean renderMessage) {
		this.renderMessage = renderMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}




}
