package entity.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.answer.Answer;
import entity.answer.MatchingAnswer;

@SuppressWarnings("serial")
public class MatchingQuestion extends Question {
	private String prompt;
	private List<String> choicesLeft;
	private List<String> choicesRight;

	@Override
	public String getPrompt() {
		return prompt;
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
		if (choicesLeft.size() != choicesRight.size()) {
			io().println("Choices number mismatch!");
			init();
		}
	}

	@Override
	public String toString() {
		String result = getPrompt() + "\n";
		result += choices2String();
		return result;
	}

	private String choices2String() {
		String result = "";
		int maxChoiceNum = choicesLeft.size() > choicesRight.size() ? choicesLeft.size() : choicesRight.size();
		for (int i = 0; i < maxChoiceNum; i++) {
			if (i < choicesLeft.size())
				result += (char) ('a' + i) + ") " + choicesLeft.get(i);
			if (i < choicesRight.size())
				result += "\t" + (char) ('A' + i) + ") " + choicesRight.get(i);
			result += "\n";
		}
		return result;
	}

	@Override
	public void modify() {
		io().println("The old prompt was: " + getPrompt());
		if (io().readBoolean("Do you wish to modify the prompt", "yes", "no")) {
			setPrompt(io().readPrompt("multiple choice"));
			io().println("The new prompt is: " + getPrompt());
		}

		io().println("The old choices were: ");
		io().println(choices2String());
		while (io().readBoolean("Do you wish to add/remove choices", "yes", "no")) {

			if (io().readBoolean("Do you wish to add choices", "yes", "no")) {
				choicesLeft.add(io().readString("New left choice"));
				choicesRight.add(io().readString("New right choice"));
			}
			if (io().readBoolean("Do you wish to remove choices", "yes", "no")) {
				io().println("Which left choice do you want to remove");
				int indexLeft = io().readChoice();
				io().println("Which right choice do you want to remove");
				int indexRight = io().readChoice();
				if (((indexLeft >= 0) && (indexLeft < choicesLeft.size()))
						&& ((indexRight >= 0) && (indexRight < choicesRight.size()))) {
					choicesLeft.remove(indexLeft);
					choicesRight.remove(indexRight);
				} else
					io().println("Index error.");
			}

			io().println("The new choices are: ");
			io().println(choices2String());
		}

		while (io().readBoolean("Do you wish to modify choices", "yes", "no")) {
			List<String> choices = io().readBoolean("Which side do you wish to modify choices", "left", "right")
					? choicesLeft : choicesRight;
			io().println("Which choice do you want to modify?");
			int index = io().readChoice();
			if ((index >= 0) && (index < choices.size())) {
				choices.set(index, io().readString("New choice"));
				io().println("The new choices are: ");
				io().println(choices2String());
			} else
				io().println("Index error.");
		}
	}

	@Override
	public Answer makeAnswer() {
		return new MatchingAnswer(this, readMatching(getChoicesLeft(), getChoicesRight()));
	}

	protected Map<String, String> readMatching(List<String> choicesLeft, List<String> choicesRight) {
		io().println("Enter the matching:");
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
