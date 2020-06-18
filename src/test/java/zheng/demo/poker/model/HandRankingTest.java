package zheng.demo.poker.model;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

/**
 * Another way to sort the data
 * Lesson_3 TODO add Assertions to validate
 *
 */
public class HandRankingTest {

	@Test
	void test_handRanking() {
		HandRanking[] ranks = HandRanking.values();

		Arrays.sort(ranks, Comparator.comparing(HandRanking::getRank));
		for (HandRanking ele : ranks) {
			System.out.println(ele.getName());
		}
	}

}
