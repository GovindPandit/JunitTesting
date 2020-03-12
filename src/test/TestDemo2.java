package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestDemo2 
{
	@Test(expected=Exception.class)
	public void division()
	{
		Calculator c=new Calculator();
		assertEquals(1, c.div(2, 0));
	}
	
	
}
