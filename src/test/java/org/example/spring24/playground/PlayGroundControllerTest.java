package org.example.spring24.playground;

import org.example.spring24.security.Security;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = PlayGroundController.class)
@AutoConfigureMockMvc(addFilters = false)  //Disable security
//@EnableMethodSecurity
class PlayGroundControllerTest {

    @MockBean
    PlaygroundService playgroundService;

    @Autowired
    private MockMvc mvc;

    @Test
    //@WithMockUser(username = "User", roles = "ADMIN")
    void getAllPlaygrounds() throws Exception {
        mvc.perform(get("/api/playgrounds"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
    }
}
