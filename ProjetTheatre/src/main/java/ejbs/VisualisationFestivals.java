package ejbs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Festival;

/**
 * Session Bean implementation class VisualisationFestivals
 */
@Stateless
@LocalBean
@TransactionManagement(value=TransactionManagementType.BEAN)
public class VisualisationFestivals {

    /**
     * Default constructor. 
     */
    public VisualisationFestivals() {
        // TODO Auto-generated constructor stub
    }
    
    private final static String _SQL_SELECT_Theathre = "select * from festival";
    
    private final static String _SQL_SELECT_SponsorId = "select * from festival_sponsor where id_festival = ";
    
    private final static String _SQL_SELECT_Sponsor = "select * from sponsor where id = ";
    
    private final static String _SQL_SELECT_Pieces = "select * from piece";
    
    private final static String _SQL_SELECT_Photos = "select * from photo where id_festival = ";
    
    
    public Festival recupererFestival() {
    	DataSource dataSource = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		String nom;
		String ville;
		String description;
		Date dateDebut ;
		Date dateFin;
		Festival festival = new Festival();
		
        
    	try {
    		InitialContext initialContext = new InitialContext();
    		dataSource = (DataSource) initialContext.lookup("java:/TheatreMySqlDS");
    		connection = dataSource.getConnection();
    		preparedStatement = connection.prepareStatement(_SQL_SELECT_Theathre);
    		resultSet = preparedStatement.executeQuery();
    		resultSet.next();
    		
    		nom = resultSet.getString(2);
    		ville = resultSet.getString(3);
    		description = resultSet.getString(4);
    		dateDebut = resultSet.getDate(5);
    		dateFin = resultSet.getDate(6);
    		festival.setId(Integer.parseInt(resultSet.getString(1)));
    		festival.setNom(nom);
    		festival.setVille(ville);
    		festival.setDescription(description);
    		festival.setDateDebut(dateDebut);
    		festival.setDateFin(dateFin);
    		preparedStatement2 = connection.prepareStatement(_SQL_SELECT_SponsorId + resultSet.getString(1));
    		resultSet2 = preparedStatement2.executeQuery();
    		
    		resultSet2.next();
    		
    		preparedStatement3 = connection.prepareStatement(_SQL_SELECT_Sponsor + resultSet2.getString(2));
    		resultSet3 = preparedStatement3.executeQuery();
    		
    		resultSet3.next();
    		
    		
    		return festival;
    		
    	}
    	catch (Exception e) {
    		System.out.println("AAAAAAA");
			System.out.println(e.getMessage().toString());
		}
    	
    	return festival;
    	
    }
    
    public String recupererSponsor(int IdFest) {
    	DataSource dataSource = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		String Sponsor;
		
        
    	try {
    		InitialContext initialContext = new InitialContext();
    		dataSource = (DataSource) initialContext.lookup("java:/TheatreMySqlDS");
    		connection = dataSource.getConnection();
    		preparedStatement = connection.prepareStatement(_SQL_SELECT_Theathre);
    		
    		preparedStatement2 = connection.prepareStatement(_SQL_SELECT_SponsorId + Integer.toString(IdFest));
    		resultSet2 = preparedStatement2.executeQuery();
    		System.out.println(IdFest);
    		resultSet2.next();
    		
    		preparedStatement3 = connection.prepareStatement(_SQL_SELECT_Sponsor + resultSet2.getString(2));
    		resultSet3 = preparedStatement3.executeQuery();
    		
    		resultSet3.next();
    		
    		return resultSet3.getString(2);
    		
    	}
    	catch (Exception e) {
    		System.out.println("AAAAAAA");
			System.out.println(e.getMessage().toString());
			return "Nope";
		}
    	
    	
    }
    
    
    public List<String> recupererPhotosPieces(int IdFestival){
    	
    	DataSource dataSource = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		List<String> photos = new ArrayList<String>();
		
        
    	try {
    		InitialContext initialContext = new InitialContext();
    		dataSource = (DataSource) initialContext.lookup("java:/TheatreMySqlDS");
    		connection = dataSource.getConnection();
    		
    		preparedStatement2 = connection.prepareStatement(_SQL_SELECT_Photos+ Integer.toString(IdFestival));
    		resultSet2 = preparedStatement2.executeQuery();
    		
    		
    		while(resultSet2.next()) {
    			photos.add(resultSet2.getString(2));
    		}
    		
    		return photos;
    		
    	}
    	catch (Exception e) {
    		System.out.println("AAAAAAA");
			System.out.println(e.getMessage().toString());
			return photos;
		}
    	
    }
    
public List<String> recupererIdsPieces(int IdFestival){
    	
    	DataSource dataSource = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		List<String> photos = new ArrayList<String>();
		
        
    	try {
    		InitialContext initialContext = new InitialContext();
    		dataSource = (DataSource) initialContext.lookup("java:/TheatreMySqlDS");
    		connection = dataSource.getConnection();
    		
    		preparedStatement2 = connection.prepareStatement(_SQL_SELECT_Photos+ Integer.toString(IdFestival));
    		resultSet2 = preparedStatement2.executeQuery();
    		
    		
    		while(resultSet2.next()) {
    			photos.add(resultSet2.getString(4));
    		}
    		
    		return photos;
    		
    	}
    	catch (Exception e) {
    		System.out.println("AAAAAAA");
			System.out.println(e.getMessage().toString());
			return photos;
		}
    	
    }

}
