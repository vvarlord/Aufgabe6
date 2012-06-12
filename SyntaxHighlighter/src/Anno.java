
/**
 * 
 * @author Christian Sander
 * Eine von Token abgeleitete Klasse, Regulärer Ausdruck für Annotationen.
 */
public class Anno extends Token {
	Anno(){
		regex ="(@\\w*)";
	}

}
