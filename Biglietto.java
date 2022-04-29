package compagnia;

public class Biglietto {
	private final int ID;
	private final String codice;
	private final int numeroPostiPasseggero;
	private static int count=1000000000;
	private static int scount=1;
	
	private ClienteRegistrato cliente;
	
	public Biglietto(int pp) {
		ID=count;
		count++;
		codice="CI" + scount;
		scount++;
		numeroPostiPasseggero=pp;
		cliente=null;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getCodice() {
		return codice;
	}
	
	public int getNumeroPostiPasseggero() {
		return numeroPostiPasseggero;
	}
	
	public String toString() {
		return "ID: " + ID + " Codice: " + codice + " numero posti passeggero: " + numeroPostiPasseggero;
	}
	
	public void aggiungiCliente(String nome, String cognome, String cell) {
		cliente= new ClienteRegistrato(nome, cognome, cell);
	}
	
	public String getCellulare() {
		if(cliente==null) return null;
		else return cliente.getCell();
	}
}
