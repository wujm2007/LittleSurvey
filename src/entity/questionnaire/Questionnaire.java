package entity.questionnaire;

import java.io.Serializable;
import java.util.Iterator;

import entity.question.Question;

/*
 * This is a class designed to hold the Questions.
 * 
 * It implements Iterable<Question> so that it could be iterated, and 
 * Serializable so that it can be put into a file.
 * 
 * It has a name so that it could be distinguished from its peers.
 * 
 * It's actually a Collection so it has operations like add, remove, etc.
 */
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

	// get the Question (along with Answer if it's a TestQuestion)
	public abstract Question getQuestion(int number);

	// get the original Question (without Answer)
	public abstract Question getQuestionWithoutAnswer(int number);

	public abstract void removeQuestion(int number);

	public abstract void removeQuestion(Question q);

	public abstract void clear();

	public abstract int size();

	public void addAll(Questionnaire c) {
		for (Question q : c)
			addQuestion(q);
	}

	public abstract boolean isEmpty();

}