import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class EmailTest 
{
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void TestBadEmailStream() throws Exception
	{
		FileInputStream stream = new FileInputStream("badEmail.txt");
		exception.expect(IllegalArgumentException.class);
		Email e = new Email(stream);
	}
	
	@Test
	public void TestGetToParts()
	{
		Email e = new Email("recipient@email.com", "sender@email.com", "Email subject", "Email Content");
		String gotTo = e.getTo();
		assertEquals(gotTo, "recipient@email.com");
	}
	@Test
	public void TestGetToStream() throws Exception
	{
		FileInputStream stream = new FileInputStream("email.txt");
		Email e = new Email(stream);
		String gotTo = e.getTo();
		assertEquals(gotTo, "jcummings@neumont");
	}
	@Test
	public void TestFromParts()
	{
		Email e = new Email("recipient@email.com", "sender@email.com", "Email subject", "Email Content");
		String gotFrom = e.getFrom();
		assertEquals(gotFrom, "sender@email.com");
	}
	@Test
	public void TestFromStream() throws Exception
	{
		FileInputStream stream = new FileInputStream("email.txt");
		Email e = new Email(stream);
		String gotFrom = e.getFrom();
		assertEquals(gotFrom, "bob@neumont");
	}
	@Test
	public void TestSubjectParts()
	{
		Email e = new Email("recipient@email.com", "sender@email.com", "Email subject", "Email Content");
		String gotSubject = e.getSubject();
		assertEquals(gotSubject, "Email subject");
	}
	@Test
	public void TestSubjectStream() throws Exception
	{
		FileInputStream stream = new FileInputStream("email.txt");
		Email e = new Email(stream);
		String gotSubject = e.getSubject();
		assertEquals(gotSubject, "Howdy");
	}
	@Test
	public void TestContentParts()
	{
		Email e = new Email("recipient@email.com", "sender@email.com", "Email subject", "Email Content");
		String gotContent = e.getContent();
		assertEquals(gotContent, "Email Content");
	}
	@Test
	public void TestContentStream() throws Exception
	{
		FileInputStream stream = new FileInputStream("email.txt");
		Email e = new Email(stream);
		String gotContent = e.getContent();
		assertEquals(gotContent, "What do you think of this new email system?");
	}
}
