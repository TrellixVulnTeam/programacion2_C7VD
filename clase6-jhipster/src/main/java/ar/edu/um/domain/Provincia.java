package ar.edu.um.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Provincia.
 */
@Entity
@Table(name = "provincia")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Provincia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "zipcode")
    private String zipcode;

    @ManyToOne
    private Pais pais;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Provincia id(Long id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Provincia nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public Provincia zipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Pais getPais() {
        return this.pais;
    }

    public Provincia pais(Pais pais) {
        this.setPais(pais);
        return this;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Provincia)) {
            return false;
        }
        return id != null && id.equals(((Provincia) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Provincia{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", zipcode='" + getZipcode() + "'" +
            "}";
    }
}
