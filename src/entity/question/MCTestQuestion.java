package entity.question;

@SuppressWarnings("serial")
public class MCTestQuestion extends TestQuestion {

	public MCTestQuestion() {
		setQuestion(new MCQuestion());
		setAnswer(makeAnswer());
	}

	@Override
	public String toString() {
		String result = getQuestion().toString();
		result += "The correct choice is " + getAnswer().toString() + "\n";
		return result;
	}

	@Override
	public void modify() {
		getQuestion().modify();
		if (io().readBoolean("Do you wish to modify the answer", "yes", "no"))
			setAnswer(makeAnswer());
	}

}
