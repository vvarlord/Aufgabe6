/**
 * Eine von Token abgeleitete Klasse, Regul�rer Ausdruck f�r Strings.
 * @author Christian Sander
 * 
 */
public class Strings extends Token {
	Strings(){
		regex ="(\"\\w*\")";
		opentag ="<font color=\"Blue\">";
		closetag = "</font>";
	}

}
