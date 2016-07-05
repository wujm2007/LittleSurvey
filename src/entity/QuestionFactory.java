package entity;

public abstract class QuestionFactory {

	public abstract TFQuestion createTF();

	public abstract MCQuestion createMC();

	public abstract SAQuestion createSA();

	public abstract EssayQuestion createEssay();

	public abstract RankingQuestion createRanking();

}
