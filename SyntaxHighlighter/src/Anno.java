
/**
 * 
 * @author Christian Sander
 * Eine von Token abgeleitete Klasse, Regul�rer Ausdruck f�r Annotationen.
 */
public class Anno extends Token {
	Anno(){
		regex ="(@\\w*)";
	}

}
