package entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class Test extends QuestionContainer {
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

}
