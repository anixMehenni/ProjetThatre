package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lieu database table.
 * 
 */
@Entity
@NamedQuery(name="Lieu.findAll", query="SELECT l FROM Lieu l")
public class Lieu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String adresse;

	@Lob
	private String description;

	private String type;

	//bi-directional many-to-one association to Representation
	@OneToMany(mappedBy="lieu")
	private List<Representation> representations;

	public Lieu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Representation> getRepresentations() {
		return this.representations;
	}

	public void setRepresentations(List<Representation> representations) {
		this.representations = representations;
	}

	public Representation addRepresentation(Representation representation) {
		getRepresentations().add(representation);
		representation.setLieu(this);

		return representation;
	}

	public Representation removeRepresentation(Representation representation) {
		getRepresentations().remove(representation);
		representation.setLieu(null);

		return representation;
	}

}