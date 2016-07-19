package util.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import entity.answer.EssayAnswer;
import entity.answer.MCAnswer;
import entity.answer.MatchingAnswer;
import entity.answer.RankingAnswer;
import entity.answer.SAAnswer;
import entity.answer.TFAnswer;
import entity.question.MCQuestion;
import entity.question.MatchingQuestion;
import entity.question.Question;
import entity.question.RankingQuestion;
import util.AbstractIOHelper;
import util.CmdLineIOHelper;

public class InitAnswerVisitor extends AnswerVisitor {
	AbstractIOHelper io = CmdLineIOHelper.getInstance();

	@Override
	public void visitTF(TFAnswer a) {
		a.setTruth(io.readBoolean("Enter choice", "true", "false"));
	}

	@Override
	public void visitMC(MCAnswer a) {
		MCQuestion question = (MCQuestion) a.getQuestion();
		List<String> standardAnswer = readChoices(question.getChoices());
		Map<String, Boolean> mapAnswer = new TreeMap<String, Boolean>();
		for (int i = 0; i < standardAnswer.size(); i++)
			mapAnswer.put(standardAnswer.get(i), true);
		a.setChoices(mapAnswer);
	}

	@Override
	public void visitSA(SAAnswer a) {
		a.setContent(io.readString("Enter short answer"));
	}

	@Override
	public void visitEssay(EssayAnswer a) {
		a.setContent(io.readString("Enter essay answer"));
	}

	@Override
	public void visitRanking(RankingAnswer a) {
		RankingQuestion question = (RankingQuestion) a.getQuestion();
		List<String> standardAnswer = readRanking(question.getChoices());
		Map<Integer, String> mapAnswer = new TreeMap<Integer, String>();
		for (int i = 0; i < standardAnswer.size(); i++)
			mapAnswer.put(i, standardAnswer.get(i));
		a.setMap(mapAnswer);
	}

	@Override
	public void visitMatching(MatchingAnswer a) {
		Question question = a.getQuestion();
		a.setMatch(readMatching(((MatchingQuestion) question).getChoicesLeft(),
				((MatchingQuestion) question).getChoicesRight()));
	}

	private Map<String, String> readMatching(List<String> choicesLeft, List<String> choicesRight) {
		io.println("Enter the matching:");
		Map<String, String> answer = new HashMap<String, String>();
		for (int i = 0; i < choicesLeft.size(); i++) {
			String tmp = io.readString("#" + (i + 1) + ": " + choicesLeft.get(i));
			int index = io.getIndex(tmp);
			if ((index >= 0) && (index < choicesRight.size()))
				answer.put(choicesLeft.get(i), choicesRight.get(index));
			else {
				io.println("Invalid index.");
				i--;
			}
		}
		return answer;
	}

	private List<String> readChoices(List<String> choices) {
		int n = io.readInt("Enter the number of choices");
		if ((n > choices.size()) || (n < 1)) {
			io.println("Invalid number.");
			return readChoices(choices);
		}
		List<String> answer = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String tmp = io.readString("answer #" + (i + 1)).toUpperCase();
			int index = io.getIndex(tmp);
			if ((index >= 0) && (index < choices.size()) && (!answer.contains(tmp)))
				answer.add(tmp);
			else {
				io.println("Invalid index.");
				i--;
			}
		}
		return answer;
	}

	private List<String> readRanking(List<String> choices) {
		io.println("Enter the ranking:");
		List<String> answer = new ArrayList<String>();
		for (int i = 0; i < choices.size(); i++) {
			String tmp = io.readString("#" + (i + 1));
			int index = io.getIndex(tmp);
			if ((index >= 0) && (index < choices.size()) && (!answer.contains(tmp)))
				answer.add(tmp);
			else {
				io.println("Invalid index.");
				i--;
			}
		}
		return answer;
	}

}
