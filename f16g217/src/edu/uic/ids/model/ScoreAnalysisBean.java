package edu.uic.ids.model;

import java.io.Serializable;
import java.util.List;

public class ScoreAnalysisBean implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	//inputs
	private String selectedCrn;
	private List<String> crnList;
	private String examType;
	private boolean renderMessage;
	private List<Double> outputList;
	private double minVal;
	private double maxVal;
	private double mean;
	private double variance;
	private double std;
	private double median;
	private double q1;
	private double q3;
	private double iqr;
	private double range;
	
	
	//outputs
		private String errorMessage;
	
	public ScoreAnalysisBean(){
		errorMessage = "";
		renderMessage = false;
	}

	
	//getter and setters------------------------------------------------------
	
	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
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

	public List<Double> getOutputList() {
		return outputList;
	}


	public void setOutputList(List<Double> outputList) {
		this.outputList = outputList;
	}


	public double getMinVal() {
		return minVal;
	}


	public void setMinVal(double minVal) {
		this.minVal = minVal;
	}


	public double getMaxVal() {
		return maxVal;
	}


	public void setMaxVal(double maxVal) {
		this.maxVal = maxVal;
	}


	public double getMean() {
		return mean;
	}


	public void setMean(double mean) {
		this.mean = mean;
	}


	public double getVariance() {
		return variance;
	}


	public void setVariance(double variance) {
		this.variance = variance;
	}


	public double getStd() {
		return std;
	}


	public void setStd(double std) {
		this.std = std;
	}


	public double getMedian() {
		return median;
	}


	public void setMedian(double median) {
		this.median = median;
	}


	public double getQ1() {
		return q1;
	}


	public void setQ1(double q1) {
		this.q1 = q1;
	}


	public double getQ3() {
		return q3;
	}


	public void setQ3(double q3) {
		this.q3 = q3;
	}


	public double getIqr() {
		return iqr;
	}


	public void setIqr(double iqr) {
		this.iqr = iqr;
	}


	public double getRange() {
		return range;
	}


	public void setRange(double range) {
		this.range = range;
	}


	public String getSelectedCrn() {
		return selectedCrn;
	}


	public void setSelectedCrn(String selectedCrn) {
		this.selectedCrn = selectedCrn;
	}


	public List<String> getCrnList() {
		return crnList;
	}


	public void setCrnList(List<String> crnList) {
		this.crnList = crnList;
	}

	
}
