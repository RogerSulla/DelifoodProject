package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ObjetivoNutricional")
public class ObjetivoNutricional implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idObjNutricional;

    @Column(name = "objetivoNutricional", nullable = false, length = 25)
	private String objetivoNutricional;

    public ObjetivoNutricional() {
		super();
	}

    public ObjetivoNutricional(int idObjNutricional, String objetivoNutricional) {
        super();
        this.idObjNutricional = idObjNutricional;
        this.objetivoNutricional = objetivoNutricional;
    }

    public int getIdObjNutricional() {
        return idObjNutricional;
    }

    public void setIdObjNutricional(int idObjNutricional) {
        this.idObjNutricional = idObjNutricional;
    }

    public String getObjetivoNutricional() {
        return objetivoNutricional;
    }

    public void setObjetivoNutricional(String objetivoNutricional) {
        this.objetivoNutricional = objetivoNutricional;
    }
    
}
