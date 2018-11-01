package ua.nure.kn16.muzyka.usermanagement;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import junit.framework.*;
import ua.nure.kn16.muzyka.usermanagement.User;

class UserTest extends TestCase {
	
	 public static final long ID = 1L;
	    public static final String FIRST_NAME = "Ruslan";
	    public static final String LAST_NAME = "Muzyka";

	    private static final int YEAR_BIRTH = 1999;

	    private static int today;

	    private User user;

	    @Before
	    public void setUp() throws Exception {
	        user = new User(ID, FIRST_NAME, LAST_NAME, new Date());
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(new Date());
	        today = calendar.get(Calendar.DATE);
	    }


	    @Test
	    public void testGetFullName() {
	        User user = new User(ID, FIRST_NAME, LAST_NAME, null);
	        assertEquals("Ruslan, Muzyka", user.getFullName());
	    }


	    @Test
	    public void testAgeAfter() {
	        Calendar calendar = Calendar.getInstance();
	        calendar.set(YEAR_BIRTH, Calendar.OCTOBER, 16);
	        User user = new User(ID, FIRST_NAME, LAST_NAME, calendar.getTime());
	        assertEquals(19, user.getAge());
	    }

	    @Test
	    public void testAgeBefore() {
	        Calendar calendar = Calendar.getInstance();
	        calendar.set(YEAR_BIRTH, Calendar.NOVEMBER, 28);
	        User user = new User(ID, FIRST_NAME, LAST_NAME, calendar.getTime());
	        assertEquals(18, user.getAge());
	    }

	    @Test
	    public void testAgeTheSameDay() {
	        Calendar calendar = Calendar.getInstance();
	        calendar.set(YEAR_BIRTH, Calendar.NOVEMBER, today);
	        User user = new User(ID, FIRST_NAME, LAST_NAME, calendar.getTime());
	        assertEquals(19, user.getAge());
	    }
	}
