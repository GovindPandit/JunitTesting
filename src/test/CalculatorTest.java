package test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorTest 
{
	int a;
	int b;
	int expected;
	
	public CalculatorTest(int a,int b,int expected)
	{
		this.a=a;
		this.b=b;
		this.expected=expected;
	}
	
	@Test
	public void AddTest()
	{
		Calculator c=new Calculator();
		assertEquals(expected, c.add(a, b));
	}
	
	@Parameters
	public static Collection<Integer[]> getParameters()
	{
		Integer[][] inputArr={{1,2,3},{4,5,9},{1,2,4},{1,3,4}};
		return Arrays.asList(inputArr);
	}
}
