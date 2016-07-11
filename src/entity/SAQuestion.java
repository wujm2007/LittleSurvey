package entity;

@SuppressWarnings("serial")
public class SAQuestion extends Question {
	private String prompt;

	@Override
	protected String getPrompt() {
		return prompt;
	}

	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public SAQuestion() {
		setPrompt(io().readPrompt("short answer"));
	}

	@Override
	public String toString() {
		String result = this.getPrompt() + "\n";
		return result;
	}
}
