package com.example.Journal.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
public class User
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column( unique = true)
    private String username;

    @Column
    private String mobileNumber;

    @Column
    private String password;

    @Column( unique=true)
    private String email;

    @ManyToMany()
    private List<Privilege> privileges;

    public User(String username, String mobileNumber, String password, String email, List<Privilege> privileges) {
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.email = email;
        this.privileges = privileges;
    }
}
