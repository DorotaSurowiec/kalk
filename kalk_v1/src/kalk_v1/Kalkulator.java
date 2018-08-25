package kalk_v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kalkulator {
	
	public void start() {
		List<KalkulatorStrategy> strategie = new ArrayList<>();
		strategie.add(new DodawanieStrategy());
		strategie.add(new OdejmowanieStrategy());
		strategie.add(new Mno¿enieStrategy());
		strategie.add(new PotegowanieStrategy());
		
		System.out.println("Podaj ilosc liczb");
		
		int ilosc, a, b, w;
		int[] tab;
		
		Scanner odczyt = new Scanner(System.in);
		ilosc = odczyt.nextInt();
		
		if (ilosc == 2) {
			System.out.println("Podaj pierwsza liczbe");
			a = odczyt.nextInt();
			
			System.out.println("Podaj druga liczbe");
			b = odczyt.nextInt();
			
			System.out.print("Wybierz co chcesz zrobic\n1.dodawanie\n2.odejmowanie\n3.mnozenie\n4.potegowanie\n");
			w = odczyt.nextInt();
			
			OperacjaType wybranaOpcja = OperacjaType.fromIntValue(w);
			System.out.println("Wybrano: " + wybranaOpcja);
			for (KalkulatorStrategy strategia : strategie) {
				if (strategia.czyPasuje(wybranaOpcja)) {
					System.out.println(strategia.wynik(a, b));;
				}
			}
		}
		else if (ilosc > 2) {
			tab = new int[ilosc];
			System.out.println("Podaj liczby");
			for (int i=0; i<ilosc; i++)
				tab[i]=odczyt.nextInt();
			
			System.out.print("Wybierz co chcesz zrobic\n1.dodawanie\n2.odejmowanie\n3.mnozenie\n4.potegowanie\n");
			w = odczyt.nextInt();
			
			OperacjaType wybranaOpcja = OperacjaType.fromIntValue(w);
			System.out.println("Wybrano: " + wybranaOpcja);
			for (KalkulatorStrategy strategia : strategie) {
				if (strategia.czyPasuje(wybranaOpcja)) {
					try { 
						System.out.println(strategia.wynik(tab));
					} catch (UnsupportedOperationException e) {
						System.out.println("Nieprawidlowa ilosc liczb, sprobuj z dwoma");
					}
				}
			}
		}
		else {
			System.out.println("Nie mozna wykonac zadnej operacji");
		}
	}		
}
