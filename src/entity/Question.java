package entity;

public abstract class Question {
	private String prompt;

	protected Question(String prompt) {
		this.prompt = prompt;
	}

	public String getPrompt() {
		return this.prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	@Override
	public abstract String toString();
}