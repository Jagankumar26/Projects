package Online_Movie_TicketBooking_System;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private int seatId;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @Column
    private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	

	public int getSeatId() {
		return seatId;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatNumber=" + seatNumber + ", status=" + status + ", movie=" + movie
				+ ", price=" + price + "]";
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

    // Getters and setters...
}