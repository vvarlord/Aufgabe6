/**
 * 
 * @author Christian Sander
 * Eine von Token abgeleitete Klasse, Regul�rer Ausdruck f�r Strings.
 */
public class Strings extends Token {
	Strings(){
		regex ="(\"\\w*\")";
		opentag ="<font color=\"Blue\">";
		closetag = "</font>";
	}

}
