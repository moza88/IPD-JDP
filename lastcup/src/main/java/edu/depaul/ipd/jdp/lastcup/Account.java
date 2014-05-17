package edu.depaul.ipd.jdp.lastcup;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Generic Account class to demonstrate Java best practice
 * Hello world
 */
public class Account implements Serializable {

    private static final Logger LOG = Logger.getLogger(Account.class.getName());

    public Account() {
    }

    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }
    private int id;
    private String name;
    private Date birthDate;
    private transient int age;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        LOG.entering(Account.class.getCanonicalName(), "equals");

        if (obj == null) {
            LOG.exiting(Account.class.getCanonicalName(), "equals {0}", "Object is null");
            return false;
        }
        if (getClass() != obj.getClass()) {
            LOG.exiting(Account.class.getCanonicalName(), "equals {0}", "Class not same");
            return false;
        }
        final Account other = (Account) obj;
        if (this.id != other.id) {
            LOG.exiting(Account.class.getCanonicalName(), "equals {0}", "id is not the same");
            return false;
        }
        LOG.fine("Now isn't this a fine message?");
        LOG.finer("This is a fine message you got us into");
        LOG.finest("isn't this a finest message of all?");
        LOG.info("account is the same");
        LOG.exiting(Account.class.getCanonicalName(), "equals", "now that is more like it, this is equals");
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
