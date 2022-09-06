package com.galvanize.demo.Dogs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class DogsTest {
    @Autowired
    MockMvc mvc;

    @Test
    void getDog() throws Exception{

        this.mvc.perform(get("/dog?name=Bella&color=multi"))
                .andExpect(status().isOk())
                .andExpect(content().string("Name: Bella\nColor: multi"));
        this.mvc.perform(get("/dog?name=Watney&color=black"))
                .andExpect(status().isOk())
                .andExpect(content().string("Name: Watney\nColor: black"));
        this.mvc.perform(get("/dog?name=Rio"))
                .andExpect(status().isOk())
                .andExpect(content().string("Name: Rio\nColor: translucent"));
    }
    @Test
    void getDogs() throws Exception {

        this.mvc.perform(get("/dogs?name=Bella&color=multi"))
                .andExpect(status().isOk())
                .andExpect(content().string("Name: Bella\nColor: multi"));
        this.mvc.perform(get("/dogs?name=Watney&color=black"))
                .andExpect(status().isOk())
                .andExpect(content().string("Name: Watney\nColor: black"));
        this.mvc.perform(get("/dogs?name=Rio"))
                .andExpect(status().isOk())
                .andExpect(content().string("Name: Rio\nColor: null"));
    }
    @Test
    void getDoggy() throws Exception {

        this.mvc.perform(get("/doggy?name=Bella&color=multi"))
                .andExpect(status().isOk())
                .andExpect(content().string("Name: Bella\nColor: multi"));
        this.mvc.perform(get("/doggy?name=Watney&color=black"))
                .andExpect(status().isOk())
                .andExpect(content().string("Name: Watney\nColor: black"));
        this.mvc.perform(get("/doggy?name=Rio"))
                .andExpect(status().isOk())
                .andExpect(content().string("Name: Rio\nColor: null"));
    }
    @Test
    void getDogID() throws Exception {

        this.mvc.perform(get("/dog/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("ID: 1"));
    }
}
