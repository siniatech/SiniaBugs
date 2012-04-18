package com.siniatech.siniabugs.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BUGS_USER")
public class BugsUser {

    private Long id;
    private String firstName;
    private String surname;
    private Date start;
    private Date end;
    private BugsUser createdBy;
    private BugsUser editedBy;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname( String surname ) {
        this.surname = surname;
    }

    @Column(name = "start")
    public Date getStart() {
        return start;
    }

    public void setStart( Date start ) {
        this.start = start;
    }

    @Column(name = "end")
    public Date getEnd() {
        return end;
    }

    public void setEnd( Date end ) {
        this.end = end;
    }

    @OneToOne
    @JoinColumn(name = "created_by_id")
    public BugsUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy( BugsUser createdBy ) {
        this.createdBy = createdBy;
    }

    @OneToOne
    @JoinColumn(name = "edited_by_id")
    public BugsUser getEditedBy() {
        return editedBy;
    }

    public void setEditedBy( BugsUser editedBy ) {
        this.editedBy = editedBy;
    }

}
