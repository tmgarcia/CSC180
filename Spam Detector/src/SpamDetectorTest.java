import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;


public class SpamDetectorTest 
{

	@Test
	public void TestSpamStreamConstructor() throws FileNotFoundException 
	{
		FileInputStream stream;
		stream = new FileInputStream("antispam-table.txt");
		try
		{
			SpamDetector detector = new SpamDetector(stream);
		}
		catch(Exception e)
		{
			fail("Constructor failed");
		}
	}

	@Test
	public void TestNoSpamFound() throws Exception
	{
		FileInputStream emailStream = new FileInputStream("email.txt");
		Email cleanEmail = new Email(emailStream);
		
		FileInputStream spamStream = new FileInputStream("antispam-table.txt");
		SpamDetector detector = new SpamDetector(spamStream);
		
		boolean containsSpam = detector.isSpam(cleanEmail);
		assertFalse(containsSpam);
	}
	
	@Test
	public void TestSpamFound() throws Exception
	{
		FileInputStream emailStream = new FileInputStream("spamEmail.txt");
		Email badEmail = new Email(emailStream);
		
		FileInputStream spamStream = new FileInputStream("antispam-table.txt");
		SpamDetector detector = new SpamDetector(spamStream);
		
		boolean containsSpam = detector.isSpam(badEmail);
		assertTrue(containsSpam);
	}
	
}
