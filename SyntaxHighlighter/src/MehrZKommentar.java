/**
 * 
 * @author Christian Sander
 * Eine von MehrZToken abgeleitete Klasse, Regulärer Ausdruck für Mehrzeilige Kommentare.
 */

public class MehrZKommentar extends MehrZToken {
	MehrZKommentar(){
		regex ="(/\\*.*?\\*/)";
	}

}
