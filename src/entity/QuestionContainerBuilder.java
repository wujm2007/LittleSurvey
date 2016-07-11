package entity;

public abstract class QuestionContainerBuilder {
	public abstract void buildTF();

	public abstract void buildMC();

	public abstract void buildSA();

	public abstract void buildEssay();

	public abstract void buildRanking();

	public abstract QuestionContainer getResult();
}
