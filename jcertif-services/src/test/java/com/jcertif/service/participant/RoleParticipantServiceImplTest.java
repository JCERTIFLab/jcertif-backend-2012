package com.jcertif.service.participant;

import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.dao.api.participant.RoleParticipantDAO;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Tests the {@link RoleParticipantServiceImpl}.
 * @author Douneg
 *
 */
public class RoleParticipantServiceImplTest {

    private RoleParticipantServiceImpl service;
    @Mock
    private RoleParticipantDAO roleParticipantDAO;

    /**
     * Setup the test.
     * @throws Exception if things gone wrong
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        service = new RoleParticipantServiceImpl();
        service.setDAO(roleParticipantDAO);
    }

    /**
     * Tests the {@link RoleParticipantServiceImpl#createRoleParticipant(Long, String, String, String, String, String, Character, String, String, String, String, com.jcertif.bo.RoleRoleParticipant, com.jcertif.bo.Conference, java.util.Set)}.
     */
    @Test
    public void testCreateRoleParticipant() {
        RoleParticipant role = new RoleParticipant();
        role.setCodeRole("JUG");
        Mockito.when(roleParticipantDAO.merge(role)).thenReturn(role);
    }

    /**
     * Tests the {@link RoleParticipantServiceImpl#findById(Long)}.
     */
    @Test
    public void testFindById() {
        Long idRoleParticipant = Long.valueOf(1);
        List<RoleParticipant> roleList = new ArrayList<RoleParticipant>();
        RoleParticipant role1 = new RoleParticipant();
        role1.setCodeRole("JUG");
        RoleParticipant role2 = new RoleParticipant();
        role2.setCodeRole("Media");
        RoleParticipant role3 = new RoleParticipant();
        role3.setCodeRole("Soft");
        roleList.add(role1);
        roleList.add(role2);
        roleList.add(role3);

        Mockito.when(roleParticipantDAO.findById(idRoleParticipant)).thenReturn(role1);

    }

    /**
     * Tests the {@link RoleParticipantServiceImpl#save(RoleParticipant)}.
     */
    @Test
    public void testSave() {
        RoleParticipant role = new RoleParticipant();
        role.setCodeRole("JUG");
        Mockito.when(roleParticipantDAO.merge(role)).thenReturn(role);
        assertEquals(role, service.save(role));
    }

    /**
     * Tests the {@link RoleParticipantServiceImpl#update(RoleParticipant)}.
     */
    @Test
    public void testUpdate() {
        RoleParticipant role = new RoleParticipant();
        role.setCodeRole("JUG");
        Mockito.when(roleParticipantDAO.merge(role)).thenReturn(role);
    }

    /**
     * Tests the {@link RoleParticipantServiceImpl#remove(RoleParticipant)}.
     */
    @Test
    public void testRemove() {
        RoleParticipant role = new RoleParticipant();
        role.setCodeRole("JUG");
        service.remove(role);
        Mockito.verify(roleParticipantDAO).remove(role);
    }
}
