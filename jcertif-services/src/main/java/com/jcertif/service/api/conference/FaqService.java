/**
 * 
 */
package com.jcertif.service.api.conference;

import java.util.List;

import com.jcertif.bo.conference.Faq;
import com.jcertif.dao.api.conference.FaqDAO;
import com.jcertif.service.GenericService;

/**
 * @author rossi
 * 
 */
public interface FaqService extends GenericService<Faq, Long, FaqDAO> {

	List<Faq> findByConferenceId(Long idConference);

}
