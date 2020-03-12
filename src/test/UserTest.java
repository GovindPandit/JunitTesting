package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import dao.UserDAO;
import daoimpl.UserDAOImpl;
import model.User;

public class UserTest
{
	UserDAOImpl userDAO=new UserDAOImpl();
	
	/*
	 		Junit Assertion methods:
	 		
	 		1)assertEquals()
	 		2)assertNotEquals()
	 		3)assertNull()
	 		4)assertNotNull()
	 		5)assertFalse()
	 		6)assertTrue()
	 		7)assertSame()
	 		8)assertNotSame()
	 		
	 		
	 		
	 		Annotations
	 		1)@Test
	 		2)@Ignore
	 		3)@Before
	 		4)@After
	 		5)@AfterClass
	 		6)@BeforeClass
	 		
	 		Order of before and after method
	 			BeforeClass
	 			Before2
	 			Before1
	 			Test Case
	 			After1
	 			After2
	 			AfterClass
	 			
	 		AfterClass & BeforeClass Rules
	 			1)This method should be static
	 			2)You cannot pass anything in before or after class method.
	 			3)Return type should be void
	 			
	 			After and before
	 				-must be public
	 */
	
	@BeforeClass
	public static void m123()
	{
		System.out.println("this is before class method1");
	}
	
	@BeforeClass
	public static void m124()
	{
		System.out.println("this is before class method2");
	}
	
	@AfterClass
	public static void m125()
	{
		System.out.println("this is after class method1");
	}
	
	@AfterClass
	public static void m126()
	{
		System.out.println("this is after class method2");
	}
	
	@Before
	public void setUp1()
	{
		System.out.println("this is before1 method");
	}
	
	@Before
	public void setUp2()
	{
		System.out.println("this is before2 method");
	}
	
	@After
	public void tearDown1()
	{
		System.out.println("this is after1 method");
	}
	
	@After
	public void tearDown2()
	{
		System.out.println("this is after2 method");
	}
	
	@Test
	@Ignore
	public void addUser()
	{
		User u=new User();
		u.setUsername("Sagar");
		u.setEmail("Sagar@gmail.com");
		u.setPassword("Sagar@123");
		
		assertEquals(true, userDAO.addUser(u));
	}
	
	@Test
	@Ignore
	public void updateUser()
	{
		User u=new User();
		u.setUsername("Sagar");
		u.setEmail("Sagar123@gmail.com");
		u.setPassword("Sagar@1234");
		
		assertEquals("error message",true, userDAO.updateUser(u));
		
	}
	
	
	@Test
	@Ignore
	public void displayUserByName()
	{
		assertNotNull(userDAO.displayUserByName("sagar"));
	}
	
	@Test
	public void displayAllUsers()
	{
		assertNotEquals(null, userDAO.displayAllUsers());
	}
	
	@Test
	@Ignore
	public void deleteUser()
	{
		assertEquals(true, userDAO.deleteUser("Sagar"));
	}
	
	@Test
	public void assertSameMethod()
	{
		User u=new User();
		Object o1=new Object();
		
		assertSame(u, u);
	}
	
}
