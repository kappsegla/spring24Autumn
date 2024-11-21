package org.example.spring24.person;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //Can it be removed when using spring boot 3.4?
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:mysql:latest:///mydatabase"
})
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    void test() {
        var result = personRepository.findAll();
        assertThat(result)
                .anyMatch(person -> person.getId() == 1
                 && "Alice".equals(person.getFirstName()));
    }

    @Test
    void updateFirstNameForPersonWithId1() {
        personRepository.updateFirstName(1, "TEST");

        var result = personRepository.findById(1).orElseThrow();
        assertThat(result.getFirstName()).isEqualTo("TEST");
    }

}
