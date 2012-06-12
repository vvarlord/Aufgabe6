
public class MehrZKommentar extends MehrZToken {
	MehrZKommentar(){
		regex ="(/\\*.*?\\*/)";
		opentag ="<font color=\"GREEN\">";
		closetag = "</font>";
	}

}
