package com.jcertif.pics.participant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author rossi.oddet
 * 
 */
@Path("participant")
@Service
public class ParticipantPics {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParticipantPics.class);

	@POST
	@Consumes({ MediaType.APPLICATION_OCTET_STREAM })
	@Path("store/{role}/{id}/{ext}")
	public void store(final InputStream fileStream, @PathParam(value = "id") Long idParticipant,
			@PathParam(value = "role") String codeRole, @PathParam(value = "ext") String ext)
			throws IOException {

		ResourceBundle rb = ResourceBundle.getBundle("jcertif-pics");
		String picDir = rb.getString("pics.participant.dir");
		File dir = new File(picDir + "/" + codeRole);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		File outputFile = new File(dir, idParticipant + "." + ext);

		OutputStream out;

		out = new FileOutputStream(outputFile);

		byte buf[] = new byte[1024];
		int len;

		while ((len = fileStream.read(buf)) > 0)
			out.write(buf, 0, len);
		out.close();
		fileStream.close();

		LOGGER.info("File {} saved for idParticipant={}", outputFile.getAbsolutePath(),
				idParticipant);
	}

}
