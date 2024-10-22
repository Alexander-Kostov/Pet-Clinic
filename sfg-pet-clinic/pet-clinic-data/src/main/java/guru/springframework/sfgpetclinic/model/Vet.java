package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vets")
public class Vet extends Person{
    @ManyToMany
    @JoinTable(name = "vet_specialties",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Speciality> specialties = new HashSet<>();

}
