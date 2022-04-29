package compagnia;

import java.time.*;
import java.util.*;

public class CorsaSpecifica {
	private final Corsa corsa;     //IDENTIFICATIVO1
	private final LocalDate data;  //IDENTIFICATIVO2
	private int postiDisponibili;
	private int postiAutoDisponibili;
	private int ritardoPartenza;
	private int ritardoArrivo;
	
	private boolean cancellato;
	
	private ArrayList<Biglietto> prenotazioni= new ArrayList<Biglietto>();
	
	private static String messaggio="Gentile cliente, la informiamo di un ritardo relativo alla corsa da lei prenotata. Ci scusiamo per il disagio.\n";
	
	CorsaSpecifica(Corsa c, LocalDate d){
		corsa=c;
		data=d;
		postiDisponibili=corsa.getNave().getCapienzaPasseggeri();
		if (corsa.getNave() instanceof Traghetto) {
			Traghetto traghetto=(Traghetto)corsa.getNave();
			postiAutoDisponibili=traghetto.getCapienzaAuto();
		}
		else postiAutoDisponibili=0;
		ritardoPartenza=0;
		ritardoArrivo=0;
		cancellato=false;
	}
	
	public Corsa getCorsa() {
		return corsa;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public int getPostiDisponibili() {
		return postiDisponibili;
	}
	
	public void setPostiDisponibili(int pd) {
		if(pd<=postiDisponibili) {
			postiDisponibili=pd;
		}
		else System.out.println("Tentativo di aumentare i posti disponibili negato in CorsaSpecifica" + this);
	}
	
	public int getPostiAutoDisponibili() {
		return postiAutoDisponibili;
	}
	
	public void setPostiAutoDisponibili(int pd) {
		if(pd<=postiAutoDisponibili) {
			postiAutoDisponibili=pd;
		}
		else System.out.println("Tentativo di aumentare i posti auto disponibili negato in CorsaSpecifica" + this);
	}
	
	public int getRitardoPartenza() {
		return ritardoPartenza;
	}
	
	public void setRitardoPartenza(int r) {
		if(r>=0) {
			ritardoPartenza=r;
			String SMS= messaggio + "Nuovo ritardo partenza: " + ritardoPartenza + " minuti";
			for(Biglietto biglietto : prenotazioni) {
				//Funzione per mandare un SMS al singolo contatto
				System.out.println("SMS " + SMS + " inviato a " + biglietto.getCellulare());
			}
			
		}
		else System.out.println("Valore inserito in setRitardoPartenza non valido");
	}
	
	public int getRitardoArrivo() {
		return ritardoArrivo;
	}
	
	public void setRitardoArrivo(int r) {
		if(r>=0) {
			ritardoArrivo=r;
			String SMS= messaggio + "Nuovo ritardo arrivo: " + ritardoArrivo + " minuti";
			for(Biglietto biglietto : prenotazioni) {
				//Funzione per mandare un SMS al singolo contatto
				System.out.println();
				System.out.println("SMS " + SMS + " inviato a " + biglietto.getCellulare());
			}
		}
		else System.out.println("Valore inserito in setRitardoArrivo non valido");
	}
	
	public boolean getCancellato() {
		return cancellato;
	}
	
	public void setCancellato(boolean c) {
		cancellato=c;
		if(cancellato==true) {
			String SMS= messaggio + "Corsa cencellata. Richiedere rimborso in biglietteria.";
			for(Biglietto biglietto : prenotazioni) {
				//Funzione per mandare un SMS al singolo contatto
				System.out.println();
				System.out.println("SMS " + SMS + " inviato a " + biglietto.getCellulare());
			}
		}
	}
	
	public String toString() {
		return corsa + "\n" + data + " Ritardo partenza in minuti: " + ritardoPartenza + " Ritardo arrivo in minuti: " + ritardoArrivo;
	}
	
	public Biglietto emissioneBiglietto(int postiPasseggeri, boolean auto) {
		postiDisponibili-=postiPasseggeri;
		if(auto) postiAutoDisponibili--;
		if(!(auto)) {
			Biglietto biglietto=new Biglietto(postiPasseggeri);
			prenotazioni.add(biglietto);
			System.out.println("Stampa biglietto:");
			System.out.println(biglietto);
			return biglietto;
		}
		else {
			BigliettoAuto bigliettoAuto= new BigliettoAuto(postiPasseggeri);
			prenotazioni.add(bigliettoAuto);
			System.out.println("Stampa biglietto:");
			System.out.println(bigliettoAuto);
			return bigliettoAuto;
		}
	}
}
