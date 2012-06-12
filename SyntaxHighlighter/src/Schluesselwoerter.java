/**
 * 
 * @author Christian Sander
 * Eine von Token abgeleitete Klasse, Regulärer Ausdruck für Java Schlüsselwörter.
 */
public class Schluesselwoerter extends Token{
	Schluesselwoerter(){
		regex="((import)|(class)|(public)|(private)|(final)|(static)|(return)|(if)|(else)|(while)|(try)|(catch)|(finally))";
	}
}
