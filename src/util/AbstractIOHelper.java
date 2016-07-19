package util;

import java.util.List;

public abstract class AbstractIOHelper {

	public abstract int readInt(String msg);

	public abstract String readPrompt(String type);

	public abstract void println(String msg);

	public abstract List<String> readChoices(String type);

	public abstract List<String> readChoices(String type, int n);

	public abstract String readString(String msg);

	public abstract int getIndex(String tmp);

	public abstract boolean readBoolean(String msg, String strTrue, String strFalse);

	public abstract int readChoice();

}