package onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem;
import onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem.Movies;
import onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem.Theatres;


import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "Owners")
public class OwnerUser extends User
{
	@Column(nullable = false)
	private String purchaseDigitalRights;
	/*-------------------------Owner Theatre Relation--------------------------------*/
    @OneToOne
    private Theatres theatre; /* */
    /*----------------------------------------------------------*/
    public OwnerUser(String userName, String roleName, String userMobileNumber, String userE_Mail, String userPassword,
			String purchaseDigitalRights, Theatres theatre) 
    {
		super(userName, roleName, userMobileNumber, userE_Mail, userPassword);
		this.purchaseDigitalRights = purchaseDigitalRights;
		this.theatre = theatre;
	}
	/*--------------------------------------Default and Parameterized Constructor------------------------------------------------*/
	public OwnerUser() 
	{
		super();
	}
	public OwnerUser(String userName, String roleName, String userMobileNumber, String userE_Mail,String userPassword) 
	{
		super(userName, roleName, userMobileNumber, userE_Mail, userPassword);
	}
	/*-----------------------------------------Getter and Setters---------------------------------------------*/
	public String getPurchaseDigitalRights() {return purchaseDigitalRights;}
	public void setPurchaseDigitalRights(String purchaseDigitalRights) {this.purchaseDigitalRights = purchaseDigitalRights;}
	
	public Theatres getTheatre() {return theatre;}
	public void setTheatre(Theatres theatre) {this.theatre = theatre;}
	/*---------------------------------------------To String---------------------------------------------------------*/
	@Override
	public String toString() 
	{
		return "OwnerUser purchase Digital Rights: " + purchaseDigitalRights + ", theatre=" + theatre + ", getUserId()="
				+ getUserId() + ", getUserName()=" + getUserName() + ", getUserMobileNumber()=" + getUserMobileNumber()
				+ ", getUserE_Mail()=" + getUserE_Mail() + ", getUserPassword()=" + getUserPassword()
				+ ", getCreatedAt()=" + getCreatedAt() + ", getUpdatedAt()=" + getUpdatedAt();
	}	
}
