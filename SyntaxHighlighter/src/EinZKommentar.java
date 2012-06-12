
/**
 * 
 * @author Christian Sander
 * Eine von Token abgeleitete Klasse, Regulärer Ausdruck für Einzeilige Kommentare.
 */
public class EinZKommentar extends Token {
	EinZKommentar(){
		regex="(//.*?$)";
	}
}
