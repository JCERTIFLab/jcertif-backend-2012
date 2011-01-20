/**
 * Stanyslas Matayo
 * MatayoBweta@gmail.com
 */
package com.jcertif.bo.participant;

import org.junit.Test;

import com.evasion.framework.test.EqualsTester;
import com.jcertif.bo.JCertifAccessorTesterImpl;
import com.jcertif.bo.conference.CentreConference;
import com.jcertif.bo.participant.ProfilUtilisateur;

/**
 * @author Douneg
 */
public class ProfilUtilisateurTest {

    /**
     * Test de tous les accesseurs du Bo {@link CentreConference}.
     */
    @Test
    public void testAllAccessors() {
        final ProfilUtilisateur profilUtilisateur = new ProfilUtilisateur(new Long(1), "Matayo", "MatayoBweta@gmail.com", null, null, null, "Awe334");
        final JCertifAccessorTesterImpl accessorTester = new JCertifAccessorTesterImpl(profilUtilisateur);
        accessorTester.testAllAccessors();
    }

    /**
     * Test des méhodes Equals et Hashcode du Bo {@link CentreConference}.
     */
    @Test
    public void testEqualsAndHashCode() {
        final ProfilUtilisateur a = new ProfilUtilisateur(new Long(1), "Matayo", "MatayoBweta@gmail.com", null, null, null, "Awe334");

        final ProfilUtilisateur b = new ProfilUtilisateur(new Long(1), "Matayo", "MatayoBweta@gmail.com", null, null, null, "Awe334");

        final ProfilUtilisateur c = new ProfilUtilisateur(new Long(2), "Stanyslas", "doudoumatayo@yahoo.com", null, null, null, "SSA23144");

        final ProfilUtilisateur d = new ProfilUtilisateur(new Long(1), "Matayo", "MatayoBweta@gmail.com", null, null, null, "Awe334") {

            /**
             *
             */
            private static final long serialVersionUID = 1L;
        };

        final EqualsTester equalsTester = new EqualsTester();
        equalsTester.testEqualsAndHashCode(a, b, c, d);


    }
}
