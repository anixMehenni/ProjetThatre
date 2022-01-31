package objetsMetier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nom;

	//bi-directional many-to-one association to EquipeTechnique
	@OneToMany(mappedBy="role")
	private List<EquipeTechnique> equipeTechniques;

	public Role() {
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

	public List<EquipeTechnique> getEquipeTechniques() {
		return this.equipeTechniques;
	}

	public void setEquipeTechniques(List<EquipeTechnique> equipeTechniques) {
		this.equipeTechniques = equipeTechniques;
	}

	public EquipeTechnique addEquipeTechnique(EquipeTechnique equipeTechnique) {
		getEquipeTechniques().add(equipeTechnique);
		equipeTechnique.setRole(this);

		return equipeTechnique;
	}

	public EquipeTechnique removeEquipeTechnique(EquipeTechnique equipeTechnique) {
		getEquipeTechniques().remove(equipeTechnique);
		equipeTechnique.setRole(null);

		return equipeTechnique;
	}

}