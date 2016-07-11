package entity;

import java.util.Map;

@SuppressWarnings("serial")
public class MCQuestion extends Question {
	protected Map<String, String> choices;

	protected MCQuestion(String prompt, Map<String, String> map) {
		super(prompt);
		this.choices = map;
	}

	@Override
	public String toString() {
		String result = "" + getPrompt() + "\n";
		for (String key : choices.keySet())
			result += key + ") " + choices.get(key) + " ";
		result += "\n";
		return result;
	}
}
