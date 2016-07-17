package entity.question;

import entity.answer.Answer;
import entity.answer.SAAnswer;

@SuppressWarnings("serial")
public class SAQuestion extends Question {
	private String prompt;

	@Override
	public String getPrompt() {
		return prompt;
	}

	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public SAQuestion() {
		setPrompt(io().readPrompt("short answer"));
	}

	@Override
	public String toString() {
		String result = this.getPrompt() + "\n";
		return result;
	}

	@Override
	public void modify() {
		io().println("The old prompt was: " + getPrompt());
		if (io().readBoolean("Do you wish to modify the prompt", "yes", "no")) {
			setPrompt(io().readPrompt("multiple choice"));
			io().println("The new prompt is: " + getPrompt());
		}
	}

	@Override
	public Answer makeAnswer() {
		return new SAAnswer(this, io().readString("Enter answer"));
	}
}
