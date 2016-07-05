package entity;

public class EssayTQuestion extends EssayQuestion {

	public EssayTQuestion(String prompt) {
		super(prompt);
	}

	@Override
	public String toString() {
		String result = this.getPrompt() + "\n";
		return result;
	}
}
