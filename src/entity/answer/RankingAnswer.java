package entity.answer;

import java.util.Map;

import entity.answer.Answer;
import entity.question.Question;

@SuppressWarnings("serial")
public class RankingAnswer extends Answer {
	private Map<Integer, String> map;

	public RankingAnswer(Question question, Map<Integer, String> mapAnswer) {
		super(question);
		this.map = mapAnswer;
	}

	@Override
	public String toString() {
		String result = "";
		for (int key : map.keySet())
			result += (key + 1) + ": " + map.get(key) + "\t";
		return result;
	}

	@Override
	public Object getValue() {
		return map;
	}

}
