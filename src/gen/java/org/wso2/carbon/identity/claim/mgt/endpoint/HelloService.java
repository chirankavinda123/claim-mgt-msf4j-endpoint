package org.wso2.carbon.identity.claim.mgt.endpoint;

import org.osgi.service.component.annotations.Component;
import org.wso2.msf4j.Microservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

//@Component(
//        name = "org.wso2.carbon.identity.claim.mgt.endpoint.hello",
//        service = Microservice.class,
//        immediate = true
//)
@Path("/hello")
@io.swagger.annotations.Api(description = "hello at -> the dialects API")
public class HelloService implements Microservice {

    private Map<String, User> nameToUserMap = new HashMap<>();

    @GET
    @Path("/testing")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser() {
        return "HI";
    }

    @GET
    @Path("/user/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("name") String name) {
        User result = nameToUserMap.get(name);
        if (result != null) {
            return result;
        }
        return null;
    }


    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String helloPost(User user) {
        nameToUserMap.put(user.getName(), user);
        return user.getName();
    }

    @Override
    public String toString() {
        return "HelloWorld-OSGi-bundle";
    }
}
