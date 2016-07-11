package entity;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class MCTestQuestion extends TestQuestion {

	public MCTestQuestion(String prompt, Map<String, String> choices, List<String> standardAnswer) {
		super(prompt);
		setQuestion(new MCQuestion(prompt, choices));
		Map<String, Boolean> mapAnswer = new TreeMap<String, Boolean>();
		for (int i = 0; i < standardAnswer.size(); i++)
			mapAnswer.put(standardAnswer.get(i), true);
		setAnswer(mapAnswer);
	}

	@Override
	public String toString() {
		String result = getQuestion().toString();
		result += "The correct choice is ";
		@SuppressWarnings("unchecked")
		Map<String, Boolean> standardAnswer = (Map<String, Boolean>) getAnswer().getValue();
		for (String key : standardAnswer.keySet())
			if (standardAnswer.get(key))
				result += key + ")\t";
		result += "\n";
		return result;
	}
}
