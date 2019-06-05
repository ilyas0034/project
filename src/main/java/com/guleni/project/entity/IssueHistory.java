package com.guleni.project.entity;

import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "issue_history")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class IssueHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Issue issue;
    @JoinColumn(name = "assigne_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User assigne;


}
