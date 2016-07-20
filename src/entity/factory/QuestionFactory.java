package entity.factory;

import entity.question.Question;

/*
 * This is the QuestionFactory interface (an abstract class to be exact).
 */
public abstract class QuestionFactory {

	public abstract Question createTF();

	public abstract Question createMC();

	public abstract Question createSA();

	public abstract Question createEssay();

	public abstract Question createRanking();

	public abstract Question createMatching();

}
