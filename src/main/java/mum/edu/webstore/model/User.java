
package mum.edu.webstore.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends Model {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
    private String password;
    private String passwordConfirm;
    @ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="user_role",
         joinColumns=
         @JoinColumn(name="user_id"),
         inverseJoinColumns=
         @JoinColumn(name="role_id")
    )
    private Set<Role> roles;
    @OneToOne(mappedBy = "user")
    private Customer customer;
    //region -Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	//endregion
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String json = "{Id:"+this.getId()+
						",CreatedTime:"+this.getUpdatedTime()+
						",UserName:"+this.getUsername()+
						",Customer:"+this.getCustomer()+
						"}";
		return json;
	}
}

