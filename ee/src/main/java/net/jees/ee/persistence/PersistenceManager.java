package net.jees.ee.persistence;

import java.util.Collection;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jees.ee.persistence.entities.pk.CompositePrimaryKey;

@RequestScoped
public class PersistenceManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceManager.class);

	@PersistenceContext(unitName = "sqlite")
	private EntityManager entityManager;

	@Resource
	UserTransaction userTransaction;

	/**
	 * Persist a given {@link Object} annotated with {@link Entity} to the
	 * database.
	 * 
	 * @param object
	 *          The object to persist.
	 * @return <code>true</code> if persisted successfully, else
	 *         <code>false</code>
	 */
	public boolean persistObject(Object object) {
		try {
			userTransaction.begin();
			entityManager.persist(object);
			userTransaction.commit();
			return true;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			LOGGER.error("Wasn't able to persist entity + " + object, e);
			return false;
		}
	}

	/**
	 * Load a given {@link Object} from the database, identified by its
	 * {@link Class} and corresponding primary key.
	 * 
	 * @param objectClass
	 *          The type of class to load.
	 * @param id
	 *          The primary key to search for.
	 * @return
	 */
	public <T> T loadObject(Class<T> objectClass, int id) {
		try {
			return entityManager.find(objectClass, id);
		} catch (Exception e) {
			LOGGER.error("Exception reading {}:\n {}", objectClass.getName(), e);
		}
		return null;
	}

	/**
	 * Load a given {@link Object} from the database, identified by its
	 * {@link Class} and corresponding {@link CompositePrimaryKey}.
	 * 
	 * @param objectClass
	 *          The type of the class to load.
	 * @param compositePrimaryKey
	 *          The composite primary key to search for.
	 * @return
	 */
	public <T> T loadObject(Class<T> objectClass, CompositePrimaryKey compositePrimaryKey) {
		try {
			return entityManager.find(objectClass, compositePrimaryKey);
		} catch (Exception e) {
			LOGGER.error("Exception reading {}:\n {}", objectClass.getName(), e);
		}
		return null;
	}

	public <T> Collection<T> loadAll(Class<T> domainClass) {
		try {

			Query query = entityManager.createNativeQuery("SELECT * FROM " + domainClass.getSimpleName(), domainClass);
			return query.getResultList();
		} catch (Exception e) {
			LOGGER.error("Exception reading {}:\n {}", domainClass.getName(), e);
		}
		return null;
	}
}
