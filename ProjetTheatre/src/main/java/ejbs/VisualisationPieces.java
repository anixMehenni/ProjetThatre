package ejbs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import beans.Festival;
import beans.Piece;

/**
 * Session Bean implementation class VisualisationPieces
 */
@Stateless
@LocalBean
public class VisualisationPieces {

    /**
     * Default constructor. 
     */
    public VisualisationPieces() {
        // TODO Auto-generated constructor stub
    }
    
private final static String _SQL_SELECT_Piece = "select * from piece where id = ";
    
    
    public Piece recupererPiece(int IdPiece) {
    	DataSource dataSource = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String nom;
		String auteur;
		String description;
		Piece piece = new Piece();
		
        
    	try {
    		InitialContext initialContext = new InitialContext();
    		dataSource = (DataSource) initialContext.lookup("java:/TheatreMySqlDS");
    		connection = dataSource.getConnection();
    		preparedStatement = connection.prepareStatement(_SQL_SELECT_Piece + Integer.toString(IdPiece));
    		resultSet = preparedStatement.executeQuery();
    		resultSet.next();
    		
    		nom = resultSet.getString(2);
    		auteur = resultSet.getString(4);
    		description = resultSet.getString(3);
    		piece.setId(Integer.parseInt(resultSet.getString(1)));
    		piece.setNom(nom);
    		piece.setAuteur(auteur);
    		piece.setDescription(description);
    		
    		return piece;
    		
    	}
    	catch (Exception e) {
    		System.out.println("AAAAAAA");
			System.out.println(e.getMessage().toString());
		}
    	
    	return piece;
    	
    }

}
