package Online_Movie_TicketBooking_System;

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
			cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Online_Movie_TicketBooking_System");
			cfg.setProperty("hibernate.connection.username", "root");
			cfg.setProperty("hibernate.connection.password", "root");
			cfg.setProperty("hibernate.hbm2ddl.auto", "update");
			cfg.setProperty("hibernate.show_sql", "false");
			cfg.setProperty("hibernate.format_sql", "true");
cfg.addAnnotatedClass( Online_Movie_TicketBooking_System.Theatre.class);
cfg.addAnnotatedClass( Online_Movie_TicketBooking_System.Booking.class);
cfg.addAnnotatedClass( Online_Movie_TicketBooking_System.Customer.class);
cfg.addAnnotatedClass( Online_Movie_TicketBooking_System.Payment.class);
cfg.addAnnotatedClass( Online_Movie_TicketBooking_System.Seat.class);
cfg.addAnnotatedClass( Online_Movie_TicketBooking_System.Movie.class);

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
