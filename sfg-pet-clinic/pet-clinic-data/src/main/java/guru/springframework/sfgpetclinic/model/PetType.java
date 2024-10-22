package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pets")
public class PetType extends BaseEntity{
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
