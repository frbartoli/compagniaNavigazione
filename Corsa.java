package compagnia;

import java.time.*;
import java.util.*;

public class Corsa {
	private Compagnia compagnia;
	
	private LocalTime orarioPartenza;
	private LocalTime orarioArrivo;
	private double costoBiglietto;
	private double costoBigliettoAuto;
	private final Porto portoPartenza;
	private final Porto portoArrivo;
	private Nave nave;
	
	private ArrayList<CorsaSpecifica> calendario= new ArrayList<CorsaSpecifica>();
	
	public Corsa(Compagnia c, LocalTime op, LocalTime oa, double cb, Porto pp, Porto pa, Nave n) {
		compagnia=c;
		orarioPartenza=op;
		orarioArrivo=oa;
		costoBiglietto=cb;
		if (compagnia.getFlotta().contains(n)) nave=n;
		else nave=null;
		if (nave instanceof Traghetto) costoBigliettoAuto=5*cb;
		else costoBigliettoAuto=-1;   //VALORE CIVETTA
		portoPartenza=pp;
		portoArrivo=pa;
	}
	
	public LocalTime getOrarioPartenza() {
		return orarioPartenza;
	}
	
	public LocalTime getOrarioArrivo() {
		return orarioArrivo;
	}
	
	public void setOrarioPartenza(LocalTime o) {
		orarioPartenza=o;
	}
	
	public void setOrarioArrivo(LocalTime o) {
		orarioArrivo=o;
	}
	
	public double getCostoBiglietto() {
		return costoBiglietto;
	}
	
	public void setCostoBiglietto(double cb) {
		if(cb>0) {
		costoBiglietto=cb;
		costoBigliettoAuto=5*cb;
		}
		else System.out.println("Valore inserito non valido.");
	}
	
	public double getCostoBigliettoAuto() {
		return costoBigliettoAuto;
	}
	
	public Porto getPortoPartenza() {
		return portoPartenza;
	}
	
	public Porto getPortoArrivo() {
		return portoArrivo;
	}
	
	public Nave getNave() {
		return nave;
	}
	
	public void setNave(Nave n) {
		if (compagnia.getFlotta().contains(n)) nave=n;
		else System.out.println("Nave non presente nella flotta della compagnia. SetNave rifiuta l' operazione.");
	}
	
	public String toString() {
		if (costoBigliettoAuto>0) return "Partenza: " + portoPartenza + "   Arrivo:" + portoArrivo + "   Orario partenza: " + orarioPartenza + "   Orario arrivo: " + orarioArrivo + "\nCosto biglietto: " + costoBiglietto + " Costo biglietto auto: " + costoBigliettoAuto +" Nave: " + nave;
		else return "Partenza: " + portoPartenza + "   Arrivo:" + portoArrivo + "   Orario partenza: " + orarioPartenza + "   Orario arrivo: " + orarioArrivo + "\nCosto biglietto: " + costoBiglietto + " Costo biglietto auto: non previsto  Nave: " + nave;
	}
	
	public void mostraCalendario() {
		if(calendario.isEmpty()) System.out.println("Calendario vuoto");
		else {
			System.out.println("Il calendario contiene:");
			for(CorsaSpecifica corsaSpecifica : calendario) System.out.println(corsaSpecifica);
		}
	}
	
	public void aggiungiData(LocalDate date) {
		CorsaSpecifica cs= new CorsaSpecifica(this, date);
		calendario.add(cs);
	}
	
	public CorsaSpecifica cercaCorsaSpecifica (LocalDate d, int postiPasseggeri, boolean auto){
		//ArrayList<CorsaSpecifica> elenco= new ArrayList<CorsaSpecifica>();
		for(CorsaSpecifica corsa: calendario) {
			if(auto) {
				if(corsa.getData().compareTo(d)==0 && corsa.getPostiDisponibili()>=postiPasseggeri && corsa.getPostiAutoDisponibili()>0 && !corsa.getCancellato()) {
					return corsa;
				}
			}
			else {
				if(corsa.getData().compareTo(d)==0 && corsa.getPostiDisponibili()>=postiPasseggeri && !corsa.getCancellato()) {
					return corsa;
				}
			}
		}
		return null;
	}
	
	public double calcolaCostoBiglietto(int pp, boolean auto) {
		if(!(auto)) return pp*costoBiglietto;
		else return (float)pp*getCostoBiglietto()+getCostoBigliettoAuto();
	}
	
	public CorsaSpecifica cercaCorsaSpecifica (LocalDate d){
		//ArrayList<CorsaSpecifica> elenco= new ArrayList<CorsaSpecifica>();
		for(CorsaSpecifica corsa: calendario) {
			if(corsa.getData().compareTo(d)==0){
					return corsa;
			}
		}
		return null;
	}
}
