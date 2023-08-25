package com.lcwd.user.service.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="micro_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long userId;
    //@Column(name="NAME",length = 20)
    private String name;
    //@Column(name="EMAIL")
    private String email;
   // @Column(name="ABOUT")
    private String about;
    //@Transient
    //private List<Rating> userRating = new ArrayList<>();

}
