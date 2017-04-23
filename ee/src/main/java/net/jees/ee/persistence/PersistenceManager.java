/*
 * 1. Lege eine Methode an, die versucht bei einer Transaktion ein Objekt aus der Datenbank zu löschen.
 * Falls dies fehlschlägt, soll sie die Änderungen rückgängig machen und einen angemessenen Fehler schmeißen. 
 * Der Rückgabewert ist ein Boolean, der angibt, ob die Transaktion geglückt oder gescheitert ist.
 * 
 * 2. Erstelle eine Methode, die eine Klasse anhand ihres Composite-PrimaryKeys in einer Tabelle findet.
 * Falls dies fehlschlägt, soll eine Fehlermeldung zurückgegeben werden.
*/


package net.jees.ee.persistence;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jees.ee.persistence.entities.pk.CompositePrimaryKey;

@RequestScoped
public class PersistenceManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceManager.class);

	private EntityManager entityManager = Persistence.createEntityManagerFactory("sqlite").createEntityManager();

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
		//livecoding pt1
		boolean hadSuccess = false;
		return hadSuccess;
	}

	public boolean deleteObject(Object object) {
		//Übung Persistence - 1
		boolean hadSuccess = false;
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
		//livecoding pt2
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
		//Übung Persistence - 2 
		return null;
	}

	public <T> Collection<T> loadAll(Class<T> domainClass) {
		//Livecoding nativeQuery
		return null;
	}
}
