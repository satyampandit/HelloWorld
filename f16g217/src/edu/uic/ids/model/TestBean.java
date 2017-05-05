package edu.uic.ids.model;

import java.io.Serializable;
import java.sql.ResultSet;

public class TestBean implements Serializable, Cloneable {
	
			private static final long serialVersionUID = 1L;
		//inputs
			private ResultSet resultSet;
			private String testId;
		    private String question;
		    private double answer;
		    private double userAnswer;
		    private double tolerance;
		    private int finalScore;

			private boolean renderMessage;
		    private boolean renderList;
			private boolean QuestionPaperRenderList;
			private boolean scoreRender;
			private String errorMessage;
		
			//private Map<String, String> userAnswer = new HashMap<String, String>();
			
		//outputs
			private String outputMessage;
			
			public TestBean(){
				outputMessage = "";
				errorMessage = "";
				renderList = false;
				QuestionPaperRenderList = false;
				renderMessage = false;
				scoreRender = false;
			}
			
			public TestBean clone() throws CloneNotSupportedException {
				TestBean cloned = (TestBean) super.clone();
				return cloned;
			}
			
		/*	public String submitMethod(){
				this.setRenderMessage(true);
				this.setQuestionPaperRenderList(false);
				return "SUCCESS";
			}*/
			
		//getters and setters-------------------------------------------------------------

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
			
			public String getTestId() {
				return testId;
			}

			public void setTestId(String testId) {
				this.testId = testId;
			}
			
		
			public boolean isQuestionPaperRenderList() {
				return QuestionPaperRenderList;
			}

			public void setQuestionPaperRenderList(boolean questionPaperRenderList) {
				QuestionPaperRenderList = questionPaperRenderList;
			}

			public String getOutputMessage() {
				return outputMessage;
			}
			public void setOutputMessage(String outputMessage) {
				this.outputMessage = outputMessage;
			}

			public boolean isRenderMessage() {
				return renderMessage;
			}
			public void setRenderMessage(boolean renderMessage) {
				this.renderMessage = renderMessage;
			}

			public String getQuestion() {
				return question;
			}

			public void setQuestion(String question) {
				this.question = question;
			}

			public double getAnswer() {
				return answer;
			}

			public void setAnswer(double answer) {
				this.answer = answer;
			}

			public double getUserAnswer() {
				return userAnswer;
			}

			public void setUserAnswer(double userAnswer) {
				this.userAnswer = userAnswer;
			}

			public double getTolerance() {
				return tolerance;
			}

			public void setTolerance(double tolerance) {
				this.tolerance = tolerance;
			}

			public boolean isScoreRender() {
				return scoreRender;
			}

			public void setScoreRender(boolean scoreRender) {
				this.scoreRender = scoreRender;
			}

			public int getFinalScore() {
				return finalScore;
			}

			public void setFinalScore(int finalScore) {
				this.finalScore = finalScore;
			}

			public String getErrorMessage() {
				return errorMessage;
			}

			public void setErrorMessage(String errorMessage) {
				this.errorMessage = errorMessage;
			}

		
			
			

}
