package kalk_v1;

public class MnożenieStrategy implements KalkulatorStrategy {

	@Override
	public boolean czyPasuje(OperacjaType operacja) {
		return operacja == OperacjaType.MNOŻENIE;
	}

	@Override
	public int wynik(int a, int b) {
		return a*b;
	}

	@Override
	public int wynik(int[] liczby) {
		int iloczyn;
		iloczyn = 0;
		
		for (int i=0; i<liczby.length; i++)
			iloczyn *= liczby[i];
		
		return iloczyn;
	}
	
}
