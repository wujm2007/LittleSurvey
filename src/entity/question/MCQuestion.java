package entity.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import entity.answer.Answer;
import entity.answer.MCAnswer;

@SuppressWarnings("serial")
public class MCQuestion extends Question {
	private String prompt;
	protected List<String> choices;

	@Override
	public String getPrompt() {
		return prompt;
	}

	@Override
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public MCQuestion() {
		setPrompt(io().readPrompt("multiple choice"));
		choices = io().readChoices("multiple choice");
	}

	@Override
	public String toString() {
		String result = "" + getPrompt() + "\n";
		result += choices2String() + "\n";
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

			if (io().readBoolean("Do you wish to add choices", "yes", "no"))
				choices.add(io().readString("New choice"));
			if (io().readBoolean("Do you wish to remove choices", "yes", "no")) {
				io().println("Which choice do you want to remove");
				int index = io().readChoice();
				if ((index >= 0) && (index < choices.size()))
					choices.remove(index);
				else
					io().println("Index error.");
			}

			io().println("The new choices are: ");
			io().println(choices2String());

		}
		while (io().readBoolean("Do you wish to modify choices", "yes", "no")) {
			io().println("The old choices were: ");
			io().println(choices2String());
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

	private String choices2String() {
		String result = "";
		for (int i = 0; i < choices.size(); i++)
			result += (char) ('A' + i) + ") " + choices.get(i) + " ";
		return result;
	}

	@Override
	public Answer makeAnswer() {
		List<String> standardAnswer = readChoices(choices);
		Map<String, Boolean> mapAnswer = new TreeMap<String, Boolean>();
		for (int i = 0; i < standardAnswer.size(); i++)
			mapAnswer.put(standardAnswer.get(i), true);
		return new MCAnswer(this, mapAnswer);
	}

	private List<String> readChoices(List<String> choices) {
		int n = io().readInt("Enter the number of choices");
		if ((n > choices.size()) || (n < 1)) {
			io().println("Invalid number.");
			return readChoices(choices);
		}
		List<String> answer = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String tmp = io().readString("answer #" + (i + 1)).toUpperCase();
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
