package com.galvanize.demo.Math;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest
@SpringBootTest
@AutoConfigureMockMvc
public class TestMath {

    @Autowired
    MockMvc mvc;

    @Test
    public void servePiTest() throws Exception {
        this.mvc.perform(get("/math/pi"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
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
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6&n=7&n=8"))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 + 7 + 8 = 30"));
    }

    @Test
    public void testVolumeRectanglar() throws Exception{
        this.mvc.perform(post("/math/volume/rectangle/4/5/6"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 4x5x6 rectangle is 120"));
        this.mvc.perform(post("/math/volume/rectangle/6/7/8"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 6x7x8 rectangle is 336"));
    }
    @Test
    public void testVolumeCircular() throws Exception{
        this.mvc.perform(post("/math/volume/sphere/3.1"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a radius 3.10 sphere is 124.788"));
        this.mvc.perform(post("/math/volume/cylinder/3/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x5 cylinder is 141.372"));
    }
}
