package entity.factory;

import entity.question.Question;

public abstract class QuestionFactory {

	public abstract Question createTF();

	public abstract Question createMC();

	public abstract Question createSA();

	public abstract Question createEssay();

	public abstract Question createRanking();

	public abstract Question createMatching();

}
