package kalk_v1;

public enum OperacjaType {
	DODAWANIE(1), 
	ODEJMOWANIE(2),
	MNO¯ENIE(3),
	POTEGOWANIE(4);
	
	int opcja;

	private OperacjaType(int opcja) {
		this.opcja = opcja;
	}

	public int getOpcja() {
		return opcja;
	}
	
	public static OperacjaType fromIntValue(int value) {
		for (OperacjaType operacja : values()) {
			if (operacja.getOpcja() == value) {
				return operacja;
			}
		}
		
		return null;
	}
	
}
