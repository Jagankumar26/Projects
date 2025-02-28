package Online_Movie_TicketBooking_System;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "genre")
    private String genre;

    @Column(name = "duration")
    private int duration;

    @Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", genre=" + genre + ", duration=" + duration
				+ ", releaseDate=" + releaseDate + ", theatre=" + theatre + ", seats=" + seats + "]";
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	@Column(name = "release_date")
    private String releaseDate;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @OneToMany(mappedBy = "movie")
    private List<Seat> seats;

    // Getters and setters...
}