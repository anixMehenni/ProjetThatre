package beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the photo database table.
 * 
 */
@Entity
@NamedQuery(name="Photo.findAll", query="SELECT p FROM Photo p")
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String chemin;

	//bi-directional many-to-one association to Festival
	@ManyToOne
	@JoinColumn(name="id_festival")
	private Festival festival;

	//bi-directional many-to-one association to Piece
	@ManyToOne
	@JoinColumn(name="id_piece")
	private Piece piece;

	public Photo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChemin() {
		return this.chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public Festival getFestival() {
		return this.festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public Piece getPiece() {
		return this.piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}