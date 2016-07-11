package biz;

import java.util.LinkedList;
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

	public List<String> readChoices(String type) {
		int n = readInt("Enter the number of choices for " + type);
		if (n <= 1) {
			this.println("Invalid number.");
			return readChoices(type);
		}
		List<String> choiceList = new LinkedList<String>();
		for (int i = 0; i < n; i++) {
			choiceList.add(readString("(" + (char) ('A' + i) + ")"));
		}
		return choiceList;
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

	public int getIndex(String tmp) {
		if (tmp.length() == 1) {
			char charInedex = tmp.charAt(0);
			if ((charInedex >= 'A') && (charInedex <= 'Z'))
				return charInedex - 'A';
		}
		return -1;
	}

}