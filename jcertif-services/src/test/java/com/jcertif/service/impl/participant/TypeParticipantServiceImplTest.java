package com.jcertif.service.impl.participant;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jcertif.bo.participant.TypeParticipant;
import com.jcertif.dao.api.participant.TypeParticipantDAO;



/**
 * Tests the {@link TypeParticipantServiceImpl}.
 * @author Douneg
 *
 */
public class TypeParticipantServiceImplTest {

    private TypeParticipantServiceImpl service;
    @Mock
    private TypeParticipantDAO typeParticipantDAO;

    /**
     * Setup the test.
     * @throws Exception if things gone wrong
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        service = new TypeParticipantServiceImpl();
        service.setDAO(typeParticipantDAO);
    }

    /**
     * Tests the {@link TypeParticipantServiceImpl#createTypeParticipant(Long, String, String, String, String, String, Character, String, String, String, String, com.jcertif.bo.RoleTypeParticipant, com.jcertif.bo.Conference, java.util.Set)}.
     */
    @Test
    public void testCreateTypeParticipant() {
        TypeParticipant type = new TypeParticipant();
        type.setCode("Gold");
        Mockito.when(typeParticipantDAO.merge(type)).thenReturn(type);
    }

    /**
     * Tests the {@link TypeParticipantServiceImpl#findById(Long)}.
     */
    @Test
    public void testFindById() {
        Long idTypeParticipant = Long.valueOf(1);
        List<TypeParticipant> typeList = new ArrayList<TypeParticipant>();
        TypeParticipant type1 = new TypeParticipant();
        type1.setCode("Gold");
        TypeParticipant type2 = new TypeParticipant();
        type2.setCode("Premium");
        TypeParticipant type3 = new TypeParticipant();
        type3.setCode("Soft");
        typeList.add(type1);
        typeList.add(type2);
        typeList.add(type3);

        Mockito.when(typeParticipantDAO.findById(idTypeParticipant)).thenReturn(type1);

    }

    /**
     * Tests the {@link TypeParticipantServiceImpl#save(TypeParticipant)}.
     */
    @Test
    public void testSave() {
        TypeParticipant type = new TypeParticipant();
        type.setCode("Gold");
        Mockito.when(typeParticipantDAO.merge(type)).thenReturn(type);
        assertEquals(type, service.save(type));
    }

    /**
     * Tests the {@link TypeParticipantServiceImpl#update(TypeParticipant)}.
     */
    @Test
    public void testUpdate() {
        TypeParticipant type = new TypeParticipant();
        type.setCode("Gold");
        Mockito.when(typeParticipantDAO.merge(type)).thenReturn(type);
    }

    /**
     * Tests the {@link TypeParticipantServiceImpl#remove(TypeParticipant)}.
     */
    @Test
    public void testRemove() {
        TypeParticipant type = new TypeParticipant();
        type.setCode("Gold");
        service.remove(type);
        Mockito.verify(typeParticipantDAO).remove(type);
    }
}
