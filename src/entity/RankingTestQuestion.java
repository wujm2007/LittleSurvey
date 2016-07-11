package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class RankingTestQuestion extends TestQuestion {

	private final List<String> getChoices() {
		return ((RankingQuestion) getQuestion()).getChoices();
	}

	public RankingTestQuestion() {
		setQuestion(new RankingQuestion());
		List<String> standardAnswer = readCorrectRanking(getChoices());
		Map<Integer, String> mapAnswer = new TreeMap<Integer, String>();
		for (int i = 0; i < standardAnswer.size(); i++)
			mapAnswer.put(i, standardAnswer.get(i));
		setAnswer(mapAnswer);
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

	public List<String> readCorrectRanking(List<String> choices) {
		io().println("Enter the correct ranking:");
		List<String> answer = new ArrayList<String>();
		for (int i = 0; i < choices.size(); i++) {
			String tmp = io().readString("#" + (i + 1));
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