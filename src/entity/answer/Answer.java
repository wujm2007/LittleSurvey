package entity.answer;

import java.io.Serializable;

import entity.question.Question;
import util.visitor.AnswerVisitor;

@SuppressWarnings("serial")
public abstract class Answer implements Serializable {
	private final Question question;

	public Answer(Question question) {
		this.question = question;
	}

	public Question getQuestion() {
		return question;
	}

	public abstract void accept(AnswerVisitor v);

	public abstract Object getValue();

	public boolean match(Answer answer) {
		if ((answer == null) || (getQuestion() != answer.getQuestion()))
			return false;
		else
			return getValue().equals(answer.getValue());
	}

	public abstract String toString();
}
