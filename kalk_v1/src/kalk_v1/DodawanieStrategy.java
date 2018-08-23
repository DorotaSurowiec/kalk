package kalk_v1;

public class DodawanieStrategy implements KalkulatorStrategy {

	@Override
	public boolean czyPasuje(OperacjaType operacja) {
		return operacja == OperacjaType.DODAWANIE;
	}

	@Override
	public int wynik(int a, int b) {
		return a + b;
	}

	@Override
	public int wynik(int[] liczby) {
		int suma;
		suma = 0;
		
		for (int i=0; i<liczby.length; i++)
			suma += liczby[i];
		
		return suma;
	}

}
