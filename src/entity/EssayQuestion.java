package entity;

public class EssayQuestion extends Question {

	protected EssayQuestion(String prompt) {
		super(prompt);
	}

	@Override
	public String toString() {
		String result = this.getPrompt() + "\n";
		return result;
	}

}
