
/**
 * 
 * @author Christian Sander
 * Eine von MehrZToken abgeleitete Klasse, Regul�rer Ausdruck f�r Mehrzeilige Kommentare.
 */


public class MehrZKommentar extends MehrZToken {
	MehrZKommentar(){
		regex ="(/\\*.*?\\*/)";
		opentag ="<font color=\"GREEN\">";
		closetag = "</font>";
	}

}
