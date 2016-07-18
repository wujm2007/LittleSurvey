package util.visitor;

import java.util.List;

import entity.question.EssayQuestion;
import entity.question.MCQuestion;
import entity.question.MCTestQuestion;
import entity.question.MatchingQuestion;
import entity.question.MatchingTestQuestion;
import entity.question.Question;
import entity.question.RankingQuestion;
import entity.question.RankingTestQuestion;
import entity.question.SAQuestion;
import entity.question.SATestQuestion;
import entity.question.TFQuestion;
import entity.question.TFTestQuestion;
import entity.question.TestQuestion;
import util.IOHelper;

public class ModifyVisitor extends QuestionVisitor {
	IOHelper io = IOHelper.getInstance();

	private void modifyPrompt(Question q, String type) {
		io.println("The old prompt was: " + q.getPrompt());
		if (io.readBoolean("Do you wish to modify the prompt", "yes", "no")) {
			q.setPrompt(io.readPrompt(type));
			io.println("The new prompt is: " + q.getPrompt());
		}
	}

	private void modifyTestQuestion(TestQuestion q) {
		q.getQuestion().modify();
		if (io.readBoolean("Do you wish to modify the answer", "yes", "no"))
			q.setAnswer(q.makeAnswer());
	}

	private String choicesToString(List<String> choices) {
		String result = "";
		for (int i = 0; i < choices.size(); i++)
			result += (char) ('A' + i) + ") " + choices.get(i) + " ";
		return result;
	}

	private String choicesToString(List<String> choicesLeft, List<String> choicesRight) {
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

	private void modifyChoices(List<String> choices) {
		io.println("The old choices were: ");
		io.println(choicesToString(choices));
		while (io.readBoolean("Do you wish to add/remove choices", "yes", "no")) {
			if (io.readBoolean("Do you wish to add choices", "yes", "no"))
				choices.add(io.readString("New choice"));
			if ((choices.size() >= 2) && (io.readBoolean("Do you wish to remove choices", "yes", "no"))) {
				io.println("Which choice do you want to remove");
				int index = io.readChoice();
				if ((index >= 0) && (index < choices.size()))
					choices.remove(index);
				else
					io.println("Index error.");
			}
			io.println("The new choices are: ");
			io.println(choicesToString(choices));
		}

		while (io.readBoolean("Do you wish to modify choices", "yes", "no")) {
			io.println("The old choices were: ");
			io.println(choicesToString(choices));
			io.println("Which choice do you want to modify?");
			int index = io.readChoice();
			if ((index >= 0) && (index < choices.size())) {
				choices.set(index, io.readString("New choice"));
				io.println("The new choices are: ");
				io.println(choicesToString(choices));
			} else
				io.println("Index error.");
		}
	}

	private void modifyChoices(List<String> choicesLeft, List<String> choicesRight) {
		io.println("The old choices were: ");
		io.println(choicesToString(choicesLeft, choicesRight));
		while (io.readBoolean("Do you wish to add/remove choices", "yes", "no")) {

			if (io.readBoolean("Do you wish to add choices", "yes", "no")) {
				choicesLeft.add(io.readString("New left choice"));
				choicesRight.add(io.readString("New right choice"));
			}
			if ((choicesLeft.size() >= 2) && (io.readBoolean("Do you wish to remove choices", "yes", "no"))) {
				io.println("Which left choice do you want to remove");
				int indexLeft = io.readChoice();
				io.println("Which right choice do you want to remove");
				int indexRight = io.readChoice();
				if (((indexLeft >= 0) && (indexLeft < choicesLeft.size()))
						&& ((indexRight >= 0) && (indexRight < choicesRight.size()))) {
					choicesLeft.remove(indexLeft);
					choicesRight.remove(indexRight);
				} else
					io.println("Index error.");
			}

			io.println("The new choices are: ");
			io.println(choicesToString(choicesLeft, choicesRight));
		}

		while (io.readBoolean("Do you wish to modify choices", "yes", "no")) {
			List<String> choices = io.readBoolean("Which side do you wish to modify choices", "left", "right")
					? choicesLeft : choicesRight;
			io.println("Which choice do you want to modify?");
			int index = io.readChoice();
			if ((index >= 0) && (index < choices.size())) {
				choices.set(index, io.readString("New choice"));
				io.println("The new choices are: ");
				io.println(choicesToString(choicesLeft, choicesRight));
			} else
				io.println("Index error.");
		}
	}

	@Override
	public void visitTF(TFQuestion q) {
		modifyPrompt(q, "True/False");
	}

	@Override
	public void visitTFTest(TFTestQuestion q) {
		modifyTestQuestion(q);
	}

	@Override
	public void visitMC(MCQuestion q) {
		modifyPrompt(q, "multiple choice");
		modifyChoices(q.getChoices());
	}

	@Override
	public void visitMCTest(MCTestQuestion q) {
		modifyTestQuestion(q);
	}

	@Override
	public void visitSA(SAQuestion q) {
		modifyPrompt(q, "short answer");
	}

	@Override
	public void visitSATest(SATestQuestion q) {
		modifyTestQuestion(q);
	}

	@Override
	public void visitEssay(EssayQuestion q) {
		modifyPrompt(q, "essay");
	}

	@Override
	public void visitRanking(RankingQuestion q) {
		modifyPrompt(q, "ranking question");
		modifyChoices(q.getChoices());
	}

	@Override
	public void visitRankingTest(RankingTestQuestion q) {
		modifyTestQuestion(q);
	}

	@Override
	public void visitMatching(MatchingQuestion q) {
		modifyPrompt(q, "matching question");
		modifyChoices(q.getChoicesLeft(), q.getChoicesRight());
	}

	@Override
	public void visitMatchingTest(MatchingTestQuestion q) {
		modifyTestQuestion(q);
	}

}
