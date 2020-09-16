package com.lambdaschool.shoppingcart.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserRolesId implements Serializable
{
    private long user;
    private long role;

    public UserRolesId()
    {
    }

    public long getUser()
    {
        return user;
    }

    public void setUser(long user)
    {
        this.user = user;
    }

    public long getRole()
    {
        return role;
    }

    public void setRole(long role)
    {
        this.role = role;
    }

    @Override
    public int hashCode()
    {
        return 34;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        UserRolesId that = (UserRolesId) obj;
        return user == that.user &&
            role == that.role;
    }
}
