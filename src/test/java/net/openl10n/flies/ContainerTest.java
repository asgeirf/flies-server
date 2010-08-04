package net.openl10n.flies;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.io.File;

import javax.inject.Inject;

import net.openl10n.flies.model.User;
import net.openl10n.flies.rest.FliesRestApplication;
import net.openl10n.flies.rest.QueryResource;

import org.hibernate.Session;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ContainerTest {

	@Inject
	Session session;

	@Deployment
	public static WebArchive createTestArchive() {
		return ShrinkWrap.create(WebArchive.class,"test.war")
				.addManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
				.addManifestResource(
						"META-INF/persistence.xml",
						ArchivePaths.create("persistence.xml"))
				.addClass(EntityManagerProvider.class)
				.addClass(SessionProvider.class)
				.addClass(FliesRestApplication.class)
				.addClass(QueryResource.class)
				.addResource("jetty-env.xml", ArchivePaths.create("WEB-INF/jetty-env.xml"))
            .addClass(User.class)
				.addResource(new FileAsset(new File("src/main/webapp/META-INF/context.xml")), ArchivePaths.create("META-INF/context.xml"))
				.setWebXML("web-tomcat-embedded.xml");
		
	}

	@Test
	public void testSession() {
		assertThat(session, notNullValue());
		assertThat(session.createQuery("from User").list().size(), not(0));
	}
	
	@Test
	public void testSession2() {
		assertThat(session, notNullValue());
		assertThat(session.createQuery("from User").list().size(), is(0));
	}
	
}
