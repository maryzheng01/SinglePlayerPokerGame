package zheng.demo.poker;

import java.util.HashMap;
import java.util.Map;

/**
 * Lesson_10
 * static, final, String, array, array index, array element, constant variable name format, static block, hashmap
 *
 */
public class Constants {

	public static final int HAND_SIZE = 5;

	public static final Map<String, String> SUITS_ICON;
	
	static {
		SUITS_ICON = new HashMap<>();
		SUITS_ICON.put("Heart", "\u2665");
		SUITS_ICON.put("Spade", "\u2660");
		SUITS_ICON.put("Club", "\u2663");
		SUITS_ICON.put("Diamond", "\u2666");
	}

}
