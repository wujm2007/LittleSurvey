package entity.question;

@SuppressWarnings("serial")
public class MatchingTestQuestion extends TestQuestion {

	public MatchingTestQuestion() {
		setQuestion(new MatchingQuestion());
		setAnswer(makeAnswer());
	}

	@Override
	public String toString() {
		String result = getQuestion().toString();
		result += this.getAnswer();
		return result;
	}

	@Override
	public void modify() {
		getQuestion().modify();
		if (io().readBoolean("Do you wish to modify the answer", "yes", "no"))
			setAnswer(makeAnswer());
	}
}
