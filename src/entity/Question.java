package entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Question implements Serializable {
	private String prompt;

	public Question(String prompt) {
		this.prompt = prompt;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	@Override
	public abstract String toString();
}