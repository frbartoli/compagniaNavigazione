package compagnia;

public class Traghetto extends Nave{
	private final int capienzaAuto;
	
	public Traghetto(String n, int cp, int ca) {
		super(n, cp);
		capienzaAuto=ca;
	}
	
	public int getCapienzaAuto() {
		return capienzaAuto;
	}
	
	/*public boolean equals(Object o) {
		if(o!=null && o instanceof Traghetto) {
			Traghetto t=(Traghetto) o;
			return this.getNome().equals(t.getNome());
		}
		else return false;
	}*/
	
	public String toString() {
		return super.toString() + capienzaAuto + " posti auto";
	}
}
