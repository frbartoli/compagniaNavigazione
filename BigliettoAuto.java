package compagnia;

import java.util.Scanner;

public class BigliettoAuto extends Biglietto{
	private final String targa;
	private final String tipoVeicolo;
	private final String nomeProprietario;
	private final String cognomeProprietario;
	
	private ClienteRegistrato cliente;
	
	public BigliettoAuto(int pp) {
		super(pp);
		System.out.println("Inserire targa veicolo, tipo veicolo e nome e cognome del proprietario");
		Scanner scanner=new Scanner(System.in);
		targa=scanner.next();
		tipoVeicolo=scanner.next();
		nomeProprietario=scanner.next();
		cognomeProprietario=scanner.next();
		scanner.close();
	}
	
	public String getTarga() {
		return targa;
	}
	
	public String getTipo() {
		return tipoVeicolo;
	}
	
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	
	public String getCognomeProprietario() {
		return cognomeProprietario;
	}
	
	public String toString() {
		return super.toString() + " + automobile " + tipoVeicolo + " targata " + targa;
	}
	
	public void registraCliente(String nome, String cognome, String cellulare) {
		cliente= new ClienteRegistrato(nome, cognome, cellulare);
	}
}
