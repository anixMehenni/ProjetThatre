package beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comedien_piece database table.
 * 
 */
@Entity
@Table(name="comedien_piece")
@NamedQuery(name="ComedienPiece.findAll", query="SELECT c FROM ComedienPiece c")
public class ComedienPiece implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String role;

	//bi-directional many-to-one association to Comedien
	@ManyToOne
	@JoinColumn(name="id_comedien")
	private Comedien comedien;

	//bi-directional many-to-one association to Piece
	@ManyToOne
	@JoinColumn(name="id_piece")
	private Piece piece;

	public ComedienPiece() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Comedien getComedien() {
		return this.comedien;
	}

	public void setComedien(Comedien comedien) {
		this.comedien = comedien;
	}

	public Piece getPiece() {
		return this.piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}