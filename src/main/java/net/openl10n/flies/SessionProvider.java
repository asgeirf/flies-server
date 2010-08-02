package net.openl10n.flies;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Session;

public class SessionProvider {

	@Inject EntityManager em;
	
	@Produces @RequestScoped Session getSession() {
		return (Session) em.getDelegate();
	}

}
