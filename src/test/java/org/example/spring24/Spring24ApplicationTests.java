package org.example.spring24;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
@Sql("/testdata.sql")
@ActiveProfiles("test")
@Transactional  //Rolls back any changes to the database after running a test method
class Spring24ApplicationTests {

    //https://docs.spring.io/spring-boot/reference/testing/testcontainers.html

    @Container
    @ServiceConnection
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:latest");

    @Autowired
    MockMvc mockMvc;

    @Test
    void testConnectionIsEstablished() {
        assertTrue(mySQLContainer.isCreated());
        assertTrue(mySQLContainer.isRunning());
    }

    @Test
    public void allPersons() throws Exception {
        mockMvc.perform(get("/persons"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("""
                        [{\"fullName\":\"Alice Smith\",\"socialMedias\":[{\"platform\":{\"platformName\":\"TWITTER\"}}]},{\"fullName\":\"Bob Johnson\",\"socialMedias\":[{\"platform\":{\"platformName\":\"LINKEDIN\"}}]},{\"fullName\":\"Charlie Brown\",\"socialMedias\":[{\"platform\":{\"platformName\":\"FACEBOOK\"}}]}]
                        """));
    }

    @Test
    @Tag("smoke")
    @WithMockUser(authorities = "read:test")
    void callApiTestAsAuthenticatedUser() throws Exception {
        mockMvc.perform(get("/api/test"))
                        //.header("X-API-KEY", "wEWM967DqqC9cBMGpxvr99GM"))
                .andExpect(status().isOk());
    }

}
