package com.example.restaurant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void loadMainPage() throws Exception {
        mockMvc.perform(get("/")).andDo(print()).andExpect(status().is2xxSuccessful()); }
    @Test
    public void TryEditUser() throws Exception {
        mockMvc.perform(post("/admin/user/edit")).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
