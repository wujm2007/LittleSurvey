package entity;

public class TFTQuestion extends TFQuestion implements IGradable {
	private boolean standardAnswer;

	public TFTQuestion(String prompt, boolean standardAnswer) {
		super(prompt);
		this.standardAnswer = standardAnswer;
	}

	@Override
	public int getGrade() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		String result = super.toString();
		result += "The correct answer is " + (standardAnswer ? "T" : "F") + "\n";
		return result;
	}
}
