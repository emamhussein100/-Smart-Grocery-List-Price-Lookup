package org.example.smartgrocery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.smartgrocery.util.Role;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AddUserDto {
    private String username;
    private String email;
    private String password;
    private Role role;
}
