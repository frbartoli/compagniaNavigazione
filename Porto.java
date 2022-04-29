package compagnia;

import java.util.*;

public class Porto{
	private final String nome;    //IDENTIFICATIVO
	private final String indirizzo;
	private SortedSet<Biglietteria> biglietterie;
	
	public Porto(String n, String i) {
		nome=n;
		indirizzo=i;
		biglietterie= new TreeSet<Biglietteria>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public SortedSet<Biglietteria> get_biglietterie(){
		return biglietterie;
	}
	
	public boolean equals(Object o) {
		if(o!=null && o instanceof Porto) {
			Porto p=(Porto) o;
			return this.nome.equals(p.getNome());
		}
		else if (o instanceof String) {
			String s= (String) o;
			return nome.equals(o);
		}
		else return false;
	}
	
	public String toString() {
		return nome + " " + indirizzo;
	}
}
