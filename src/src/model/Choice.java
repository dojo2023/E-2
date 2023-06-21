package model;

import java.io.Serializable;

public class Choice implements Serializable{
	private int choices_id;
	private String choices;
	private String choices_2;
	private String choices_3;
	private String choices_4;
	private boolean is_answer;
	private int quiz_id;

	public Choice(String choices,boolean is_answer) {
		super();
		this.choices = choices;
		this.is_answer = is_answer;
	}

	public Choice(int choices_id, String choices, String choices_2, String choices_3, String choices_4,
			boolean is_answer, int quiz_id) {
		super();
		this.choices_id = choices_id;
		this.choices = choices;
		this.choices_2 = choices_2;
		this.choices_3 = choices_3;
		this.choices_4 = choices_4;
		this.is_answer = is_answer;
		this.quiz_id = quiz_id;
	}

	public Choice() {
		super();
		this.choices_id = 1;
		this.choices = "";
		this.choices_2 = "";
		this.choices_3 = "";
		this.choices_4 = "";
		this.is_answer = true;
		this.quiz_id = 1;
	}

	public int getChoices_id() {
		return choices_id;
	}

	public void setChoices_id(int choices_id) {
		this.choices_id = choices_id;
	}

	public String getChoices() {
		return choices;
	}

	public void setChoices(String choices) {
		this.choices = choices;
	}

	public String getChoices_2() {
		return choices_2;
	}

	public void setChoices_2(String choices_2) {
		this.choices_2 = choices_2;
	}

	public String getChoices_3() {
		return choices_3;
	}

	public void setChoices_3(String choices_3) {
		this.choices_3 = choices_3;
	}

	public String getChoices_4() {
		return choices_4;
	}

	public void setChoices_4(String choices_4) {
		this.choices_4 = choices_4;
	}

	public boolean isIs_answer() {
		return is_answer;
	}

	public void setIs_answer(boolean is_answer) {
		this.is_answer = is_answer;
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}


}
