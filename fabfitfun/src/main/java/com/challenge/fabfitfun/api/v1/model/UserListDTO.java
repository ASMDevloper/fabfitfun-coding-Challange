/**
 * 
 */
package com.challenge.fabfitfun.api.v1.model;

import java.util.List;

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
public class UserListDTO 
{
    List<UserDTO> users;

}
