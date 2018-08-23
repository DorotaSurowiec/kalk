package kalk_v1;

public interface KalkulatorStrategy {
	boolean czyPasuje(OperacjaType operacja);
	int wynik(int a, int b);
	int wynik(int[] liczby);
}
