package objetsMetier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the equipe_technique database table.
 * 
 */
@Entity
@Table(name="equipe_technique")
@NamedQuery(name="EquipeTechnique.findAll", query="SELECT e FROM EquipeTechnique e")
public class EquipeTechnique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name="id_personne")
	private Personne personne;

	//bi-directional many-to-one association to Piece
	@ManyToOne
	@JoinColumn(name="id_piece")
	private Piece piece;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;

	public EquipeTechnique() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Piece getPiece() {
		return this.piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}