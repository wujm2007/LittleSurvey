package entity.questionnaire;

import java.io.Serializable;
import java.util.Iterator;

import entity.question.Question;

@SuppressWarnings("serial")
public abstract class Questionnaire implements Iterable<Question>, Serializable {
	private final String name;

	public Questionnaire(String name) {
		this.name = name;
	}

	public final String getName() {
		return name;
	}

	@Override
	public abstract Iterator<Question> iterator();

	public abstract void addQuestion(final Question q);

	public abstract Question getQuestion(int number);

	public abstract Question getQuestionWithouAnswer(int number);

	public abstract void clear();

	public abstract int size();

	public void addAll(Questionnaire c) {
		for (Question q : c)
			addQuestion(q);
	}

	public abstract boolean isEmpty();

}