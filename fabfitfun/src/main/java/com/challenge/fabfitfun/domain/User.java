/**
 * 
 */
package com.challenge.fabfitfun.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Ali Sohaib Malik
 * 
 *
 */
@Entity
@Data
@Table(name="USER")
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private String role; 	//Value can be user or admin

}
