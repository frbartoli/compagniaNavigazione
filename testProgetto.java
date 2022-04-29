package compagnia;

import java.time.LocalDate;
import java.time.LocalTime;

public class testProgetto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Compagnia compagnia= new Compagnia("Bartoletti");
		Nave a= new Nave("Nina", 150);
		Nave b= new Nave("Pinta", 200);
		//Nave d= new Nave("Pinta", 300);
		Traghetto c= new Traghetto("Santa Maria", 400, 120);
		//compagnia.mostraFlotta();
		//System.out.println();
		compagnia.getFlotta().add(a);
		compagnia.getFlotta().add(c);
		compagnia.getFlotta().add(b);
		//compagnia.getFlotta().add(b);
		//compagnia.getFlotta().add(d);
		compagnia.mostraFlotta();
		Porto A= new Porto("Napoli", "Via Roma 15");
		Biglietteria A1= new Biglietteria("Aurora", "Via cucco", "Antonio Rossi");
		Biglietteria A2= new Biglietteria("Vincenti", "Via Lucca", "Michele Orlando");
		A.get_biglietterie().add(A1);
		A.get_biglietterie().add(A2);
		Porto B= new Porto("Ancona", "Via Milano 12");
		Biglietteria B1= new Biglietteria("Vincenti", "Via norma", "Michele Biagiotti");
		Biglietteria B2= new Biglietteria("Maloma", "Via stru", "Enzo Versi");
		B.get_biglietterie().add(B1);
		B.get_biglietterie().add(B2);
		Porto C= new Porto("Genova", "Via Cocca 11");
		Biglietteria C1= new Biglietteria("Dudu", "Via lupus", "Enzo Miccio");
		Biglietteria C2= new Biglietteria("LaMarmora", "Via 20 settembre", "Michele Norro");
		C.get_biglietterie().add(C1);
		C.get_biglietterie().add(C2);
		Corsa Z1= new Corsa(compagnia, LocalTime.of(11, 15), LocalTime.of(16, 15), 21.01, A, C, a);
		//System.out.println(Z1);
		Corsa Z2= new Corsa(compagnia, LocalTime.of(12, 15), LocalTime.of(19, 15), 24, B, C, c);  //TRAGHETTO
		Corsa Z3= new Corsa(compagnia, LocalTime.of(6, 15), LocalTime.of(9, 15), 11, A, B, b);
		compagnia.getCatalogo().add(Z1);
		compagnia.getCatalogo().add(Z2);
		compagnia.getCatalogo().add(Z3);
		System.out.println();
		compagnia.mostraCatalogo();
		Z1.aggiungiData(LocalDate.of(2018, 6, 11));
		Z1.aggiungiData(LocalDate.of(2018, 6, 13));
		Z2.aggiungiData(LocalDate.of(2018, 6, 12));
		Z2.aggiungiData(LocalDate.of(2018, 6, 15));
		Z3.aggiungiData(LocalDate.of(2018, 6, 6));
		Z3.aggiungiData(LocalDate.of(2018, 7, 11));
		System.out.println();
		/*Z1.mostraCalendario();
		System.out.println();
		Z2.mostraCalendario();
		System.out.println();
		Z3.mostraCalendario();
		System.out.println();*/
		//Biglietto BA=compagnia.cercaCorsa(A, C, LocalDate.of(2018, 6, 13), 2, false);
		Biglietto BB=compagnia.cercaCorsa("Ancona", "Genova", LocalDate.of(2018, 6, 15), 3, true);
		if(BB!= null) {
			BB.aggiungiCliente("Mario", "Normanno", "331-234643");
			Z2.cercaCorsaSpecifica(LocalDate.of(2018, 6, 15)).setRitardoPartenza(35);
			Z2.cercaCorsaSpecifica(LocalDate.of(2018, 6, 15)).setRitardoArrivo(35);
			Z2.cercaCorsaSpecifica(LocalDate.of(2018, 6, 15)).setCancellato(true);
			Biglietto BC=compagnia.cercaCorsa(B, C, LocalDate.of(2018, 6, 15), 3, true);
		}
	}

}
