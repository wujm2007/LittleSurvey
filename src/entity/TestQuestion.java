package entity;

@SuppressWarnings("serial")
public abstract class TestQuestion extends Question implements Gradable {
	private Question question;
	private Answer answer;

	public TestQuestion(String prompt) {
		super(prompt);
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question questionWithoutAnswer) {
		this.question = questionWithoutAnswer;
	}

	public void setAnswer(Object answer) {
		this.answer = new Answer(this, answer);
	}

	public Answer getAnswer() {
		return this.answer;
	}

	@Override
	public boolean isCorrect(Answer answer) {
		return this.answer.match(answer);
	}
}