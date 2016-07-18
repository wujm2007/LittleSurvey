package entity.question;

import java.io.Serializable;

import entity.answer.Answer;
import util.IOHelper;
import util.visitor.InitVisitor;
import util.visitor.ModifyVisitor;
import util.visitor.QuestionVisitor;

@SuppressWarnings("serial")
public abstract class Question implements Serializable {
	private String prompt;

	public Question() {
		accept(new InitVisitor());
	}

	public IOHelper io() {
		return IOHelper.getInstance();
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public void modify() {
		accept(new ModifyVisitor());
	}

	public abstract Answer makeAnswer();

	@Override
	public abstract String toString();

	public abstract void accept(QuestionVisitor v);
}