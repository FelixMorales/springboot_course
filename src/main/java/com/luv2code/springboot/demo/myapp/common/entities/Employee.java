package com.luv2code.springboot.demo.myapp.common.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="employee")
public class Employee  extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Employee() { }

    public Employee(String firstName, String lastname, String email) {
        this.firstName = firstName;
        lastName = lastname;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long _id) {
        this.id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String _firstName) {
        this.firstName = _firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String _lastName) {
        this.lastName = _lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        Employee employee = ( Employee ) o;
        return Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(email);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Employee{" );
        sb.append( "_id=" ).append(id);
        sb.append( ", _firstName='" ).append(firstName).append( '\'' );
        sb.append( ", _lastName='" ).append(lastName).append( '\'' );
        sb.append( ", _email='" ).append(email).append( '\'' );
        sb.append( '}' );
        return sb.toString();
    }
}
