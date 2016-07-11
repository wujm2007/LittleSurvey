package entity;

@SuppressWarnings("serial")
public class TFTestQuestion extends TestQuestion {
	protected TFTestQuestion(String prompt, boolean standardAnswer) {
		super(prompt);
		setQuestion(new TFQuestion(prompt));
		setAnswer(standardAnswer);
	}

	@Override
	public String toString() {
		String result = "" + getPrompt() + "\n" + "T/F\n";
		result += "The correct answer is " + ((boolean) getAnswer().getValue() ? "T" : "F") + "\n";
		return result;
	}
}
