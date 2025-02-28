package Online_Movie_TicketBooking_System;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.persistence.Query;

public class Exm {
public static void main(String[] args) {
	  SessionFactory sf=	HibernetUtills.getconn();
      Session session = sf.openSession();
      Scanner scanner = new Scanner(System.in);
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

      Movie selectedMovie = movies.get(movieChoice - 1);

      // Step 4: Display available seats for the selected movie
      System.out.println("\nSelect a seat for " + selectedMovie.getMovieName() + ":");
//      List<Seat> availableSeats = selectedMovie.getSeats();
//      for (int i = 0; i < availableSeats.size(); i++) {
//          Seat seat = availableSeats.get(i);
//          
//          // Only show available seats
//          if (seat.getStatus().equals("available")) {
//              System.out.println((i + 1) + ". Seat " + seat.getSeatNumber() + " - Status: " + seat.getStatus() + " - Price: " + seat.getPrice());
//          }
//      }
   // Example assuming you are getting a list of seats for movie_id 9 (Magadheera):
      String hql = "FROM Seat s WHERE s.movie.movieId = :movieId";
      Query query = session.createQuery(hql, Seat.class);
      query.setParameter("movieId",selectedMovie.getMovieId() );  // For Magadheera, movie_id is 9

      List<Seat> seats = query.getResultList(); 
     List<Seat> availableSeats  = query.getResultList();
     for (int i = 0; i < availableSeats.size(); i++) {
         Seat seat = availableSeats.get(i);
         
         System.out.println((i + 1) + ". Seat " + seat.getSeatNumber() + " - Status: " + seat.getStatus() + " - Price: " + seat.getPrice());
     }
}
}
