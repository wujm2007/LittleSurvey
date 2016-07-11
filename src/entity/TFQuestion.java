package entity;

@SuppressWarnings("serial")
public class TFQuestion extends Question {

	public TFQuestion(String prompt) {
		super(prompt);
	}

	@Override
	public String toString() {
		return "" + getPrompt() + "\n" + "T/F\n";
	}
}
