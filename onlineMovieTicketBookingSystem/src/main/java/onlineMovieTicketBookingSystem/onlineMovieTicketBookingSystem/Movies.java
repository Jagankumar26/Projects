package onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem;


import jakarta.persistence.*;
import java.util.*;
import java.time.*;


@Entity
@Table(name = "Movies_List")
public class Movies 
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Automatically generate unique IDs
    private String movieId;

    @Column(name = "Movie_Name", length = 300, nullable = false, unique = true)
    private String movieName;

    @Column(nullable = false)
    private String movieLanguage;

    @Column(nullable = false)
    private Duration movieDuration;

    @Column(nullable = false)
    private String movieGenre;

//    @Column(nullable = false) //FK rating 
//    private double movieRating; // Assuming ratings are numeric

    @Column(nullable = false)
    private String movieReleaseDate; //Automatic date created while adding movie release date

    @Column(nullable = false)
    //
    private String movieCategory;
    /*-----------------------Movie Theatre M:1 Relation------------------------*/
    @ManyToOne
    private Theatres theatre ;
    /*-----------------------Movie Shows 1:M Relation------------------------*/
    @OneToMany(mappedBy = "movies") // Bidirectional
    private List<Shows> shows = new ArrayList<>();
    /*--------------------------------------------------------*/
    public Movies(String movieId, String movieName, String movieLanguage, Duration movieDuration, String movieGenre,
			String movieReleaseDate, String movieCategory, Theatres theatre, List<Shows> shows) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.movieDuration = movieDuration;
		this.movieGenre = movieGenre;
		this.movieReleaseDate = movieReleaseDate;
		this.movieCategory = movieCategory;
		this.theatre = theatre;
		this.shows = shows;
	}
    /*-------------------------------------------------------------------------------------------------------*/
	public Movies() 
	{
		super();
	}
	// Getter and Setter method
    public String getMovieId() { return movieId; }
	public void setMovieId(String movieId) { this.movieId = movieId; }
	
	public Theatres getTheatre() {return theatre;}
	public void setTheatre(Theatres theatre) {this.theatre = theatre;} //

    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public String getMovieLanguage() { return movieLanguage; }
    public void setMovieLanguage(String movieLanguage) { this.movieLanguage = movieLanguage; }

    public Duration getMovieDuration() { return movieDuration; }
    public void setMovieDuration(Duration movieDuration) { this.movieDuration = movieDuration; }

    public String getMovieGenre() { return movieGenre; }
    public void setMovieGenre(String movieGenre) { this.movieGenre = movieGenre; }
//    public double getMovieRating() { return movieRating; }
//    public void setMovieRating(double movieRating) { this.movieRating = movieRating; }

    public String getMovieReleaseDate() { return movieReleaseDate; }
    public void setMovieReleaseDate(String movieReleaseDate) { this.movieReleaseDate = movieReleaseDate; }

    public String getMovieCategory() { return movieCategory; }
    public void setMovieCategory(String movieCategory) { this.movieCategory = movieCategory; }
    
	public List<Shows> getShows() {return shows;}
	public void setShows(List<Shows> shows) {this.shows = shows;}
	
	@Override
	public String toString() 
	{
		return "Movies [movieId=" + movieId + ", movieName=" + movieName + ", movieLanguage=" + movieLanguage
				+ ", movieDuration=" + movieDuration + ", movieGenre=" + movieGenre + ", movieReleaseDate="
				+ movieReleaseDate + ", movieCategory=" + movieCategory + ", theatre=" + theatre + ", shows=" + shows
				+ "]";
	}	
}
