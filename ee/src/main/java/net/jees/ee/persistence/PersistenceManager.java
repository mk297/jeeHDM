package net.jees.ee.persistence;

import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jees.ee.persistence.entities.pk.CompositePrimaryKey;

@ApplicationScoped
public class PersistenceManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceManager.class);

	private EntityManager entityManager = Persistence.createEntityManagerFactory("sqlite").createEntityManager();
	private ArrayList <Object> objectList  = new ArrayList <Object>(); 
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
		boolean hadSuccess = false;
		
		objectList.add(object);

		return hadSuccess;
	}

	public boolean deleteObject(Object object) {
		boolean hadSuccess = false;
		
		objectList.remove(object);
		
		return hadSuccess;
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
		
			return (T) objectList.get(id);
	}
//
//	/**
//	 * Load a given {@link Object} from the database, identified by its
//	 * {@link Class} and corresponding {@link CompositePrimaryKey}.
//	 * 
//	 * @param objectClass
//	 *          The type of the class to load.
//	 * @param compositePrimaryKey
//	 *          The composite primary key to search for.
//	 * @return
//	 */
//	public <T> T loadObject(Class<T> objectClass, CompositePrimaryKey compositePrimaryKey) {
//		try {
//			return entityManager.find(objectClass, compositePrimaryKey);
//		} catch (Exception e) {
//			LOGGER.error("Exception reading {}:\n {}", objectClass.getName(), e);
//		}
//		return null;
//	}

	public <T> Collection<T> loadAll(Class<T> domainClass) {
		return (Collection<T>) objectList;
	}
}
