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

	public abstract Object getValue();

	public boolean match(Answer answer) {
		if ((answer == null) || (getQuestion() != answer.getQuestion()))
			return false;
		else
			return getValue().equals(((MatchingAnswer) answer).getValue());
	}

	public abstract String toString();
}
