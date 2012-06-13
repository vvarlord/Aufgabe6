
/**
 * Eine von Token abgeleitete Klasse, Regulärer Ausdruck für Annotationen.
 * @author Christian Sander
 * 
 */
public class Anno extends Token {
	Anno(){
		regex ="(@\\w*)";
		opentag ="<font color=\"RED\">";
		closetag = "</font>";
	}

}
