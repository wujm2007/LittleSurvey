package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class MatchingTestQuestion extends TestQuestion {

	public MatchingTestQuestion() {
		setQuestion(new MatchingQuestion());
		setAnswer(readCorrectMatching(getChoicesLeft(), getChoicesRight()));
	}

	@Override
	public String toString() {
		String result = getQuestion().toString();
		result += "The correct choice is\n";
		@SuppressWarnings("unchecked")
		Map<String, String> standardAnswer = (Map<String, String>) getAnswer().getValue();
		for (String key : standardAnswer.keySet())
			result += key + ": " + standardAnswer.get(key) + "\n";
		return result;
	}

	public final List<String> getChoicesLeft() {
		return ((MatchingQuestion) getQuestion()).getChoicesLeft();
	}

	public final List<String> getChoicesRight() {
		return ((MatchingQuestion) getQuestion()).getChoicesRight();
	}

	private Map<String, String> readCorrectMatching(List<String> choicesLeft, List<String> choicesRight) {
		io().println("Enter the correct ranking:");
		Map<String, String> answer = new HashMap<String, String>();
		for (int i = 0; i < choicesLeft.size(); i++) {
			String tmp = io().readString("#" + (i + 1) + ": " + choicesLeft.get(i));
			int index = io().getIndex(tmp);
			if ((index >= 0) && (index < choicesRight.size()))
				answer.put(choicesLeft.get(i), choicesRight.get(index));
			else {
				io().println("Invalid index.");
				i--;
			}
		}
		return answer;
	}
}
