package onlineMovieTicketBookingSystem.onlineMovieTicketBookingSystem;


import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //
@DiscriminatorColumn(name = "User_Type", discriminatorType = DiscriminatorType.STRING)
public class User {
    /*--------------------------------------------------------Member Variables--------------------------------------------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private String userId; 

    @Column(nullable = false)
    private String userName;
    
    @Column(nullable = false)
    private String roleName; 
    @Column(nullable = false, unique = true, length = 10)
    private String userMobileNumber;
    
    @Column(nullable = false, unique = true, length = 100)
    private String userE_Mail;

    @Column(nullable = false)
    private String userPassword;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; 

   
    @PrePersist
    protected void onCreate() { 
        createdAt = LocalDateTime.now();
    }
   
    public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@PreUpdate
    protected void onUpdate() { 
        updatedAt = LocalDateTime.now();
    }
    /*--------------------------------------------------------Constructors--------------------------------------------------------*/
    public User(String userName,String roleName, String userMobileNumber, String userE_Mail, String userPassword) {
        this.userName = userName;
        this.userMobileNumber = userMobileNumber;
        this.userE_Mail = userE_Mail;
        this.userPassword = userPassword;
        this.roleName = roleName;
    }
    
    public User() 
    {
        super();
    }
    /*--------------------------------------------------------Getter And Setters--------------------------------------------------------*/
    public String getUserId() {return userId;}
	public void setUserId(String userId) {this.userId = userId;}//
    
    public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName; }

    public String getUserMobileNumber() {return userMobileNumber;}
    public void setUserMobileNumber(String userMobileNumber) {this.userMobileNumber = userMobileNumber;}

    public String getUserE_Mail() {return userE_Mail;}
    public void setUserE_Mail(String userE_Mail) {this.userE_Mail = userE_Mail;}

    public String getUserPassword() {return userPassword;}
    public void setUserPassword(String userPassword) {this.userPassword = userPassword;}
    public LocalDateTime getCreatedAt() {return createdAt;}
    
    public LocalDateTime getUpdatedAt() {return updatedAt;}
    /*--------------------------------------------------------toString() Method--------------------------------------------------------*/
    @Override
    public String toString() {
        return "\n User Details: "+
        	   "\n User: " + userId +
               "\n userName: " + userName +
               "\n userMobileNumber: " + userMobileNumber +
               "\n userE_Mail: " + userE_Mail +
               "\n createdAt: " + createdAt +
               "\n updatedAt: " + updatedAt;
    }
}
