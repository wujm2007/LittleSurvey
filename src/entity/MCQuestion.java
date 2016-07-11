package entity;

import java.util.List;

@SuppressWarnings("serial")
public class MCQuestion extends Question {
	private String prompt;
	protected List<String> choices;

	@Override
	protected String getPrompt() {
		return prompt;
	}

	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public final List<String> getChoices() {
		return choices;
	}

	public MCQuestion() {
		init();
	}

	private void init() {
		setPrompt(io().readPrompt("multiple choice"));
		choices = io().readChoices("multiple choice");
	}

	@Override
	public String toString() {
		String result = "" + getPrompt() + "\n";
		for (int i = 0; i < choices.size(); i++)
			result += (char) ('A' + i) + ") " + choices.get(i) + " ";
		result += "\n";
		return result;
	}
}
