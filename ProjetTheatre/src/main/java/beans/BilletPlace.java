package objetsMetier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the billet_place database table.
 * 
 */
@Entity
@Table(name="billet_place")
@NamedQuery(name="BilletPlace.findAll", query="SELECT b FROM BilletPlace b")
public class BilletPlace implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;

	@Column(name="id_billet")
	private int idBillet;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name="id_place")
	private Place place;

	public BilletPlace() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdBillet() {
		return this.idBillet;
	}

	public void setIdBillet(int idBillet) {
		this.idBillet = idBillet;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

}