package entity;

@SuppressWarnings("serial")
public class EssayQuestion extends Question {

	protected EssayQuestion(String prompt) {
		super(prompt);
	}

	@Override
	public String toString() {
		String result = getPrompt() + "\n";
		return result;
	}

}
