/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.service.mail;

import com.jcertif.bo.participant.ProfilUtilisateur;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author Douneg
 */
@Service
public class CSenderServiceImpl implements CSenderService {

    private JavaMailSender mailSender;
    private VelocityEngine velocityEngine;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    @Override
    public void sendConfirmation(final ProfilUtilisateur profilUtilisateur, final String from) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(profilUtilisateur.getEmail());
                message.setFrom(from); // could be parameterized...
                Map model = new HashMap();
                model.put("profilUtilisateur", profilUtilisateur);
                String text = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, "senConfirmationTemplate.vm", model);
                message.setText(text, true);
            }
        };
        this.mailSender.send(preparator);
    }
}
