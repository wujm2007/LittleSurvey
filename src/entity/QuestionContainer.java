package entity;

import java.io.Serializable;
import java.util.Iterator;

@SuppressWarnings("serial")
public abstract class QuestionContainer implements Iterable<Question>, Serializable {

	@Override
	public abstract Iterator<Question> iterator();

	public abstract void addQuestion(final Question q);

	public abstract Question getQuestion(int number);

	public abstract void clear();

	public abstract int size();

	public void addAll(QuestionContainer c) {
		for (Question q : c)
			addQuestion(q);
	}

	public abstract boolean isEmpty();

}