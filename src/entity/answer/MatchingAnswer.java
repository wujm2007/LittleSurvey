package entity.answer;

import java.util.Map;

import entity.question.Question;

@SuppressWarnings("serial")
public class MatchingAnswer extends Answer {
	private Map<String, String> match;

	public MatchingAnswer(Question question, Map<String, String> match) {
		super(question);
		this.match = match;
	}

	@Override
	public boolean match(Answer answer) {
		if ((answer == null) || (getQuestion() != answer.getQuestion()))
			return false;
		else if (answer instanceof MatchingAnswer)
			return match.equals(((MatchingAnswer) answer).match);
		else
			return false;
	}

	@Override
	public String toString() {
		String result = "";
		for (String key : match.keySet())
			result += key + ": " + match.get(key) + "\n";
		return result;
	}

}
