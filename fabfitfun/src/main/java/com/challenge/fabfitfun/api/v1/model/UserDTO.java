/**
 * 
 */
package com.challenge.fabfitfun.api.v1.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ali Sohaib Malik
 * 
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO 
{
    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    
    private String role; 	//Value can be user or admin
    
    @JsonProperty("user_url")
    private String userUrl;

}
