package beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the piece_photo database table.
 * 
 */
@Entity
@Table(name="piece_photo")
@NamedQuery(name="PiecePhoto.findAll", query="SELECT p FROM PiecePhoto p")
public class PiecePhoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Piece
	@ManyToOne
	@JoinColumn(name="id_piece")
	private Piece piece;

	//bi-directional many-to-one association to Photo
	@ManyToOne
	@JoinColumn(name="id_photo")
	private Photo photo;

	public PiecePhoto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Piece getPiece() {
		return this.piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Photo getPhoto() {
		return this.photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

}