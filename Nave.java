package compagnia;

public class Nave implements Comparable<Nave>{
	private final String nome;   //IDENTIDICATIVO
	private final int capienzaPasseggeri;
	
	public Nave(String n, int cp) {
		nome=n;
		capienzaPasseggeri=cp;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getCapienzaPasseggeri() {
		return capienzaPasseggeri;
	}
	
	public boolean equals(Object o) {
		if(o!=null && o instanceof Nave) {
			Nave n=(Nave) o;
			return this.nome.equals(n.getNome());
		}
		else return false;
	}
	
	public int compareTo(Nave n) {
		//Nave n=(Nave) o;
		return nome.compareTo(n.getNome());
	}
	
	public String toString() {
		return nome + " " + capienzaPasseggeri + " posti passeggeri ";
	}
}
