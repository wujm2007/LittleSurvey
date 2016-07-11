package entity;

@SuppressWarnings("serial")
public class EssayQuestion extends Question {
	private String prompt;

	protected EssayQuestion() {
		init();
	}

	private void init() {
		setPrompt(io().readPrompt("essay"));
	}

	@Override
	public String toString() {
		String result = getPrompt() + "\n";
		return result;
	}

	@Override
	protected String getPrompt() {
		return prompt;
	}

	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
}
