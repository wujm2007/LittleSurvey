package entity.question;

@SuppressWarnings("serial")
public class TFTestQuestion extends TestQuestion {

	public TFTestQuestion() {
		setQuestion(new TFQuestion());
		setAnswer(makeAnswer());
	}

	@Override
	public String toString() {
		String result = "" + getPrompt() + "\n" + "T/F\n";
		result += "The correct answer is " + getAnswer() + "\n";
		return result;
	}

	@Override
	public void modify() {
		getQuestion().modify();
		if (io().readBoolean("Do you wish to modify the answer", "yes", "no")) {
			setAnswer(makeAnswer());
		}
	}
}
