package entity;

@SuppressWarnings("serial")
public class SATestQuestion extends TestQuestion {
	public SATestQuestion(String prompt, String standardAnswer) {
		super(prompt);
		setQuestion(new SAQuestion(prompt));
		setAnswer(standardAnswer);
	}

	@Override
	public String toString() {
		String result = getQuestion().toString();
		result += "The correct choice is " + getAnswer().getValue() + "\n";
		return result;
	}
}