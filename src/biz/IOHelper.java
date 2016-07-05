package biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOHelper {
	private static IOHelper instance;
	private Scanner scanner;

	private IOHelper() {
	};

	public static IOHelper getInstance() {
		if (instance == null) {
			return (instance = new IOHelper());
		}
		return instance;
	}

	public int readInt(String msg) {
		System.out.println(msg + ": ");
		System.out.print("> ");
		scanner = new Scanner(System.in);
		String strinput = scanner.next();
		int input;
		try {
			input = Integer.parseInt(strinput);
		} catch (NumberFormatException e) {
			println("Number Format Error!");
			return readInt(msg);
		}
		return input;
	}

	public String readPrompt(String type) {
		System.out.println("Enter the prompt for you " + type + " question:");
		System.out.print("> ");
		scanner = new Scanner(System.in);
		return scanner.next();
	}

	public void println(String msg) {
		System.out.println(msg);
	}

	public List<String> readMultipleChoices() {
		int n = readInt("Enter the number of choices for your multiple choice question");
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < n; i++)
			l.add(readString("(" + (char)('A' + i) + ")"));
		return l;
	}

	public List<Integer> readCorrectChoices(List<String> choices) {
		int n = readInt("Enter the number of correct choices for your multiple choice question");
		if (n > choices.size()) {
			println("Number Error!");
			return readCorrectChoices(choices);
		}
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int tmp = readInt("correct answer #" + (i + 1));
			if ((tmp <= choices.size()) && (!l.contains(tmp)))
				l.add(tmp);
			else
				i--;
		}
		return l;
	}

	public List<String> readRankingchoices() {
		int n = readInt("Enter the number of choices for your ranking question.");
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < n; i++)
			l.add(readString("(" + (char)('A' + i) + ")"));
		return l;
	}

	public List<Integer> readCorrectRanking(List<String> choices) {
		System.out.println("Enter the correct ranking:");
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < choices.size(); i++) {
			l.add(this.readInt("#" + (i + 1)));
		}
		return l;
	}

	public boolean readBoolean(String msg) {
		scanner = new Scanner(System.in);
		System.out.println(msg + " :");
		System.out.print("> ");
		String input = scanner.next();
		if (input.toUpperCase().equals("T"))
			return true;
		else if (input.toUpperCase().equals("F"))
			return false;
		else {
			System.out.println("Boolean Format Error!");
			return readBoolean(msg);
		}
	}

	public String readString(String msg) {
		scanner = new Scanner(System.in);
		System.out.println(msg + " :");
		System.out.print("> ");
		return read();
	}

	private String read() {
		scanner = new Scanner(System.in);
		return scanner.next();
	}

}