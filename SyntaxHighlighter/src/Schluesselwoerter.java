/**
 * 
 * @author Christian Sander
 * Eine von Token abgeleitete Klasse, Regul�rer Ausdruck f�r Java Schl�sselw�rter.
 */
public class Schluesselwoerter extends Token{
	Schluesselwoerter(){
		regex="((import)|(class)|(public)|(private)|(final)|(static)|(return)|(if)|(else)|(while)|(try)|(catch)|(finally))";
	}
}
