package entity;

@SuppressWarnings("serial")
public class SATestQuestion extends TestQuestion {
	public SATestQuestion() {
		setQuestion(new SAQuestion());
		setAnswer(io().readString("Enter correct answer"));
	}

	@Override
	public String toString() {
		String result = getQuestion().toString();
		result += "The correct choice is " + getAnswer().getValue() + "\n";
		return result;
	}
}