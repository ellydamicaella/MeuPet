package br.com.start.meupet.agendamento.model;

import br.com.start.meupet.agendamento.enums.AnimalSexo;
import br.com.start.meupet.agendamento.enums.AnimalType;
import br.com.start.meupet.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String age;

    private String history;

//    @Enumerated(EnumType.STRING)
//    private AnimalPorte porte;

    @Enumerated(EnumType.STRING)
    private AnimalType type;

    @Enumerated(EnumType.STRING)
    private AnimalSexo sexo;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private User owner;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AtendimentoMarcado> atendimentosMarcados;

    public Animal() {
    }

    public Animal(String name, String age, String history, AnimalType type, AnimalSexo sexo, User owner) {
        this.name = name;
        this.age = age;
        this.history = history;
        this.type = type;
        this.sexo = sexo;
        this.owner = owner;
    }
}
