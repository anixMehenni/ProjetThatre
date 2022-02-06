package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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

	//bi-directional many-to-one association to Billet
	@OneToMany(mappedBy="representation")
	private List<Billet> billets;

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

	public List<Billet> getBillets() {
		return this.billets;
	}

	public void setBillets(List<Billet> billets) {
		this.billets = billets;
	}

	public Billet addBillet(Billet billet) {
		getBillets().add(billet);
		billet.setRepresentation(this);

		return billet;
	}

	public Billet removeBillet(Billet billet) {
		getBillets().remove(billet);
		billet.setRepresentation(null);

		return billet;
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