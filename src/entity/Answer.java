package entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Answer implements Serializable {
	private final Question question;
	private Object answer;

	public Answer(Question question, Object answer) {
		this.question = question;
		this.answer = answer;
	}

	public final Question getQuestion() {
		return this.question;
	}

	public final Object getValue() {
		return this.answer;
	}

	public boolean match(Answer answer) {
		if ((this.getQuestion() == answer.getQuestion()) && (this.getValue().equals(answer.getValue())))
			return true;
		else
			return false;
	}

}
