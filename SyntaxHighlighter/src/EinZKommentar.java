
/**
 * Eine von Token abgeleitete Klasse, Regul�rer Ausdruck f�r Einzeilige Kommentare.
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
