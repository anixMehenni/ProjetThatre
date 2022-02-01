package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the piece database table.
 * 
 */
@Entity
@NamedQuery(name="Piece.findAll", query="SELECT p FROM Piece p")
public class Piece implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String auteur;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_creation")
	private Date dateCreation = new Date();

	@Lob
	private String description;

	private String nom;

	//bi-directional many-to-one association to ComedienPiece
	@OneToMany(mappedBy="piece", cascade=CascadeType.ALL)
	private List<ComedienPiece> comedienPieces;

	//bi-directional many-to-one association to Commentaire
	@OneToMany(mappedBy="piece")
	private List<Commentaire> commentaires;

	//bi-directional many-to-one association to EquipeTechnique
	@OneToMany(mappedBy="piece", cascade=CascadeType.ALL)
	private List<EquipeTechnique> equipeTechniques;

	//bi-directional many-to-one association to Photo
	@OneToMany(mappedBy="piece")
	private List<Photo> photos;

	//bi-directional many-to-one association to Representation
	@OneToMany(mappedBy="piece")
	private List<Representation> representations;

	public Piece() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuteur() {
		return this.auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		comedienPiece.setPiece(this);

		return comedienPiece;
	}

	public ComedienPiece removeComedienPiece(ComedienPiece comedienPiece) {
		getComedienPieces().remove(comedienPiece);
		comedienPiece.setPiece(null);

		return comedienPiece;
	}

	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Commentaire addCommentaire(Commentaire commentaire) {
		getCommentaires().add(commentaire);
		commentaire.setPiece(this);

		return commentaire;
	}

	public Commentaire removeCommentaire(Commentaire commentaire) {
		getCommentaires().remove(commentaire);
		commentaire.setPiece(null);

		return commentaire;
	}

	public List<EquipeTechnique> getEquipeTechniques() {
		return this.equipeTechniques;
	}

	public void setEquipeTechniques(List<EquipeTechnique> equipeTechniques) {
		this.equipeTechniques = equipeTechniques;
	}

	public EquipeTechnique addEquipeTechnique(EquipeTechnique equipeTechnique) {
		getEquipeTechniques().add(equipeTechnique);
		equipeTechnique.setPiece(this);

		return equipeTechnique;
	}

	public EquipeTechnique removeEquipeTechnique(EquipeTechnique equipeTechnique) {
		getEquipeTechniques().remove(equipeTechnique);
		equipeTechnique.setPiece(null);

		return equipeTechnique;
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Photo addPhoto(Photo photo) {
		getPhotos().add(photo);
		photo.setPiece(this);

		return photo;
	}

	public Photo removePhoto(Photo photo) {
		getPhotos().remove(photo);
		photo.setPiece(null);

		return photo;
	}

	public List<Representation> getRepresentations() {
		return this.representations;
	}

	public void setRepresentations(List<Representation> representations) {
		this.representations = representations;
	}

	public Representation addRepresentation(Representation representation) {
		getRepresentations().add(representation);
		representation.setPiece(this);

		return representation;
	}

	public Representation removeRepresentation(Representation representation) {
		getRepresentations().remove(representation);
		representation.setPiece(null);

		return representation;
	}

}