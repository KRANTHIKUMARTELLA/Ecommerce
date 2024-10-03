package com.ecommerce.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users   {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String picture;
    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;



    public Users (String username, String password, Set<Role> roles,
                  String email,String phone,String picture,String address)
    {
        this.username=username;
        this.password=password;
        this.email=email;
        this.phone=phone;
        this.picture=picture;
        this.address=address;
        this.roles=roles;
    }

  }





