package org.example.spring24.person;

import org.example.spring24.entity.PersonEntity;
import org.example.spring24.language.api.LanguageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    PersonRepository personRepository;
    @Mock
    LanguageService languageService;

    @InjectMocks
    PersonService personService;

    @Test
    void allPersonsReturnsListOfPersonDto() {

        setupPersonRepositoryMockForfindAll();

        var result = personService.allPersons();

        assertThat(result).isNotNull().hasSize(2);
    }

    private void setupPersonRepositoryMockForfindAll() {
        PersonEntity person1 = new PersonEntity();
        PersonEntity person2 = new PersonEntity();
        person1.setFirstName("John");
        person1.setLastName("Doe");
        person1.setProgrammer(true);
        person2.setFirstName("Jane");
        person2.setLastName("Doe");
        person2.setProgrammer(false);

        Mockito.when(personRepository.findAll())
                .thenReturn(List.of(person1, person2));
    }

}
