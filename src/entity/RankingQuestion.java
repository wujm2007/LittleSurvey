package entity;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RankingQuestion extends Question {
	protected Map<Integer, String> choices;

	public RankingQuestion(String prompt, List<String> choices) {
		super(prompt);
		this.choices = new TreeMap<Integer, String>();
		for (int i = 0; i < choices.size(); i++)
			this.choices.put(i, choices.get(i));
	}

	@Override
	public String toString() {
		String result = "";
		result += this.getPrompt() + "\n";
		for (int key : choices.keySet()) {
			result += (char) ('A' + key) + ") " + choices.get(key) + " ";
		}
		result += "\n";
		return result;
	}
}
