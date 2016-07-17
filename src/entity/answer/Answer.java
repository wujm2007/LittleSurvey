package entity.answer;

import java.io.Serializable;

import entity.question.Question;

@SuppressWarnings("serial")
public abstract class Answer implements Serializable {
	private final Question question;

	public Answer(Question question) {
		this.question = question;
	}

	public final Question getQuestion() {
		return question;
	}

	public abstract boolean match(Answer answer);

	public abstract String toString();
}
