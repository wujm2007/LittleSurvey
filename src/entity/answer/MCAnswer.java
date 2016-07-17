package entity.answer;

import java.util.Map;

import entity.question.Question;

@SuppressWarnings("serial")
public class MCAnswer extends Answer {
	Map<String, Boolean> choices;

	public MCAnswer(Question question, Map<String, Boolean> choices) {
		super(question);
		this.choices = choices;
	}

	@Override
	public boolean match(Answer answer) {
		if ((answer == null) || (getQuestion() != answer.getQuestion()))
			return false;
		else if (answer instanceof MatchingAnswer)
			return choices.equals(((MCAnswer) answer).choices);
		else
			return false;
	}

	@Override
	public String toString() {
		String result = "";
		for (String key : choices.keySet())
			if (choices.get(key))
				result += key + ")\t";
		return result;
	}
}
