package com.mreapps.diceit.engine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "user_role")
public class UserRole implements BaseEntity
{
    @Id
    @Column(name = "uid")
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "role_uid")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "user_uid")
    private User user;

    @Column(name = "valid_from")
    @Temporal(TemporalType.DATE)
    private Date validFrom;

    @Column(name = "valid_to")
    @Temporal(TemporalType.DATE)
    private Date validTo;

    @Override
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Date getValidFrom()
    {
        return validFrom;
    }

    public void setValidFrom(Date validFrom)
    {
        this.validFrom = validFrom;
    }

    public Date getValidTo()
    {
        return validTo;
    }

    public void setValidTo(Date validTo)
    {
        this.validTo = validTo;
    }
}
