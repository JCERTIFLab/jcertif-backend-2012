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
	 * Cette méthode est susceptible de lancer l'exception
	 * ObjectNotFoundException de type Runtime si l'objet n'est pas trouvé. Si
	 * l'on n'est pas sûr de trouver un objet il faut utiliser la méthode
	 * findById.
	 * 
	 * @param id
	 *            identifiant d'une entité
	 * @return une entité
	 */
	T getReference(PK id);

	/**
	 * @param id
	 *            identifiant d'une entité
	 * @return une entité
	 */
	T findById(PK id);

	/**
	 * @return la liste de toutes les entités
	 */
	List<T> findAll();

	/**
	 * @param sortedPropertyName
	 *            le nom de la propriété à utiliser pour le tri
	 * @param ascending
	 *            true si trie ascendant
	 * @return la liste de toutes les entités
	 */
	List<T> findAllWithSort(String sortedPropertyName, boolean ascending);

	/**
	 * Persiste une entité.
	 * 
	 * @param entity
	 *            entité à persister
	 */
	void persist(T entity);

	/**
	 * Sauvegarde une entité. L'objet persisté est celui obtenu par retour de
	 * méthode.
	 * 
	 * @param entity
	 *            une entité
	 * @return une entité persisté
	 */
	T merge(T entity);

	/**
	 * Supprimes une entité.
	 * 
	 * @param entity
	 *            une entité
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
	 * @return la liste des entités filtrées
	 */
	List<T> findByProperty(String propertyName,Object propertyValue);

}
