package compagnia;

public class ClienteRegistrato {
	private final String nome;
	private final String cognome;
	private String cell;
	
	public ClienteRegistrato(String n, String c, String ce) {
		nome=n;
		cognome=c;
		cell=ce;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String getCell() {
		return cell;
	}
	
	public void setCell(String ce) {
		cell=ce;
	}
}
