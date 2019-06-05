package com.guleni.project.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "code",unique = true)
    private String code;
    @Column(name = "name")
    private String name;

   /*
   ------------------------------------------> burada daha sonra işlemler yapabiliriz
    @JoinColumn(name = "joined_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<User> users;
    @JoinColumn(name = "assigned_issue_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issues;*/
    @JoinColumn(name="joined_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User manager;






}
