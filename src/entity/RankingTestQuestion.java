package entity;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class RankingTestQuestion extends TestQuestion {
	public RankingTestQuestion(String prompt, Map<String, String> choices, List<String> standardAnswer) {
		super(prompt);
		setQuestion(new RankingQuestion(prompt, choices));
		Map<Integer, String> mapAnswer = new TreeMap<Integer, String>();
		for (int i = 0; i < standardAnswer.size(); i++)
			mapAnswer.put(i, standardAnswer.get(i));
		this.setAnswer(mapAnswer);
	}

	@Override
	public String toString() {
		String result = getQuestion().toString();
		result += "The correct ranking is ";
		@SuppressWarnings("unchecked")
		Map<Integer, String> standardAnswer = (Map<Integer, String>) getAnswer().getValue();
		for (int key : standardAnswer.keySet()) {
			result += "(" + (key + 1) + ") " + standardAnswer.get(key) + "\t";
		}
		result += "\n";
		return result;
	}
}