package com.galvanize.demo.Math;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
public class TestMath {

    @Autowired
    MockMvc mvc;

    @Test
    public void servePiTest() throws Exception {
        this.mvc.perform(get("/math/pi"))
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
    public void testSUm() throws Exception{
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6"))
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }
}
