package guru.springframework.sfgpetclinic.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "visits")
public class Visit extends BaseEntity{
    @Column(name = "local_date")
    private LocalDate localDate;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
