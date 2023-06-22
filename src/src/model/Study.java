package model;
import java.io.Serializable;

public class Study implements Serializable {
	private int word_id; //WORD_ID
	private String word_item; //WORD_ITEM
	private String word_ex; //WORD_EX
	
	public Study(int word_id, String word_item, String word_ex) {
		this.word_id = word_id;
		this.word_item = word_item;
		this.word_ex = word_ex;
	}
	
	public Study() {}

	public int getWord_id() {
		return word_id;
	}

	public void setWord_id(int word_id) {
		this.word_id = word_id;
	}

	public String getWord_item() {
		return word_item;
	}

	public void setWord_item(String word_item) {
		this.word_item = word_item;
	}

	public String getWord_ex() {
		return word_ex;
	}

	public void setWord_ex(String word_ex) {
		this.word_ex = word_ex;
	}
	
	
	
}
