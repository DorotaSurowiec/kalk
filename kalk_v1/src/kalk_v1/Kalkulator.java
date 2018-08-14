package kalk_v1;

import java.util.Scanner;

public class Kalkulator {
// Testthgf
	public static void main(String[] args) {
		System.out.println("Podaj pierwsza cyfre");
		
		int a, b, w;
		Scanner odczyt = new Scanner(System.in);
		
		a = odczyt.nextInt();
		
		System.out.println("Podaj druga cyfre");
		
		b = odczyt.nextInt();
		
		System.out.print("Wybierz co chcesz zrobic\n1.dodawanie\n2.odejmowanie\n");
		
		w = odczyt.nextInt();
		
		switch(w) {
		case 1:
			System.out.println(dodaj(a, b));
			break;
		case 2:
			System.out.println(odejmij(a, b));
			break;
		default:
			System.out.println("Nieprawidlowy wybor");
		}

	}
	
	public static int dodaj (int a, int b) {
		return a + b;
	}
	
	public static int odejmij (int a, int b) {
		return a - b;
	}
}
