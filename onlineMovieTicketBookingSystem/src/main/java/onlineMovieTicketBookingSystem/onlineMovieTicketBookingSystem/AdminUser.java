package onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem;



import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "Admins") //Specifying 2nd Table name / Child class
public class AdminUser extends User 
{
	/*-------------------------------Admin Theatre 1:1 Relation------------------------------------*/
	@OneToOne
	private Theatres theatres;
	
	/*------------------------------------------------------Full constructor with Parametrers--------------------------------------------------------------*/ 
    public AdminUser(String userName, String roleName, String userMobileNumber, String userE_Mail, String userPassword,String addMovies, String manageTheatres) 
    {
        super(userName, roleName, userMobileNumber, userE_Mail, userPassword); // Call the parent class constructor
    }
	/*------------------------------------------------------ Default constructor-----------------------------------------------------*/
    public AdminUser() 
    {
        super(); // Call the no-argument constructor of the parent class
    }
    /*-----------------------------------------------------------Parameterised constructor----------------------------------------------------------------------*/
	public AdminUser(String userName, String roleName, String userMobileNumber, String userE_Mail,String userPassword) 
	{
		super(userName, roleName, userMobileNumber, userE_Mail, userPassword);	
	}
	/*-------------------------------------------------------Getter and Setters-----------------------------------------------------------*/
	public Theatres getTheatres() {return theatres;}
	public void setTheatres(Theatres theatres) {this.theatres = theatres;}
	/*------------------------------------------------*/
	@Override
	public String toString() 
	{
		return "AdminUser [theatres=" + theatres + ", getUserId()=" + getUserId() + ", getUserName()=" + getUserName()
				+ ", getUserMobileNumber()=" + getUserMobileNumber() + ", getUserE_Mail()=" + getUserE_Mail()
				+ ", getUserPassword()=" + getUserPassword() + ", getCreatedAt()=" + getCreatedAt()
				+ ", getUpdatedAt()=" + getUpdatedAt();
	}
	
	
}
