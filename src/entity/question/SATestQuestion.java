package entity.question;

@SuppressWarnings("serial")
public class SATestQuestion extends TestQuestion {
	public SATestQuestion() {
		setQuestion(new SAQuestion());
		setAnswer(makeAnswer());
	}

	@Override
	public String toString() {
		String result = getQuestion().toString();
		result += "The correct choice is " + getAnswer() + "\n";
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