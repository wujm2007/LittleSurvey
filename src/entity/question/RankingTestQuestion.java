package entity.question;

@SuppressWarnings("serial")
public class RankingTestQuestion extends TestQuestion {

	public RankingTestQuestion() {
		setQuestion(new RankingQuestion());
		setAnswer(makeAnswer());
	}

	@Override
	public String toString() {
		String result = getQuestion().toString();
		result += "The correct ranking is " + getAnswer() + "\n";
		return result;
	}

	@Override
	public void modify() {
		getQuestion().modify();
		if (io().readBoolean("Do you wish to modify the answer", "yes", "no"))
			setAnswer(makeAnswer());
	}
}