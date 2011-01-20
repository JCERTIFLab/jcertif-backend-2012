/**
 * 
 */
package com.jcertif.service.participant;


import org.springframework.stereotype.Service;

import com.jcertif.bo.participant.Participant;
import com.jcertif.dao.hibernate.participant.ParticipantDAOHibernate;
import com.jcertif.service.AbstractService;

/**
 * Implementation of the {@link ParticipantService}.
 * @author Bernard Adanlessossi
 *
 */
@Service
public class ParticipantServiceImpl extends AbstractService<Participant, Long, ParticipantDAOHibernate> implements ParticipantService {




}
