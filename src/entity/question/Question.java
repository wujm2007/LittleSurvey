package entity.question;

import java.io.Serializable;

import entity.answer.Answer;
import util.visitor.InitQuestionVisitor;
import util.visitor.ModifyQuestionVisitor;
import util.visitor.QuestionVisitor;

@SuppressWarnings("serial")
public abstract class Question implements Serializable {
	private String prompt;

	public Question() {
		accept(new InitQuestionVisitor());
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public void modify() {
		accept(new ModifyQuestionVisitor());
	}

	public abstract Answer makeAnswer();

	@Override
	public abstract String toString();

	public abstract void accept(QuestionVisitor v);
}