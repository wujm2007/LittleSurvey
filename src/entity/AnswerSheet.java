package entity;

import entity.answer.Answer;
import entity.question.Question;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * This is a class designed to hold the answers to a Questionnaire.
 * 
 * It implements Iterable<Answer> so that it could be iterated, and 
 * Serializable so that it can be put into a file.
 * 
 * It's implemented by a LinkedList.
 */

@SuppressWarnings("serial")
public class AnswerSheet implements Iterable<Answer>, Serializable {
	private List<Answer> answerSheet = new LinkedList<Answer>();

	public void addAnswer(Answer answer) {
		answerSheet.add(answer);
	}

	@Override
	public Iterator<Answer> iterator() {
		return answerSheet.iterator();
	}

	// return the Answer to some Question
	public Answer getAnswer(Question q) {
		for (Answer a : this) {
			if (a.getQuestion() == q)
				return a;
		}
		return null;
	}
}
