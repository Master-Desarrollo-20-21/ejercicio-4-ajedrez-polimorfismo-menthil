package es.escuelaIt.masterProgramacion.poo.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
			System.in));

	public String readString(String title) {
		assert title != null;
		String input = null;
		boolean ok = false;
		do {
			this.write(title);
			try {
				input = bufferedReader.readLine();
				ok = true;
			} catch (Exception ex) {
				this.writeError("an string");
			}
		} while (!ok);
		return input;
	}

	public int readInt(String title) {
		assert title != null;
		int input = 0;
		boolean ok = false;
		do {
			try {
				input = Integer.parseInt(this.readString(title));
				ok = true;
			} catch (Exception ex) {
				this.writeError("an integer");
			}
		} while (!ok);
		return input;
	}

	public void writeln() {
		System.out.println();
	}
	
	public void write(String string) {
		assert string != null;
		System.out.print(string);
	}

	public void writeln(String string) {
		assert string != null;
		System.out.println(string);
	}

	private void writeError(String format) {
		assert format != null;
		System.out.println("FORMAT ERROR! "
				+ "Insert " + format + ".");
	}
}
