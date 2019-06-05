package com.guleni.project.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)

    private List<Issue> issueList;
    @JoinColumn(name = "joined_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Project>  managed;


}
