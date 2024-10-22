package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAllTest() {
        Set<Owner> all = ownerServiceMap.findAll();

        assertEquals(1, all.size());
    }

    @Test
    void saveExistingIdTest() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner2 = ownerServiceMap.save(owner2);

        assertEquals(id, savedOwner2.getId());
    }

    @Test
    void saveNonExistingIdTest() {
        Owner owner = Owner.builder().build();

        Owner save = ownerServiceMap.save(owner);
        assertNotNull(save);
        assertNotNull(save.getId());
    }


    @Test
    void deleteTest() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteByIdTest() {
        ownerServiceMap.deleteById(ownerId);

        assertEquals(0, ownerServiceMap.findAll().size());

    }

    @Test
    void findById() {
        Owner byId = ownerServiceMap.findById(ownerId);
        long id = 1;
        assertEquals(id, byId.getId().longValue());
    }

    @Test
    void findByLastName() {
        Owner byLastName = ownerServiceMap.findByLastName(lastName);
        assertNotNull(byLastName);
        assertEquals(ownerId, byLastName.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner byLastName = ownerServiceMap.findByLastName("foo");
        assertNull(byLastName);
    }
}