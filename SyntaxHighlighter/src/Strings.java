/**
 * Eine von Token abgeleitete Klasse, Regulärer Ausdruck für Strings.
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
