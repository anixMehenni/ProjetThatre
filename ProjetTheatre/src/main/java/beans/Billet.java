package objetsMetier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the billet database table.
 * 
 */
@Entity
@NamedQuery(name="Billet.findAll", query="SELECT b FROM Billet b")
public class Billet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_reservation")
	private Date dateReservation;
	
	@Id
	private int id;

	@Column(name="lien_telechargement")
	private String lienTelechargement;

	public Billet() {
	}

	public Date getDateReservation() {
		return this.dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLienTelechargement() {
		return this.lienTelechargement;
	}

	public void setLienTelechargement(String lienTelechargement) {
		this.lienTelechargement = lienTelechargement;
	}

}