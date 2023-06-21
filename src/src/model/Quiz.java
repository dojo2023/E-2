package model;
import java.io.Serializable;

public class Quiz implements Serializable{
	private int quiz_id;
	private String quiz;
	private String quiz_ex;

	public Quiz() {
		super();
	}

	public int getQuiz_Id() {
		return quiz_id;
	}

	public void setQuiz_Id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public String getQuiz() {
		return quiz;
	}

	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}

	public String getQuiz_Ex() {
		return quiz_ex;
	}

	public void setQuiz_Ex(String quiz_ex) {
		this.quiz_ex = quiz_ex;
	}

}
