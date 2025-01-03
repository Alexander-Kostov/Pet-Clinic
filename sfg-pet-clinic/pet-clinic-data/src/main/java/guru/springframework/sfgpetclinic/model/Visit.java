package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
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
    private LocalDate date;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
