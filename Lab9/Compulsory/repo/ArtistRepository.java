/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author ciuzb
 */
@Entity
@Table(name="Artists")
@NamedQueries({
 @NamedQuery(name = "ArtistRepository.findByName",
 query = "SELECT a FROM Artists a WHERE a.name=:name")})

public class ArtistRepository implements Serializable {

    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "NAME")
    private String name; 
    @Column(name = "COUNTRY")
    private String country; 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArtistRepository)) {
            return false;
        }
        ArtistRepository other = (ArtistRepository) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repo.ArtistRepository[ id=" + id + " ]";
    }
}
