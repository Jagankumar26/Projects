package onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem;

import onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem.Movies;
import onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem.Theatres;
import onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem.OwnerUser;
import jakarta.persistence.*;

@Entity
@Table(name = "Shows")
public class Shows 
{
	@Id
    @GeneratedValue(strategy = GenerationType.UUID) // Automatically generate unique IDs
    private String showId; // UUID for unique show identification
	
	@Column(nullable = false)
	private String showName;
	
	@Column(nullable = false)
	private String showTime;
	
	@Column(nullable = false)
	private String userShowBookingDate;
	/*-------------------------Shows Movies Relation----------------------------*/
	@ManyToOne  // fk ? list in Movies entity or just 1st show 2nd show matnee??
    private Movies movies;
	/*-----------------------------Shows Theatre Relation------------------------*/
	@ManyToOne // FK to Theatres 
    private Theatres theatre; //Theatre_ID relation
	/*-----------------------------Shows Admin M:1 Relation------------------------*/
	@ManyToOne
	private AdminUser adminUser;
	/*-----------------------------------------------------------------------------*/
	public Shows(String showId, String showName, String showTime, String userShowBookingDate, Movies movies,
			Theatres theatre) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.showTime = showTime;
		this.userShowBookingDate = userShowBookingDate;
		this.movies = movies;
		this.theatre = theatre;
	}
	/*----------------------------------------------------------------------------------------*/
	public Shows() 
	{
		super();
	}
	public String getShowId() {return showId;}
	public void setShowId(String showId) {this.showId = showId;}
	
	public String getShowName() {return showName;}
	public void setShowName(String showName) {this.showName = showName;}
	
	public String getShowTime() {return showTime;}
	public void setShowTime(String showTime) {this.showTime = showTime;}
	
	public String getUserShowBookingDate() {return userShowBookingDate;}
	public void setUserShowBookingDate(String userShowBookingDate) {this.userShowBookingDate = userShowBookingDate;}
	
	
	public Theatres getTheatre() {return theatre;}
	public void setTheatre(Theatres theatre) {this.theatre = theatre;}
	/*-------------------------------------------------------------------------------------------*/
	@Override
	public String toString() 
	{
		return "Shows [showId=" + showId + ", showName=" + showName + ", showTime=" + showTime
				+ ", userShowBookingDate=" + userShowBookingDate + ", movies=" + movies + ", theatre=" + theatre + "]";
	}	
}
