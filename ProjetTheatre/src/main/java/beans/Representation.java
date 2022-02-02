package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the representation database table.
 * 
 */
@Entity
@NamedQuery(name="Representation.findAll", query="SELECT r FROM Representation r")
public class Representation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	//bi-directional many-to-one association to Festival
	@ManyToOne
	@JoinColumn(name="id_festival")
	private Festival festival;

	//bi-directional many-to-one association to Lieu
	@ManyToOne
	@JoinColumn(name="id_lieu")
	private Lieu lieu;

	//bi-directional many-to-one association to Piece
	@ManyToOne
	@JoinColumn(name="id_piece")
	private Piece piece;

	public Representation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Festival getFestival() {
		return this.festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public Lieu getLieu() {
		return this.lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	public Piece getPiece() {
		return this.piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}