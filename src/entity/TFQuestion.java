package entity;

@SuppressWarnings("serial")
public class TFQuestion extends Question {
	private String prompt;

	@Override
	protected String getPrompt() {
		return prompt;
	}

	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public TFQuestion() {
		setPrompt(io().readPrompt("True/False"));
	}

	@Override
	public String toString() {
		return "" + getPrompt() + "\n" + "T/F\n";
	}
}
