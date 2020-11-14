package es.escuelaIt.masterProgramacion.poo.utils;

public class LimitedIntDialog {

	private String title;
	
    private ClosedInterval limits;
	
	public LimitedIntDialog(String title, int min, int max){
		assert title != null;
		this.limits = new ClosedInterval(min, max);
        this.title = title + " " + limits + ": ";
	}
	
	public LimitedIntDialog(String title, int max){
		this(title, 1, max);
	}
	
	public int read(){
		Console console = new Console();
		int value;
		boolean ok;
		do {
			value = console.readInt(title);
			ok = limits.includes(value);
			if (!ok) {
				console.writeln("The value must be between " + limits);
			}
		} while (!ok);
		return value;
	}
}
