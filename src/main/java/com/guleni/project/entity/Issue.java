package com.guleni.project.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issue")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Issue extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;
    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User assiggne;
    @JoinColumn(name = "assigned_project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Project assigneed;


}
