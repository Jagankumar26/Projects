package onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem;
import onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem.Movies;


import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Theatres")
public class Theatres 
{
	@Id
    @GeneratedValue(strategy = GenerationType.UUID) // Automatically generate unique IDs
    private String theatreId;

    @Column(name = "Movie_Name", length = 300, nullable = false, unique = true)
    private String theatreName;

    @Column(nullable = false)
    private int seatingCapacity;

    @Column(nullable = false)
    private String theatreLocation;
    
    @Column(nullable = false)
    private int noOfScreens;
    /*-----------------------Theatre Movie Relation------------------------*/
    @OneToMany(mappedBy = "theatre")  //ownerID fk
    private List<Movies> movies = new ArrayList<>();
    /*------------------------Theatre Owner Relation---------------------------------*/
    @OneToOne
    private OwnerUser owner;
    /*------------------------Theatre AdminRelation---------------------------------*/
    @OneToOne
    private AdminUser admin;
    /*------------------------Theatre Shows Relation---------------------------------*/
    @OneToMany
    private List<Shows> shows = new ArrayList<>();
    /*------------------------------------------------------------------*/
    public Theatres(String theatreId, String theatreName, int seatingCapacity, String theatreLocation, int noOfScreens,
			List<Movies> movies, OwnerUser owner, AdminUser admin, List<Shows> shows) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.seatingCapacity = seatingCapacity;
		this.theatreLocation = theatreLocation;
		this.noOfScreens = noOfScreens;
		this.movies = movies;
		this.owner = owner;
		this.admin = admin;
		this.shows = shows;
	}
    
	public Theatres() 
	{
		super();
	}

	public String getTheatreId() {return theatreId;}
	public void setTheatreId(String theatreId) {this.theatreId = theatreId;}
	
	public List<Movies> getMovies() {return movies;}
	public void setMovies(List<Movies> movies) {this.movies = movies;}
	
	public OwnerUser getOwner() {return owner;}
	public void setOwner(OwnerUser owner) {this.owner = owner;}
	
	public AdminUser getAdmin() {return admin;}
	public void setAdmin(AdminUser admin) {this.admin = admin;}
	
	public String getTheatreName() {return theatreName;}
	public void setTheatreName(String theatreName) {this.theatreName = theatreName;}
	
	public int getSeatingCapacity() {return seatingCapacity;}
	public void setSeatingCapacity(int seatingCapacity) {this.seatingCapacity = seatingCapacity;}
	
	public String getTheatreLocation() {return theatreLocation;}
	public void setTheatreLocation(String theatreLocation) {this.theatreLocation = theatreLocation;}
	
	public int getNoOfScreens() {return noOfScreens;}
	public void setNoOfScreens(int noOfScreens) {this.noOfScreens = noOfScreens;}
	
	public List<Shows> getShows() {return shows;}
	public void setShows(List<Shows> shows) {this.shows = shows;}

	@Override
	public String toString() 
	{
		return "Theatres [theatreId=" + theatreId + ", theatreName=" + theatreName + ", seatingCapacity="
				+ seatingCapacity + ", theatreLocation=" + theatreLocation + ", noOfScreens=" + noOfScreens
				+ ", movies=" + movies + ", owner=" + owner + ", admin=" + admin + ", shows=" + shows + "]";
	}		 
}

