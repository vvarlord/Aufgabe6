
/**
 * Eine von Token abgeleitete Klasse, Regulärer Ausdruck für Einzeilige Kommentare.
 * @author Christian Sander
 * 
 */
public class EinZKommentar extends Token {
	
	EinZKommentar(){
		regex="(//.*?$)";
		opentag ="<font color=\"GREEN\">";
		closetag = "</font>";

	}
}
