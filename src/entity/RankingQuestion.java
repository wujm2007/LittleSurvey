package entity;

import java.util.List;

@SuppressWarnings("serial")
public class RankingQuestion extends Question {
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

	public RankingQuestion() {
		setPrompt(io().readPrompt("ranking"));
		choices = io().readChoices("ranking");
	}

	@Override
	public String toString() {
		String result = "";
		result += this.getPrompt() + "\n";
		for (int i = 0; i < choices.size(); i++)
			result += (char) ('A' + i) + ") " + choices.get(i) + " ";
		result += "\n";
		return result;
	}
}
