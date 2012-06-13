/**
 * Eine von Token abgeleitete Klasse, Regulärer Ausdruck für Java Schlüsselwörter.
 * @author Christian Sander
 * 
 */
public class Schluesselwoerter extends Token{
	Schluesselwoerter(){
		regex="((import)|(class)|(public)|(private)|(final)|(static)|(return)|(if)|(else)|(while)|(try)|(catch)|(finally))";
		opentag ="<font color=\"purple\">";
		closetag = "</font>";
	}
}
