package entity.question;

import java.io.Serializable;

import entity.answer.Answer;
import util.visitor.InitQuestionVisitor;
import util.visitor.QuestionVisitor;

/*
 * This is the Question interface (an abstract class to be exact).
 * 
 * It holds a String prompt.
 * 
 * It implements Visitor Pattern so it has a method
 * public abstract void accept(QuestionVisitor v).
 * 
 * It also has a method public abstract Answer makeAnswer(), which
 * is a Factory Method creating an Answer specific to some type of Question.
 */
@SuppressWarnings("serial")
public abstract class Question implements Serializable {
	private String prompt;

	// Use a InitQuestionVisitor to initialize itself
	public Question() {
		accept(new InitQuestionVisitor());
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public abstract Answer makeAnswer();

	// Return the String form of the Question for printing
	@Override
	public abstract String toString();

	public abstract void accept(QuestionVisitor v);
}