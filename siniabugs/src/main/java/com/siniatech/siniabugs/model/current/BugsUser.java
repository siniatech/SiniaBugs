package com.siniatech.siniabugs.model.current;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.siniatech.siniabugs.model.api.IBugsUser;

@Entity
@Table(name = "BUGS_USER")
public class BugsUser extends ModelObject implements IBugsUser {

    private Long id;
    private Long uid;
    private String firstName;
    private String surname;
    private DateTime start;
    private DateTime end;
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

    @GeneratedValue
    @Column(name = "uid")
    public Long getUid() {
        return uid;
    }

    public void setUid( Long uid ) {
        this.uid = uid;
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
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getVersionStart() {
        return start;
    }

    public void setVersionStart( DateTime start ) {
        this.start = start;
    }

    @Column(name = "end")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getVersionEnd() {
        return end;
    }

    public void setVersionEnd( DateTime end ) {
        this.end = end;
    }

    @Override
    @OneToOne
    @JoinColumn(name = "created_by_id")
    public BugsUser getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy( BugsUser createdBy ) {
        this.createdBy = createdBy;
    }

    @Override
    @OneToOne
    @JoinColumn(name = "edited_by_id")
    public BugsUser getEditedBy() {
        return editedBy;
    }

    @Override
    public void setEditedBy( BugsUser editedBy ) {
        this.editedBy = editedBy;
    }

    @Transient
    public boolean isHistorical() {
        return false;
    }

    
    @Transient
    public String getName() {
        return String.format( "%s %s", firstName, surname );
    }

}
