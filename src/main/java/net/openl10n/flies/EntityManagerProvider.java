package net.openl10n.flies;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProvider {

	@Produces @RequestScoped @PersistenceContext(unitName="flies")
	EntityManager em;
	
}
