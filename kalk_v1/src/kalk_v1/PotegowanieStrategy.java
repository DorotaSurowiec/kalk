package kalk_v1;

public class PotegowanieStrategy implements KalkulatorStrategy {

	@Override
	public boolean czyPasuje(OperacjaType operacja) {
		return operacja == OperacjaType.POTEGOWANIE;
	}

	@Override
	public int wynik(int a, int b) {
		return (int) Math.pow(a, b);
	}

	@Override
	public int wynik(int[] liczby) {
		if (liczby.length != 2) {
			throw new UnsupportedOperationException ("Nieprawidlowa ilosc liczb");
		}
		else {
			return (int) Math.pow(liczby[0], liczby[1]);
		}	
	}
}
