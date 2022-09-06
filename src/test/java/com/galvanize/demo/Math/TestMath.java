package com.galvanize.demo.Math;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class TestMath {

    @Autowired
    MockMvc mvc;

    @Test
    public void servePiTest() throws Exception {
        this.mvc.perform(get("/math/pi"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.14159265358979323846264338327950288419716939937510"));
    }

    @Test
    public void testCalculate() throws Exception{
        this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6"))
                .andExpect(content().string("4 + 6 = 10"));
        this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6"))
                .andExpect(content().string("4 - 6 = -2"));
        this.mvc.perform(get("/math/calculate?operation=multiply&x=4&y=6"))
                .andExpect(content().string("4 * 6 = 24"));
        this.mvc.perform(get("/math/calculate?operation=divide&x=30&y=5"))
                .andExpect(content().string("30 / 5 = 6"));
    }

    @Test
    public void testSum() throws Exception{
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }

    @Test
    public void testVolume() throws Exception{
        this.mvc.perform(post("/math/volume/4/5/6"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 4x5x6 rectangle is 120"));
        this.mvc.perform(post("/math/volume/6/7/8"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 6x7x8 rectangle is 336"));
    }
}
