package entity;

public class SAQuestion extends Question {

	public SAQuestion(String prompt) {
		super(prompt);
	}

	@Override
	public String toString() {
		String result = this.getPrompt() + "\n";
		return result;
	}
}
