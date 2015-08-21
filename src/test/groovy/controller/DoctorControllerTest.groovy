package br.kesehatan.controller

import br.kesehatan.KesehatanApp
import br.kesehatan.entity.Doctor
import com.google.gson.Gson
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
/**
 *
 */
@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = KesehatanApp)
@WebAppConfiguration
public class DoctorControllerTest {

    def MockMvc mockMvc

    def HttpMessageConverter mappingJackson2HttpMessageConverter

    @Autowired
    def WebApplicationContext webApplicationContext

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build()
    }

    @Test
    public void "Should find all doctors"() throws Exception {
        mockMvc.perform(get("/doctors")).andExpect(status().isOk())
    }

    @Test
    public void "Should add a doctor"() throws Exception {
        mockMvc.perform(post("/doctors")
                .contentType("application/json")
                .content(new Gson().toJson(new Doctor(name: "Lennon Jesus", street: "Av. das Palmeiras", streetNo: 1290)))
        ).andExpect(status().isOk())
    }

    @Test
    public void "Should not add a doctor without name"() {
        mockMvc.perform(post("/doctors")
                .contentType("application/json")
                .content(new Gson().toJson(new Doctor(name: null, street: "Av. das Palmeiras", streetNo: 1290)))
        ).andExpect(status().isBadRequest())
    }

    @Test
    public void "Should not add a doctor without street"() {
        mockMvc.perform(post("/doctors")
                .contentType("application/json")
                .content(new Gson().toJson(new Doctor(name: "Lennon Jesus", street: null, streetNo: 1290)))
        ).andExpect(status().isBadRequest())
    }

}