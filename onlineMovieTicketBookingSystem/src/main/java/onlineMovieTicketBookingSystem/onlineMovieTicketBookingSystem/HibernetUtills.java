package onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.*;
public class HibernetUtills {
	static SessionFactory sf = null;
	static {
		try {

			Configuration cfg = new Configuration();
			cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/online_Movie_Ticket_bookingSystem");
			cfg.setProperty("hibernate.connection.username", "root");
			cfg.setProperty("hibernate.connection.password", "root");
			cfg.setProperty("hibernate.hbm2ddl.auto", "update");
			cfg.setProperty("hibernate.show_sql", "true");
			cfg.setProperty("hibernate.format_sql", "true");
cfg.addAnnotatedClass(onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem.AdminUser.class);
cfg.addAnnotatedClass(onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem.User.class);
cfg.addAnnotatedClass(onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem.Shows.class);
cfg.addAnnotatedClass(onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem.OwnerUser.class);
cfg.addAnnotatedClass(onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem.Seats.class);
cfg.addAnnotatedClass(onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem.Theatres.class);
cfg.addAnnotatedClass(onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem.Movies.class);
cfg.addAnnotatedClass(onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem.Tickets.class);


			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
					.build();
			sf = cfg.buildSessionFactory(ssr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static SessionFactory getconn() {
		return sf;
	}
}
