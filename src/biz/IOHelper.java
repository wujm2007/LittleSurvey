package biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	public List<String> readCorrectChoices(Map<String, String> choices) {
		int n = readInt("Enter the number of correct choices for your multiple choice question");
		if ((n > choices.size()) || (n < 1)) {
			this.println("Invalid number.");
			return readCorrectChoices(choices);
		}
		List<String> choiceList = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String tmp = readString("correct answer #" + (i + 1));
			if ((choices.containsKey(tmp)) && (!choiceList.contains(tmp)))
				choiceList.add(tmp);
			else {
				println("Invalid index.");
				i--;
			}
		}
		return choiceList;
	}

	public List<String> readCorrectRanking(Map<String, String> choices) {
		System.out.println("Enter the correct ranking:");
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < choices.size(); i++) {
			String tmp = readString("#" + (i + 1));
			if ((choices.containsKey(tmp)) && (!l.contains(tmp)))
				l.add(tmp);
			else {
				println("Invalid index.");
				i--;
			}
		}
		return l;
	}

	public Map<String, String> readChoices(String type) {
		int n = readInt("Enter the number of choices for your " + type + " question");
		if (n <= 1) {
			this.println("Invalid number.");
			return readChoices(type);
		}
		Map<String, String> choiceList = new HashMap<String, String>();
		for (int i = 0; i < n; i++) {
			String index = "" + (char) ('A' + i);
			choiceList.put(index, readString("(" + index + ")"));
		}
		return choiceList;
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