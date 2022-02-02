package ejbs;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.servlet.http.Part;

import beans.Photo;

@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class GestionPhotos {

    public GestionPhotos() {
    }

    private String getFileName(Part file) {
    	String now = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	StringBuilder stringBuilder = new StringBuilder();
    	String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
    	stringBuilder.append(now).append("-").append(fileName);
    	
    	return stringBuilder.toString();
    }
    
    public List<Photo> savePhotos(List<Part> parts, String uploadPath) {
    	List<Photo> newPhotos = new ArrayList<>();
  		
    	for (Part filePart : parts) {        
    		try {
    			StringBuilder filePathBuilder = new StringBuilder();
                String fileName = getFileName(filePart);
                String filePath = filePathBuilder
                		.append(uploadPath)
                		.append(File.separator)
                		.append(fileName)
                		.toString();
                filePart.write(filePath);

    			StringBuilder dbFilePathBuilder = new StringBuilder();
    			String dbFilePath = dbFilePathBuilder.append("/ProjetTheatre/images/")
    					.append(fileName)
    					.toString();
    			Photo newPhoto = new Photo();
    			newPhoto.setChemin(dbFilePath);
                newPhotos.add(newPhoto);
    		} catch (Exception e) {}    		
        }
    	
    	return newPhotos;
    }
    
}
