package br.com.start.meupet.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {
    private String name;
    private String socialName;
    private String phoneNumber;
    private String dateOfBirth;
}
