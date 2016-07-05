package entity;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RankingTQuestion extends RankingQuestion implements IGradable {
	// key: index, value: order
	private Map<Integer, Integer> standardAnswer;

	public RankingTQuestion(String prompt, List<String> choices, List<Integer> standardAnswer) {
		super(prompt, choices);
		this.standardAnswer = new TreeMap<Integer, Integer>();
		for (int i = 0; i < standardAnswer.size(); i++)
			this.standardAnswer.put(standardAnswer.get(i), i);
	}

	@Override
	public int getGrade() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		String result = super.toString();
		result += "The correct choice is ";
		for (int key : standardAnswer.keySet()) {
			result += standardAnswer.get(key) + "(" + (char) ('A' + key) + ") ";
		}
		result += "\n";
		return result;
	}
}
