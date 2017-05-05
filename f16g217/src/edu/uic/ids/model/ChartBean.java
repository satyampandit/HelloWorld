package edu.uic.ids.model;

public class ChartBean {
	
	private boolean pieChartRender;
	private boolean barChartRender;
	private String fullPathPieChart;
	private String fullPathBarChart;
	private String msg;
	private String errorMessage;
	
	public ChartBean() {
		// TODO Auto-generated constructor stub
		pieChartRender = false;
		barChartRender = false;
		msg="";
		errorMessage = "";
	}

	//getter and setter-----------------------------------------------------------------
	



	public boolean isPieChartRender() {
		return pieChartRender;
	}

	public void setPieChartRender(boolean pieChartRender) {
		this.pieChartRender = pieChartRender;
	}

	public boolean isBarChartRender() {
		return barChartRender;
	}

	public void setBarChartRender(boolean barChartRender) {
		this.barChartRender = barChartRender;
	}

	public String getFullPathPieChart() {
		return fullPathPieChart;
	}

	public void setFullPathPieChart(String fullPathPieChart) {
		this.fullPathPieChart = fullPathPieChart;
	}

	public String getFullPathBarChart() {
		return fullPathBarChart;
	}

	public void setFullPathBarChart(String fullPathBarChart) {
		this.fullPathBarChart = fullPathBarChart;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	
}
