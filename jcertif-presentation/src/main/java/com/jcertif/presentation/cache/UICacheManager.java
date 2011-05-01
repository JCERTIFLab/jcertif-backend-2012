package com.jcertif.presentation.cache;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.jcertif.presentation.data.bo.cedule.Evenement;
import com.jcertif.presentation.data.bo.cedule.TypeEvenement;
import com.jcertif.presentation.data.bo.conference.Conference;
import com.jcertif.presentation.data.bo.conference.Faq;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.data.bo.participant.RoleParticipant;
import com.jcertif.presentation.data.bo.participant.TypeParticipant;
import com.jcertif.presentation.data.bo.presentation.Sujet;
import com.jcertif.presentation.ui.util.JCertifProps;

/**
 * @author rossi
 * 
 */
public final class UICacheManager {

	private static final String CACHE_TYPE_EVENEMENT = "type_evenement";
	private static final String CACHE_TYPE_PARTICIPANT = "type_participant";
	private static final String CACHE_ROLE_PARTICIPANT = "role_participant";
	private static final String CACHE_SUJET = "sujet";
	private static final String CACHE_CONFERENCE = "conference";
	private static final String CACHE_EVENEMENT = "evenement";
	private static final String CACHE_FAQ = "faq";
	private static final String CACHE_PARTICIPANT = "participant";

	private CacheManager cacheManager;
	private static UICacheManager instance;

	private UICacheManager() {
		super();
		cacheManager = CacheManager.create("ehcache.xml");

	}

	public static UICacheManager getInstance() {
		if (instance == null) {
			instance = new UICacheManager();
		}
		return instance;
	}

	private void put(String cacheNameKey, Object objToCache) {
		if (JCertifProps.getInstance().isCacheEnabled()) {
			Cache cache = cacheManager.getCache(cacheNameKey);
			if (cache == null) {
				cacheManager.addCache(cacheNameKey);
				cache = cacheManager.getCache(cacheNameKey);
			}
			Element element = new Element(cacheNameKey, objToCache);
			cache.put(element);
		}
	}

	private Object get(String cacheKey) {
		if (JCertifProps.getInstance().isCacheEnabled()) {
			Cache cache = cacheManager.getCache(cacheKey);
			if (cache != null) {
				Element element = cache.get(cacheKey);

				if (element != null) {
					return element.getObjectValue();
				}
			}
		}
		return null;
	}

	public void putTypeEvenement(List<TypeEvenement> objToCache) {
		put(CACHE_TYPE_EVENEMENT, objToCache);
	}

	@SuppressWarnings("unchecked")
	public List<TypeEvenement> getTypeEvenement() {
		return (List<TypeEvenement>) get(CACHE_TYPE_EVENEMENT);
	}

	public void putTypeParticipant(List<TypeParticipant> objToCache) {
		put(CACHE_TYPE_PARTICIPANT, objToCache);
	}

	@SuppressWarnings("unchecked")
	public List<TypeParticipant> getTypeParticipant() {
		return (List<TypeParticipant>) get(CACHE_TYPE_PARTICIPANT);
	}

	public void putRoleParticipant(List<RoleParticipant> objToCache) {
		put(CACHE_ROLE_PARTICIPANT, objToCache);
	}

	@SuppressWarnings("unchecked")
	public List<RoleParticipant> getRoleParticipant() {
		return (List<RoleParticipant>) get(CACHE_ROLE_PARTICIPANT);
	}

	public void putSujet(List<Sujet> objToCache) {
		put(CACHE_SUJET, objToCache);
	}

	@SuppressWarnings("unchecked")
	public List<Sujet> getSujet() {
		return (List<Sujet>) get(CACHE_SUJET);
	}

	public void putConference(List<Conference> objToCache) {
		put(CACHE_CONFERENCE, objToCache);
	}

	@SuppressWarnings("unchecked")
	public List<Conference> getConference() {
		return (List<Conference>) get(CACHE_CONFERENCE);
	}

	public void putEvenement(List<Evenement> objToCache) {
		put(CACHE_EVENEMENT, objToCache);
	}

	@SuppressWarnings("unchecked")
	public List<Evenement> getEvenement() {
		return (List<Evenement>) get(CACHE_EVENEMENT);
	}

	public void putFaq(List<Faq> objToCache) {
		put(CACHE_FAQ, objToCache);
	}

	@SuppressWarnings("unchecked")
	public List<Faq> getFaq() {
		return (List<Faq>) get(CACHE_FAQ);
	}

	public void putParticipant(List<Participant> objToCache) {
		put(CACHE_PARTICIPANT, objToCache);
	}

	@SuppressWarnings("unchecked")
	public List<Participant> getParticipant() {
		return (List<Participant>) get(CACHE_PARTICIPANT);
	}

}
