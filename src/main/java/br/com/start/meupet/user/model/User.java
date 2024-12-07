package br.com.start.meupet.user.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import br.com.start.meupet.common.interfaces.Authenticable;
import br.com.start.meupet.common.valueobjects.Email;
import br.com.start.meupet.common.valueobjects.PersonalRegistration;
import br.com.start.meupet.common.valueobjects.PhoneNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Cacheable
@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
public class User implements Authenticable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private String name;

    private String socialName;

    @NotNull
    @Embedded
    private Email email;

    @NotNull
    private String password;

    @NotNull
    @Embedded
    @Column(name = "phone_number")
    private PhoneNumber phoneNumber;

    private PersonalRegistration personalRegistration;

    private LocalDate dateOfBirth;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "moeda_capiba")
    private int moedaCapiba;

    public User(
            String name,
            String socialName,
            Email email,
            String password,
            PhoneNumber phoneNumber,
            PersonalRegistration personalRegistration,
            LocalDate dateOfBirth
    ) {
        this.name = name;
        this.socialName = socialName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.personalRegistration = personalRegistration;
        this.dateOfBirth = dateOfBirth;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", socialName='" + socialName + '\'' +
                ", email=" + email +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", document=" + personalRegistration.getDocument() +
                ", documentType=" + personalRegistration.getType().toString() +
                ", dateOfBirth=" + dateOfBirth +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", moedaCapiba=" + moedaCapiba +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Authenticable user)) return false;
        return Objects.equals(id, user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phoneNumber, personalRegistration);
    }
}
