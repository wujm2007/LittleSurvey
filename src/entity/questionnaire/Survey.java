package entity.questionnaire;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import entity.question.Question;

/*
 * See Questionnaire.java
 */
@SuppressWarnings("serial")
public class Survey extends Questionnaire {
	public Survey(String name) {
		super(name);
	}

	private List<Question> questions = new LinkedList<Question>();

	@Override
	public final void addQuestion(final Question q) {
		this.questions.add(q);
	}

	@Override
	public final Question getQuestion(int number) {
		return questions.get(number);
	}

	@Override
	public Iterator<Question> iterator() {
		return questions.iterator();
	}

	@Override
	public void clear() {
		questions.clear();
	}

	@Override
	public int size() {
		return questions.size();
	}

	@Override
	public boolean isEmpty() {
		return questions.isEmpty();
	}

	@Override
	public Question getQuestionWithoutAnswer(int number) {
		return getQuestion(number);
	}

	@Override
	public void removeQuestion(int number) {
		questions.remove(number);
	}

	@Override
	public void removeQuestion(Question q) {
		questions.remove(q);
	}

}
