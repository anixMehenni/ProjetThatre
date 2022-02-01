package beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the commentaire database table.
 * 
 */
@Entity
@NamedQuery(name="Commentaire.findAll", query="SELECT c FROM Commentaire c")
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String commentaire;

	private short note;

	private String statut;

	//bi-directional many-to-one association to Piece
	@ManyToOne
	@JoinColumn(name="id_piece")
	private Piece piece;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;

	public Commentaire() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public short getNote() {
		return this.note;
	}

	public void setNote(short note) {
		this.note = note;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Piece getPiece() {
		return this.piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}