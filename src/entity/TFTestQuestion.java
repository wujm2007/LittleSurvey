package entity;

@SuppressWarnings("serial")
public class TFTestQuestion extends TestQuestion {
	protected TFTestQuestion() {
		setQuestion(new TFQuestion());
		setAnswer(readBoolean());
	}

	@Override
	public String toString() {
		String result = "" + getPrompt() + "\n" + "T/F\n";
		result += "The correct answer is " + ((boolean) getAnswer().getValue() ? "T" : "F") + "\n";
		return result;
	}

	public boolean readBoolean() {
		String input = io().readString("Enter correct choice");
		if (input.toUpperCase().equals("T"))
			return true;
		else if (input.toUpperCase().equals("F"))
			return false;
		else {
			System.out.println("Boolean Format Error!");
			return readBoolean();
		}
	}
}
