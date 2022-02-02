package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the comedien database table.
 * 
 */
@Entity
@NamedQuery(name="Comedien.findAll", query="SELECT c FROM Comedien c")
public class Comedien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nom;

	//bi-directional many-to-one association to ComedienPiece
	@OneToMany(mappedBy="comedien")
	private List<ComedienPiece> comedienPieces;

	public Comedien() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<ComedienPiece> getComedienPieces() {
		return this.comedienPieces;
	}

	public void setComedienPieces(List<ComedienPiece> comedienPieces) {
		this.comedienPieces = comedienPieces;
	}

	public ComedienPiece addComedienPiece(ComedienPiece comedienPiece) {
		getComedienPieces().add(comedienPiece);
		comedienPiece.setComedien(this);

		return comedienPiece;
	}

	public ComedienPiece removeComedienPiece(ComedienPiece comedienPiece) {
		getComedienPieces().remove(comedienPiece);
		comedienPiece.setComedien(null);

		return comedienPiece;
	}

}