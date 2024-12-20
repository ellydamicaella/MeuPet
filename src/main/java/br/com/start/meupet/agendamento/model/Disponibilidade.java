package br.com.start.meupet.agendamento.model;

import br.com.start.meupet.partner.model.Partner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table
@Getter
@Setter
public class Disponibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_partner", nullable = false)
    @JsonIgnore
    private Partner partner;

//    @Enumerated(EnumType.STRING)
//    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    @Override
    public String toString() {
        return "Disponibilidade{" +
                "startTime=" + startTime.toString() +
                ", endTime=" + endTime.toString() +
                '}';
    }
}
