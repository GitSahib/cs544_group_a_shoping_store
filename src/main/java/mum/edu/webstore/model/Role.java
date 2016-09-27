package mum.edu.webstore.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends Model {
    private String name;
    @ManyToMany(mappedBy="roles",fetch=FetchType.EAGER)
    private Set<User> users;
    //region Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    //endregion
  	@Override
  	public String toString() {
  		// TODO Auto-generated method stub
  		String json = "{Id:"+this.getId()+
  						",CreatedTime:"+this.getUpdatedTime()+
  						",Name:"+this.getName()+
  						"}";
  		return json;
  	}
}
