package onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Tickets {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
    private int TicketId;
	 @Column(nullable = false)
    private String movieName;
	 @Column(nullable = false)
    private String movieId; 
	 @Column(nullable = false)
    private String UserId; 
	 @Column(nullable = false)
    private String userName;
	 @Column(nullable = false)
	 private String seatId;
//@OneToOne
//	 private Payment payment;
public int getTicketId() {
	return TicketId;
}
public void setTicketId(int ticketId) {
	TicketId = ticketId;
}
public String getMovieName() {
	return movieName;
}
public void setMovieName(String movieName) {
	this.movieName = movieName;
}
public String getMovieId() {
	return movieId;
}
public void setMovieId(String movieId) {
	this.movieId = movieId;
}
public String getUserId() {
	return UserId;
}
public void setUserId(String userId) {
	UserId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getSeatId() {
	return seatId;
}
public void setSeatId(String seatId) {
	this.seatId = seatId;
}
//public Payment getPayment() {
//	return payment;
//}
//public void setPayment(Payment payment) {
//	this.payment = payment;
//}
public Tickets() {
	super();
	// TODO Auto-generated constructor stub
}
//public Tickets(int ticketId, String movieName, String movieId, String userId, String userName, String seatId,
//		Payment payment) {
//	super();
//	TicketId = ticketId;
//	this.movieName = movieName;
//	this.movieId = movieId;
//	UserId = userId;
//	this.userName = userName;
//	this.seatId = seatId;
//	this.payment = payment;
//}
@Override
public String toString() {
	return "Tickets [TicketId=" + TicketId + ", movieName=" + movieName + ", movieId=" + movieId + ", UserId=" + UserId
			+ ", userName=" + userName + ", seatId=" + seatId + "]";
}

	
}
