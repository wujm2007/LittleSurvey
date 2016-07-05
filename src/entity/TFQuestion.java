package entity;

public class TFQuestion extends Question {

	public TFQuestion(String prompt) {
		super(prompt);
		// System.out.println(this);
	}

	@Override
	public String toString() {
		String result = "";
		result += this.getPrompt() + "\n";
		result += "T/F\n";
		return result;
	}
}
