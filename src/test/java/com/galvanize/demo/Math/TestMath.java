package com.galvanize.demo.Math;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

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
        this.mvc.perform(get("/math/calculate?operation=exponent&x=2&y=5"))
                .andExpect(content().string("2 ^ 5 = 32"));
        this.mvc.perform(get("/math/calculate?x=30&y=5"))
                .andExpect(content().string("30 + 5 = 35"));
    }

    @Test
    public void testSum() throws Exception{
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6&n=7&n=8"))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 + 7 + 8 = 30"));
    }

    @Test
    public void testVolumeRectangular() throws Exception{
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
                .andExpect(content().string("The volume of a r=3.00 h=5.00 cylinder is 141.372"));
    }
    @Test
    public void testAreaCircle() throws Exception{
        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("length",  "4");
        this.mvc.perform(request)
                .andExpect(content().string("Invalid"));

        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius",  "4");
        this.mvc.perform(request1)
                .andExpect(content().string("Area of a circle with a radius of 4 is 50.26548"));
    }
    @Test
    public void testAreaRectangle() throws Exception{
        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("length",  "4")
                .param("width", "7");

        this.mvc.perform(request)
                .andExpect(content().string("Area of a 4x7 rectangle is 28"));

        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("radius", "4");
        this.mvc.perform(request1)
                .andExpect(content().string("Invalid"));
    }
    @Test
    public void testAreaRectangleShape() throws Exception {
        MockHttpServletRequestBuilder request = post("/math/area/rectangle")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("length", "4")
                .param("width", "7");

        this.mvc.perform(request)
                .andExpect(content().string("Area of a 4x7 rectangle is 28"));
    }
    @Test
    public void testAreaCircleShape() throws Exception {
        MockHttpServletRequestBuilder request = post("/math/area/circle")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("radius", "4");
        this.mvc.perform(request)
                .andExpect(content().string("Area of a circle with a radius of 4 is 50.26548"));
    }

    @Test
    public void testVolumeRectangularShape() throws Exception{
        MockHttpServletRequestBuilder request = post("/math/volume/rectangle")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("length", "4")
                .param("width", "5")
                .param("height", "6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 4x5x6 rectangle is 120"));
    }

    @Test
    public void testVolumeCircularShapes() throws Exception {
        MockHttpServletRequestBuilder request = post("/math/volume/sphere")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("radius", "3.1");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a radius 3.10 sphere is 124.788"));

        MockHttpServletRequestBuilder request1 = post("/math/volume/cylinder")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("radius", "3")
                .param("height", "5");
        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a r=3.00 h=5.00 cylinder is 141.372"));
    }
}
