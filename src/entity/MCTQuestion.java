package entity;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MCTQuestion extends MCQuestion implements IGradable {
	// key: index, value: truth
	private Map<Integer, Boolean> standardAnswer;

	public MCTQuestion(String prompt, List<String> choices, List<Integer> standardAnswer) {
		super(prompt, choices);
		this.standardAnswer = new TreeMap<Integer, Boolean>();
		for (int i = 0; i < standardAnswer.size(); i++)
			this.standardAnswer.put(standardAnswer.get(i), true);
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
			if (standardAnswer.get(key))
				result += (char) ('A' + key) + ") ";
		}
		result += "\n";
		return result;
	}

}
