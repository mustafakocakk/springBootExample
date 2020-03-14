package com.base.issueManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity //veri tabanında ki tabloya denk gelen class entitty anotasyonu  bunu belirtir.
@Table(name = "issue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Issue extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description",length = 400)
    private String description;


    @Column(name = "details",length = 4000)
    private String  details;


    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issueStatus")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY) // bir cok issue clası bir tane usera bağlabilir  anotasyonu
    private User assignee;

    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

}
