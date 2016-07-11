package entity;

import java.util.List;

@SuppressWarnings("serial")
public class MatchingQuestion extends Question {
	private String prompt;
	private List<String> choicesLeft;
	private List<String> choicesRight;

	@Override
	protected String getPrompt() {
		return this.prompt;
	}

	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public final List<String> getChoicesLeft() {
		return choicesLeft;
	}

	public final List<String> getChoicesRight() {
		return choicesRight;
	}

	public MatchingQuestion() {
		init();
	}

	private void init() {
		setPrompt(io().readPrompt("matching"));
		choicesLeft = io().readChoices("matching(left)");
		choicesRight = io().readChoices("matching(right)");
	}

	@Override
	public String toString() {
		String result = getPrompt() + "\n";
		int maxChoiceNum = choicesLeft.size() > choicesRight.size() ? choicesLeft.size() : choicesRight.size();
		for (int i = 0; i < maxChoiceNum; i++) {
			if (i < choicesLeft.size())
				result += choicesLeft.get(i);
			if (i < choicesRight.size())
				result += "\t" + choicesRight.get(i);
			result += "\n";
		}
		return result;
	}

}
