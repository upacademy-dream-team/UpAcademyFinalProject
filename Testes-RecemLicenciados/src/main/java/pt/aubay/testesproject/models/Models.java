package pt.aubay.testesproject.models;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass//Classe abstract...anotação para distinguir este tipo de classe das outras
public class Models implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	protected long id;
	
//	public Models() {
//		//super();
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
