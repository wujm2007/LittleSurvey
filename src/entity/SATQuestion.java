package entity;

public class SATQuestion extends SAQuestion implements IGradable {
	private String standardAnswer;

	public SATQuestion(String prompt, String standardAnswer) {
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
		result += "The correct choice is " + standardAnswer + "\n";
		return result;
	}
}
