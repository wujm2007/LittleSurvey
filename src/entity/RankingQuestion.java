package entity;

import java.util.Map;

@SuppressWarnings("serial")
public class RankingQuestion extends Question {
	protected Map<String, String> choices;

	public RankingQuestion(String prompt, Map<String, String> map) {
		super(prompt);
		this.choices = map;
	}

	@Override
	public String toString() {
		String result = "";
		result += this.getPrompt() + "\n";
		for (String key : choices.keySet()) {
			result += key + ") " + choices.get(key) + " ";
		}
		result += "\n";
		return result;
	}
}
