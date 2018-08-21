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
		
		System.out.println("Podaj pierwsza cyfre");
		
		int a, b, w;
		Scanner odczyt = new Scanner(System.in);
		
		a = odczyt.nextInt();
		
		System.out.println("Podaj druga cyfre");
		
		b = odczyt.nextInt();
		
		System.out.print("Wybierz co chcesz zrobic\n1.dodawanie\n2.odejmowanie\n3.mno¿enie\n");
		
		w = odczyt.nextInt();
		OperacjaType wybranaOpcja = OperacjaType.fromIntValue(w);
		System.out.println("Wybrano: " + wybranaOpcja);
		for (KalkulatorStrategy strategia : strategie) {
			if (strategia.czyPasuje(wybranaOpcja)) {
				System.out.println(strategia.wynik(a, b));;
			}
		}
	}
}
