
/**
 * 
 * @author Christian Sander
 * Eine von Token abgeleitete Klasse, Regul�rer Ausdruck f�r Einzeilige Kommentare.
 */
public class EinZKommentar extends Token {
	EinZKommentar(){
		regex="(//.*?$)";
	}
}
