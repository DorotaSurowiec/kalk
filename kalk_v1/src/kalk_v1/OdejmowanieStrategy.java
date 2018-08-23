package kalk_v1;

public class OdejmowanieStrategy implements KalkulatorStrategy {

	@Override
	public boolean czyPasuje(OperacjaType operacja) {
		return operacja == OperacjaType.ODEJMOWANIE;
	}

	@Override
	public int wynik(int a, int b) {
		return a - b;
	}

	@Override
	public int wynik(int[] liczby) {
		int roznica;
		roznica = 0;
		
		for (int i=0; i<liczby.length; i++)
			roznica -= liczby[i];
		
		return roznica;
	}

}
