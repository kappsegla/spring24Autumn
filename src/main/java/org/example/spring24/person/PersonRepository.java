package org.example.spring24.person;

import org.example.spring24.entity.PersonEntity;
import org.example.spring24.person.projection.PersonWithSocialMediaProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;


import java.util.Collection;
import java.util.List;

public interface PersonRepository extends ListCrudRepository<PersonEntity, Integer> {

    @Query("""

            SELECT CONCAT(p.firstName, ' ', p.lastName) AS fullName, sm AS socialMedias
       FROM PersonEntity p
       LEFT JOIN p.socialMedias sm
       """)
    List<PersonWithSocialMediaProjection> findAllPersonsWithSocialMedia();

    @EntityGraph(attributePaths = {"socialMedias"})
    List<PersonWithSocialMediaProjection> findBy(); // For the interface-based projection

    <T> List<T> findBy(Class<T> type);
}
