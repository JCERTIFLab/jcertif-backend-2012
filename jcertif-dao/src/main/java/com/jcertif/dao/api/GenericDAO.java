package com.jcertif.dao.api;

import java.io.Serializable;
import java.util.List;

/**
 * Generic DAO Interface.
 * 
 * @author rossi.oddet
 * 
 * @param <T>
 *            persistent type.
 * @param <PK>
 *            Primary key type
 */
public interface GenericDAO<T, PK extends Serializable> extends DAO {

	/**
	 * Cette m�thode est susceptible de lancer l'exception
	 * ObjectNotFoundException de type Runtime si l'objet n'est pas trouv�. Si
	 * l'on n'est pas s�r de trouver un objet il faut utiliser la m�thode
	 * findById.
	 * 
	 * @param id
	 *            identifiant d'une entit�
	 * @return une entit�
	 */
	T getReference(PK id);

	/**
	 * @param id
	 *            identifiant d'une entit�
	 * @return une entit�
	 */
	T findById(PK id);

	/**
	 * @return la liste de toutes les entit�s
	 */
	List<T> findAll();

	/**
	 * @param sortedPropertyName
	 *            le nom de la propri�t� � utiliser pour le tri
	 * @param ascending
	 *            true si trie ascendant
	 * @return la liste de toutes les entit�s
	 */
	List<T> findAllWithSort(String sortedPropertyName, boolean ascending);

	/**
	 * Persiste une entit�.
	 * 
	 * @param entity
	 *            entit� � persister
	 */
	void persist(T entity);

	/**
	 * Sauvegarde une entit�. L'objet persist� est celui obtenu par retour de
	 * m�thode.
	 * 
	 * @param entity
	 *            une entit�
	 * @return une entit� persist�
	 */
	T merge(T entity);

	/**
	 * Supprimes une entit�.
	 * 
	 * @param entity
	 *            une entit�
	 */
	void remove(T entity);

	/**
	 * Lance un flush (Synchronisation).
	 */
	void flush();

	/**
	 * Vide la session.
	 */
	void clear();
        
        /**
	 * @return la liste des entit�s filtr�es
	 */
	List<T> findByProperty(String propertyName,Object propertyValue);

}
