package compagnia;

public class Biglietteria implements Comparable<Biglietteria>{
	private final String nome;           //IDENTIFICATIVO1
	private final String indirizzo;      //IDENTIFICATIVO2
	private String responsabile;
	
	public Biglietteria(String n, String i, String r) {
		nome=n;
		indirizzo=i;
		responsabile=r;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public String getResponsabile() {
		return responsabile;
	}
	
	public void setResponsabile(String r) {
		responsabile=r;
	}
	
	public boolean equals(Object o) {
		if(o!=null && o instanceof Biglietteria) {
			Biglietteria b=(Biglietteria) o;
			return this.nome.equals(b.getNome()) && this.indirizzo.equals(b.getIndirizzo());
		}
		else return false;
	}
	
	public int compareTo(Biglietteria b) {
		int res=nome.compareTo(b.getNome());
		if (res!=0) return res;
		else return indirizzo.compareTo(b.getIndirizzo());
	}
	
	public String toString() {
		return nome + " " + indirizzo + " " + responsabile;
	}
}
