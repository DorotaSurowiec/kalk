package kalk_v1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.OperationNotSupportedException;

public class Kalkulator {
	
	List<KalkulatorStrategy> strategie;
	
	public void start() throws FileNotFoundException {
		initStrategies();
		
		System.out.println("Podaj ilosc liczb");
		
		Scanner odczyt = new Scanner(System.in);
		int iloscLiczb = odczyt.nextInt();
		
		if (iloscLiczb < 2) {
			System.out.println("Nie mozna wykonac zadnej operacji");
			odczyt.close();
			return;
		}
		
		try {
			int calculationResult;
			if (iloscLiczb == 2) {
				calculationResult = calculateForTwoNumbers(odczyt);
			} else  {
				calculationResult = calculateForArrayNumbers(iloscLiczb, odczyt);
			}
			System.out.println("Czy chcesz zapisac wynik do pliku? tak/nie");
			boolean czyZapisac = odczyt.nextLine().equals("tak");
			
			if (czyZapisac) {
				PrintWriter zapis = new PrintWriter ("ZapisanyWynik.txt");
				zapis.println(calculationResult);
				zapis.close();
			}
		} catch (OperationNotSupportedException e) {
			
		}
	}

	private int calculateForArrayNumbers(int iloscLiczb, Scanner odczyt) throws OperationNotSupportedException {
		int operationTypeIntValue;
		int[] choosenNumbers;
		
		choosenNumbers = new int[iloscLiczb];
		System.out.println("Podaj liczby");
		for (int i=0; i<iloscLiczb; i++)
			choosenNumbers[i]=odczyt.nextInt();
		
		System.out.print("Wybierz co chcesz zrobic\n1.dodawanie\n2.odejmowanie\n3.mnozenie\n4.potegowanie\n");
		operationTypeIntValue = odczyt.nextInt();
		
		OperacjaType wybranaOpcja = OperacjaType.fromIntValue(operationTypeIntValue);
		System.out.println("Wybrano: " + wybranaOpcja);
		
		for (KalkulatorStrategy strategia : strategie) {
			if (strategia.czyPasuje(wybranaOpcja)) {
				try {
					return strategia.wynik(choosenNumbers);
				} catch (UnsupportedOperationException e) {
					System.out.println("Nieprawidlowa ilosc liczb, wybrano " + iloscLiczb + ", a nalezy podac 2 liczby");
				}
			}
		}
		
		throw new OperationNotSupportedException();
	}

	private int calculateForTwoNumbers(Scanner odczyt) throws OperationNotSupportedException {
		int firstNumber;
		int secondNumber;
		int operationTypeIntValue;
		
		System.out.println("Podaj liczby");
		firstNumber = odczyt.nextInt();
		secondNumber = odczyt.nextInt();
		
		System.out.print("Wybierz co chcesz zrobic\n1.dodawanie\n2.odejmowanie\n3.mnozenie\n4.potegowanie\n");
		operationTypeIntValue = odczyt.nextInt();
		
		OperacjaType wybranaOpcja = OperacjaType.fromIntValue(operationTypeIntValue);
		System.out.println("Wybrano: " + wybranaOpcja);
		
		for (KalkulatorStrategy strategia : strategie) {
			if (strategia.czyPasuje(wybranaOpcja)) {
				return strategia.wynik(firstNumber, secondNumber);
			}
		}
		
		throw new OperationNotSupportedException();
	}

	private void initStrategies() {
		strategie = new ArrayList<>();
		strategie.add(new DodawanieStrategy());
		strategie.add(new OdejmowanieStrategy());
		strategie.add(new Mno¿enieStrategy());
		strategie.add(new PotegowanieStrategy());
	}		
}
