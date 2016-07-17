package entity.question;

import java.io.Serializable;

import entity.answer.Answer;
import util.IOHelper;

@SuppressWarnings("serial")
public abstract class Question implements Serializable {

	public IOHelper io() {
		return IOHelper.getInstance();
	}

	public abstract String getPrompt();

	public abstract void setPrompt(String prompt);

	@Override
	public abstract String toString();

	public abstract void modify();

	public abstract Answer makeAnswer();
}