package entity;

import entity.answer.Answer;
import entity.question.Question;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

	public Answer getAnswer(Question q) {
		for (Answer a : this) {
			if (a.getQuestion() == q)
				return a;
		}
		return null;
	}
}
