package entity.question;

import entity.answer.Answer;
import entity.answer.EssayAnswer;

@SuppressWarnings("serial")
public class EssayQuestion extends Question {
	private String prompt;

	public EssayQuestion() {
		setPrompt(io().readPrompt("essay"));
	}

	@Override
	public String toString() {
		String result = getPrompt() + "\n";
		return result;
	}

	@Override
	public String getPrompt() {
		return prompt;
	}

	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	@Override
	public void modify() {
		setPrompt(io().readPrompt("essay"));
	}

	@Override
	public Answer makeAnswer() {
		return new EssayAnswer(this, io().readString("Essay answer"));
	}
}
