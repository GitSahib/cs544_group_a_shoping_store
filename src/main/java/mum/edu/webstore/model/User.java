package mum.edu.webstore.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends Model {
	
    private String username;
    private String password;
    private String passwordConfirm;
    @ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role",
         joinColumns=
         @JoinColumn(name="user_id"),
         inverseJoinColumns=
         @JoinColumn(name="role_id")
    )
    private Set<Role> roles;
    @OneToOne(cascade=CascadeType.ALL)
    private Customer customer;
    
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
}
