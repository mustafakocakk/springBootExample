package com.base.issueManagement.entity;


import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Project extends Serializers.Base {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private  Long id;

    @Column(name="projectCode",length = 100,unique = true)
    private String projectCode;

    @Column(name="projectName",length = 100,unique = true)
    private  String projectName;

    @JoinColumn(columnDefinition = "manager_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User manager;


}
