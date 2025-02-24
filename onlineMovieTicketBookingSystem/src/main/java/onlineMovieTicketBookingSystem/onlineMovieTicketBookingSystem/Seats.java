package onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem;



import jakarta.persistence.*;

@Entity
@Table(name = "Seats")
public class Seats 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY ) //Starting from 1 to 200...
	private int  seatID ;
	
	@Column(nullable = false)
    private String seatNumber; // Example: A1, A2, etc.

    @Column(nullable = false)
    private boolean isBooked = false;
    
    public Seats() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSeatID() {
		return seatID;
	}

	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}

	@Override
	public String toString() {
		return "Seats [seatID=" + seatID + ", seatNumber=" + seatNumber + ", isBooked=" + isBooked + "]";
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public Seats(int seatID, String seatNumber, boolean isBooked) {
		super();
		this.seatID = seatID;
		this.seatNumber = seatNumber;
		this.isBooked = isBooked;
	}

}
