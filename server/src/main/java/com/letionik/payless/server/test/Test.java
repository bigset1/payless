package com.letionik.payless.server.test;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
@Component
@Path("/")
public class Test {

    @GET
    public String test() {
        return "TEST";
    }

    @GET
    @Path("entity")
    public TestEntity testEntity() {
        return new TestEntity("Roman");
    }

    public static class TestEntity {

        private String name;

        public TestEntity() {
        }

        public TestEntity(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
