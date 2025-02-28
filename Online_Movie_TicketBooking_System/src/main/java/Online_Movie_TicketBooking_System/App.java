package Online_Movie_TicketBooking_System;



	import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;

import jakarta.persistence.Query;

	public class App
	{

	    public static void main(String[] args) {
	    
	    SessionFactory sf=	HibernetUtills.getconn();
	        Session session = sf.openSession();
	        Scanner scanner = new Scanner(System.in);
String type;
	       
	            // Start transaction
	            session.beginTransaction();

	            // Step 1: Register new customer
	            System.out.println("Please register as a customer");
	            System.out.print("Enter your name: ");
	            String name = scanner.nextLine();
	            System.out.print("Enter your email: ");
	            String email = scanner.nextLine();
	            System.out.print("Enter your phone number: ");
	            String phone = scanner.nextLine();
	            System.out.print("Enter your address: ");
	            String address = scanner.nextLine();

	            // Create and save the customer
	            Customer customer = new Customer();
	            customer.setName(name);
	            customer.setEmail(email);
	            customer.setPhone(phone);
	            customer.setAddress(address);
	            session.save(customer);

	            System.out.println("Customer registered successfully!");
	            System.out.println("\nSelect a theatre:");
	            List<Theatre> theatres = session.createQuery("from Theatre", Theatre.class).getResultList();
	            for (int i = 0; i < theatres.size(); i++) {
	                System.out.println((i + 1) + ". " + theatres.get(i).getTheatreName() + " - " + theatres.get(i).getLocation());
	            }
	            int theatreChoice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            // Check if the choice is valid
	            if (theatreChoice < 1 || theatreChoice > theatres.size()) {
	                System.out.println("Invalid choice. Exiting...");
	                return;
	            }

	            Theatre selectedTheatre = theatres.get(theatreChoice - 1);

	            // Step 3: Display movies in the selected theatre
	            System.out.println("\nSelect a movie from " + selectedTheatre.getTheatreName() + ":");
	            List<Movie> movies = selectedTheatre.getMovies();
	            for (int i = 0; i < movies.size(); i++) {
	                System.out.println((i + 1) + ". " + movies.get(i).getMovieName());
	            }
	            int movieChoice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            // Check if the choice is valid
	            if (movieChoice < 1 || movieChoice > movies.size()) {
	                System.out.println("Invalid choice. Exiting...");
	                return;
	            }

	            Movie selectedMovie = movies.get(movieChoice-1);

	            // Step 4: Display available seats for the selected movie
	            System.out.println("\nSelect a seat for " + selectedMovie.getMovieName() + ":");
	       
	            String hql = "FROM Seat s WHERE s.movie.movieId = :movieId";
	            Query query = session.createQuery(hql, Seat.class);
	            query.setParameter("movieId", selectedMovie.getMovieId());  // For Magadheera, movie_id is 9

	            List<Seat> seats = query.getResultList(); 
	           List<Seat> availableSeats  = query.getResultList();
	           for (int i = 0; i < availableSeats.size(); i++) {
	               Seat seat = availableSeats.get(i);
	             if(seat.getPrice()==200) {  
	               System.out.println((i + 1) + ". Seat " + seat.getSeatNumber() + " - Status: " + seat.getStatus() + " - Price: " + seat.getPrice()+" : Lower-class");
	           }
	             else
	            	 {
		               System.out.println((i + 1) + ". Seat " + seat.getSeatNumber() + " - Status: " + seat.getStatus() + " - Price: " + seat.getPrice()+" : Balcony ");
	            	 }
	            	 }
	            int seatChoice = scanner.nextInt();
	            
	            scanner.nextLine(); // Consume newline

	            // Check if the choice is valid
	            if (seatChoice < 1 || seatChoice > availableSeats.size()) {
	                System.out.println("Invalid choice. Exiting...");
	                return;
	            }

	            Seat selectedSeat = availableSeats.get(seatChoice - 1);

	            // Step 5: Create the booking
	            Booking booking = new Booking();
	            booking.setCustomer(customer);
	            booking.setSeat(selectedSeat);
	            
	            session.save(booking);

	            // Mark the seat as booked
	            selectedSeat.setStatus("booked");
	            session.update(selectedSeat);
	           
	            System.out.println("Booking created successfully!");

	            // Step 6: Process the payment
	            System.out.println("\nEnter payment method (1 for online / 2 for offline): ");
	            String paymentMethod = scanner.nextLine();
	            if ("1".equals(paymentMethod)) {
	                paymentMethod = "online";
	            } else {
	                paymentMethod = "offline";
	            }

	            double amount =selectedSeat.getPrice() ;

	            // Step 7: Create payment record
	            Payment payment = new Payment();
	            booking.setSeat(selectedSeat);
	            payment.setBooking(booking);
	            payment.setAmount(amount);
	            payment.setPaymentMethod(paymentMethod);
	           payment.setPaymentId(1);
	           session.save(payment);
	        		   payment.setTheatreId(selectedTheatre.getTheatreId());
	            System.out.println("Pay the ticket money--"+selectedSeat.getPrice());
	            int money=scanner.nextInt();
	            
	            System.out.println("Ticket details are....");
	System.err.println("===========================================================");
	            System.out.println("Payment successful! Your booking is confirmed.");
	           
	            System.out.println("Customer name---"+customer.getName());
	            System.out.println("Mobile number----"+customer.getPhone());
	            System.out.println("Theatre Name"+selectedTheatre.getTheatreName());

	            System.out.println("Movie Name---"+selectedMovie.getMovieName()+"||movie price"+selectedSeat.getPrice());
	            if(selectedSeat.getPrice()>=200)
	            {
	            	
	            	 type="Upper-Class";
	            }
	            else
	            {
	            	 type="lower-class";
	            }
	            System.out.println("type is---"+type+" ticket");
	           
	            System.err.println("=========================================");
	            session.getTransaction().commit();
	        }
	    }
	        