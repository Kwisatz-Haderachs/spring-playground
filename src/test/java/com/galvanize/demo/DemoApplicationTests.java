package com.galvanize.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
/*
@Test
public void testPostMessageEndpoint() throws Exception {
    this.mvc.perform(post("/messages"))
            .andExpect(status().isOk())
            .andExpect(content().string("POST to messages route"));
}

   @Test
    public void testIndexEndpoint() throws Exception {
        this.mvc.perform(get("/").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("GET to index route"));
    }
 */