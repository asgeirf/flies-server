package net.openl10n.flies.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import net.openl10n.flies.model.User;

import org.hibernate.Session;
import org.jboss.seam.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
@RequestScoped
public class QueryResource
{

   private static final Logger log = LoggerFactory.getLogger(QueryResource.class);

   @Inject
   Session session;
   
   @Path("/testx")
   @GET
   @Produces("text/plain")
   @Transactional
   public Response search()
   {

      List<User> users = session.createQuery("from User").list();

      log.info("found {} users", users.size());

      User u = new User();
      u.setUsername("user" + users.size() + 1);
      session.persist(u);
      session.flush();
      log.info("calling serivce ");
      log.info("em is {}", session);
      return Response.ok().entity("hello").build();
   }

}
