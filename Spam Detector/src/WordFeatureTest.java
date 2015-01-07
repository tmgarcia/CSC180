import static org.junit.Assert.*;

import org.junit.Test;


public class WordFeatureTest {

	@Test
	public void TestGetSpamCount()
	{
		String word = "wordString";
		int spamCount = 5;
		int hamCount = 10;
		WordFeature wf = new WordFeature(word, hamCount, spamCount);
		double gotSpamCount = wf.getSpamCount();
		assertEquals(gotSpamCount, (double)spamCount, 0.0);
	}
	@Test
	public void TestGetHamCount()
	{
		String word = "wordString";
		int spamCount = 5;
		int hamCount = 10;
		WordFeature wf = new WordFeature(word, hamCount, spamCount);
		double gotHamCount = wf.getHamCount();
		assertEquals(gotHamCount, (double)hamCount, 0.0);
	}
	@Test
	public void TestGetWord()
	{
		String word = "wordString";
		int spamCount = 5;
		int hamCount = 10;
		WordFeature wf = new WordFeature(word, hamCount, spamCount);
		String gotWord = wf.getWord();
		assertEquals(gotWord, word);
	}
}
