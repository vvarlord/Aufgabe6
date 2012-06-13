import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;


public class Argumente {
	boolean log1=false;
	boolean log2=false;
	public Argumente(String args[]) {
		param(args);
	}
	/**
	 * methode die übergabe parametern auswertet 
	 * @param args Übergabeparameter
	 */
	public void param(String args[]){
		Options opts = new Options();
		opts.addOption(new Option("d","debug", false, "Debug modus setzen"));
		opts.addOption(new Option("f","file",false, "Datei zur ausgabe"));
		
		PosixParser parser = new PosixParser();
		try {
			CommandLine line = parser.parse(opts, args);
			
			if(line.hasOption("debug")){
				log1 = true;
			}
			if(line.hasOption("file")){
				log2=true;
			}
		} catch (ParseException e) {
			System.err.println("Parameter fehler.");
		}
	}
	public boolean isLog1() {
		return log1;
	}
	public boolean isLog2() {
		return log2;
	}
}