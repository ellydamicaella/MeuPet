package br.com.start.meupet.dto;

import br.com.start.meupet.domain.entities.Partner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartnerResponseDTO {

    private UUID id;

    private String name;

    private String email;

    private String personalRegistration;

    private String password;

    private String phoneNumber;

    public PartnerResponseDTO(Partner partner) {
        this.id = partner.getId();
        this.name = partner.getName();
        this.email = partner.getEmail().toString();
        this.personalRegistration = partner.getPersonalRegistration().toString();
        this.password = partner.getPassword();
        this.phoneNumber = partner.getPhoneNumber().toString();
    }
}