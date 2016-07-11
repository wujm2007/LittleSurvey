package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class MCTestQuestion extends TestQuestion {

	public final List<String> getChoices() {
		return ((MCQuestion) this.getQuestion()).getChoices();
	}

	public MCTestQuestion() {
		setQuestion(new MCQuestion());
		List<String> standardAnswer = readCorrectChoices(getChoices());
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

	private List<String> readCorrectChoices(List<String> choices) {
		int n = io().readInt("Enter the number of correct choices for your multiple choice question");
		if ((n > choices.size()) || (n < 1)) {
			io().println("Invalid number.");
			return readCorrectChoices(choices);
		}
		List<String> answer = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String tmp = io().readString("correct answer #" + (i + 1)).toUpperCase();
			int index = io().getIndex(tmp);
			if ((index >= 0) && (index < choices.size()) && (!answer.contains(tmp)))
				answer.add(tmp);
			else {
				io().println("Invalid index.");
				i--;
			}
		}
		return answer;
	}

}
