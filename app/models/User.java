package models;

import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;

/**
 * Created by orlando.sosa on 1/10/2017.
 */

@Entity
public class User extends Model{

    public String email;
    public String password;
    public String fullname;
    public boolean isAdmin;

    public User(String email, String password, String fullname){
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }

    public static User connect(String email, String password){
        return find("byEmailAndPassword", email, password).first();
    }

}
