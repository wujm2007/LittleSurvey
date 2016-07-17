package entity.question;

import entity.answer.Answer;
import entity.answer.TFAnswer;

@SuppressWarnings("serial")
public class TFQuestion extends Question {
	private String prompt;

	@Override
	public String getPrompt() {
		return prompt;
	}

	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public TFQuestion() {
		setPrompt(io().readPrompt("True/False"));
	}

	@Override
	public String toString() {
		return "" + getPrompt() + "\n" + "T/F\n";
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
		return new TFAnswer(this, io().readBoolean("Enter correct choice", "true", "false"));
	}
}
