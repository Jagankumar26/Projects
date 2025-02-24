package onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem;

import org.hibernate.Session;

public class App 
{
    public static void main( String[] args )
    {
       User u=new User();
       u.setUserE_Mail("jagan@");
       u.setUserId("1");
       u.setUserMobileNumber("112211");
       u.setUserName("jagankumar");
       u.setUserPassword("@123");
       u.setRoleName("Customer");
    Session s=   HibernetUtills.getconn().openSession();
       s.save(u);
       s.beginTransaction().commit();
    
    
    }
}
