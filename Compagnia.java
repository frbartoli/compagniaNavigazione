package compagnia;

import java.util.*;
import java.time.*;

public class Compagnia {
	private final String nome;
	private SortedSet<Nave> flotta;
	private ArrayList<Corsa> catalogo= new ArrayList<Corsa>();
	
	public Compagnia(String n) {
		nome=n;
		flotta=new TreeSet<Nave>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public SortedSet<Nave> getFlotta(){
		return flotta;
	}
	
	public ArrayList<Corsa> getCatalogo(){
		return catalogo;
	}
	
	public void mostraFlotta() {
		if (flotta.isEmpty()) System.out.println("Flotta vuota");
		else {
			System.out.println("La flotta contiene:");
			for(Nave nave : flotta) System.out.println(nave);
		}
	}
	
	public void mostraCatalogo() {
		if(catalogo.isEmpty()) System.out.println("Catalogo vuoto");
		else {
			System.out.println("Il catalogo contiene:");
			for(Corsa corsa : catalogo) System.out.println(corsa);
		}
	}
	
	public Biglietto cercaCorsa(Porto pp, Porto pa, LocalDate d, int postiPasseggeri, boolean auto) {
		if(postiPasseggeri==0 && auto==false) return null;
		ArrayList<CorsaSpecifica> offerta= new ArrayList<CorsaSpecifica>();
		for (Corsa corsa: catalogo) {
			if(corsa.getPortoPartenza()==pp && corsa.getPortoArrivo()==pa) {
				if(corsa.cercaCorsaSpecifica(d, postiPasseggeri, auto)!=null) {
				offerta.add(corsa.cercaCorsaSpecifica(d, postiPasseggeri, auto));
				}
			}
		}
		if (offerta.isEmpty()) {
			System.out.println("Nessun viaggio corrispondente alla richiesta.");
			return null;
		}
		for(CorsaSpecifica corsaSpecifica: offerta) {
			System.out.println(offerta.indexOf(corsaSpecifica) + "   " + corsaSpecifica + " Costo biglietto: " + corsaSpecifica.getCorsa().calcolaCostoBiglietto(postiPasseggeri, auto));
		}
		System.out.println();
		System.out.println("Inserire il numero d' indice del viaggio scelto dall' utente");
		Scanner scanner= new Scanner(System.in);
		int nelem=scanner.nextInt();
		while(nelem<0 || nelem>=offerta.size()) {
			System.out.println("Valore inserito non valido. Riprovare.");
			System.out.println("Inserire il numero d' indice del viaggio scelto dall' utente");
			nelem=scanner.nextInt();
		}
		CorsaSpecifica scelta= offerta.get(nelem);
		System.out.println("Effettuare conferma prenotazione per viaggio " + scelta);
		System.out.println("1 conferma. 0 annulla");
		int conferma=scanner.nextInt();
		while(conferma<0 || conferma>1) {
			System.out.println("1 conferma. 0 annulla");
			conferma=scanner.nextInt();
		}
		//scanner.close();
		if(conferma==0) {
			System.out.println("Operazione annullata.");
			return null;
		}
		else if(conferma==1) return scelta.emissioneBiglietto(postiPasseggeri, auto);
		else return null;
	}
	public Biglietto cercaCorsa(String pp, String pa, LocalDate d, int postiPasseggeri, boolean auto) {
		if(postiPasseggeri==0 && auto==false) return null;
		ArrayList<CorsaSpecifica> offerta= new ArrayList<CorsaSpecifica>();
		for (Corsa corsa: catalogo) {
			if(corsa.getPortoPartenza().equals(pp) && corsa.getPortoArrivo().equals(pa)) {
				if(corsa.cercaCorsaSpecifica(d, postiPasseggeri, auto)!=null) {
				offerta.add(corsa.cercaCorsaSpecifica(d, postiPasseggeri, auto));
				}
			}
		}
		if (offerta.isEmpty()) {
			System.out.println("Nessun viaggio corrispondente alla richiesta.");
			return null;
		}
		for(CorsaSpecifica corsaSpecifica: offerta) {
			System.out.println(offerta.indexOf(corsaSpecifica) + "   " + corsaSpecifica + " Costo biglietto: " + corsaSpecifica.getCorsa().calcolaCostoBiglietto(postiPasseggeri, auto));
		}
		System.out.println();
		System.out.println("Inserire il numero d' indice del viaggio scelto dall' utente");
		Scanner scanner= new Scanner(System.in);
		int nelem=scanner.nextInt();
		while(nelem<0 || nelem>=offerta.size()) {
			System.out.println("Valore inserito non valido. Riprovare.");
			System.out.println("Inserire il numero d' indice del viaggio scelto dall' utente");
			nelem=scanner.nextInt();
		}
		CorsaSpecifica scelta= offerta.get(nelem);
		System.out.println("Effettuare conferma prenotazione per viaggio " + scelta);
		System.out.println("1 conferma. 0 annulla");
		int conferma=scanner.nextInt();
		while(conferma<0 || conferma>1) {
			System.out.println("1 conferma. 0 annulla");
			conferma=scanner.nextInt();
		}
		//scanner.close();
		if(conferma==0) {
			System.out.println("Operazione annullata.");
			return null;
		}
		else if(conferma==1) return scelta.emissioneBiglietto(postiPasseggeri, auto);
		else return null;
	}
}
