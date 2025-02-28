package Online_Movie_TicketBooking_System;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "theatres")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theatre_id")
    private int theatreId;

    @Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", location=" + location
				+ ", movies=" + movies + "]";
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Column(name = "theatre_name")
    private String theatreName;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "theatre")
    private List<Movie> movies;

   
}