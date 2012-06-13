
/**
 * Eine von MehrZToken abgeleitete Klasse, Regulärer Ausdruck für Mehrzeilige Kommentare.
 * @author Christian Sander
 * 
 */


public class MehrZKommentar extends MehrZToken {
	MehrZKommentar(){
		regex ="(/\\*.*?\\*/)";
		opentag ="<font color=\"GREEN\">";
		closetag = "</font>";
	}

}
