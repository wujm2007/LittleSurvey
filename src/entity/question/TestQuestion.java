package entity.question;

import entity.answer.Answer;

@SuppressWarnings("serial")
public abstract class TestQuestion extends Question implements Gradable {
	private Question question;
	private Answer answer;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question questionWithoutAnswer) {
		this.question = questionWithoutAnswer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Answer getAnswer() {
		return answer;
	}

	@Override
	public String getPrompt() {
		return getQuestion().getPrompt();
	}

	@Override
	public void setPrompt(String prompt) {
		this.getQuestion().getPrompt();
	}

	@Override
	public boolean isCorrect(Answer answer) {
		return getAnswer().match(answer);
	}

	public Answer makeAnswer() {
		return getQuestion().makeAnswer();
	}
}