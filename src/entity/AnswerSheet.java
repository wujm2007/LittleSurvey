package entity;

import java.util.Map;

import entity.answer.Answer;
import entity.question.Question;

import java.util.HashMap;

public class AnswerSheet {
	Map<Question, Answer> answerSheet = new HashMap<Question, Answer>();

	public Answer getAnswer(Question question) {
		return answerSheet.get(question);
	}

	public void addAnswer(Answer answer) {
		answerSheet.put(answer.getQuestion(), answer);
	}
}
