package objetsMetier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the photo database table.
 * 
 */
@Entity
@NamedQuery(name="Photo.findAll", query="SELECT p FROM Photo p")
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String chemin;

	//bi-directional many-to-one association to PiecePhoto
	@OneToMany(mappedBy="photo")
	private List<PiecePhoto> piecePhotos;

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

	public List<PiecePhoto> getPiecePhotos() {
		return this.piecePhotos;
	}

	public void setPiecePhotos(List<PiecePhoto> piecePhotos) {
		this.piecePhotos = piecePhotos;
	}

	public PiecePhoto addPiecePhoto(PiecePhoto piecePhoto) {
		getPiecePhotos().add(piecePhoto);
		piecePhoto.setPhoto(this);

		return piecePhoto;
	}

	public PiecePhoto removePiecePhoto(PiecePhoto piecePhoto) {
		getPiecePhotos().remove(piecePhoto);
		piecePhoto.setPhoto(null);

		return piecePhoto;
	}

}