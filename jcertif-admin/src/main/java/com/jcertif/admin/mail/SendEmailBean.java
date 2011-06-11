package com.jcertif.admin.mail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;

import com.jcertif.bo.participant.RoleParticipant;
import com.jcertif.service.api.participant.RoleParticipantService;
import com.jcertif.service.mail.CSenderService;

/**
 * @author rossi.oddet
 * 
 */
@Controller
public class SendEmailBean {

	private String title;
	private String content;
	private List<RoleParticipant> roles;
	private List<String> selectedRole;

	@Autowired
	private RoleParticipantService roleParticipantService;

	@Autowired
	private CSenderService cSenderService;

	public void send() {
		cSenderService.sendEmail(selectedRole, title, content);
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		if (content == null) {
			try {
				StringBuilder sb = new StringBuilder();
				BufferedReader bw = new BufferedReader(new FileReader(
						ResourceUtils.getFile("classpath:template_mail.xhtml")));
				String line = "";
				while ((line = bw.readLine()) != null) {
					sb.append(line);
				}
				content = sb.toString();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the roles
	 */
	public List<RoleParticipant> getRoles() {
		if (roles == null) {
			roles = roleParticipantService.findAll();
		}
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<RoleParticipant> roles) {
		this.roles = roles;
	}

	/**
	 * @return the selectedRole
	 */
	public List<String> getSelectedRole() {
		return selectedRole;
	}

	/**
	 * @param selectedRole
	 *            the selectedRole to set
	 */
	public void setSelectedRole(List<String> selectedRole) {
		this.selectedRole = selectedRole;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
