/**
 * 
 * @author Christian Sander
 * Eine von Token abgeleitete Klasse, Regulärer Ausdruck für Strings.
 */
public class Strings extends Token {
	Strings(){
		regex ="(\"\\w*\")";
		opentag ="<font color=\"Blue\">";
		closetag = "</font>";
	}

}
