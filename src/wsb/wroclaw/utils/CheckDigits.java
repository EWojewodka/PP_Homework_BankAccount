package wsb.wroclaw.utils;

public class CheckDigits {

	public static boolean isOnlyDigits(String text) {
		for (Character character : text.toCharArray()) {
			if (!Character.isDigit(character)) {
				return false;
			}
		}
		return true;
	}

}
