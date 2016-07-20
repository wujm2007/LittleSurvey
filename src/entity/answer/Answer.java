package entity.answer;

import java.io.Serializable;

import entity.question.Question;
import util.visitor.AnswerVisitor;

/*
 * This is the Answer interface (an abstract class to be exact).
 * 
 * It holds the Question of the answer and nothing more.
 * 
 * It has a method public boolean match(Answer answer) to check whether a 
 * given Answer matches this one (i.e. is correct).
 * 
 * It also implements the Visitor Pattern, so it has a method 
 * public abstract void accept(AnswerVisitor v). (Mainly for initialize an answer).
 */

@SuppressWarnings("serial")
public abstract class Answer implements Serializable {
	private final Question question;

	public Answer(Question question) {
		this.question = question;
	}

	public Question getQuestion() {
		return question;
	}

	//
	public abstract void accept(AnswerVisitor v);

	/*
	 * Return the answer value (whose type varies). Every subclass must
	 * implement it so that every 2 answer could be checked if they are the
	 * same.
	 */
	public abstract Object getValue();

	public boolean match(Answer answer) {
		// check if the answer is of the same question
		if ((answer == null) || (getQuestion() != answer.getQuestion()))
			return false;
		else
			return getValue().equals(answer.getValue());
	}

	// Return the String form of the Answer for printing
	public abstract String toString();
}
