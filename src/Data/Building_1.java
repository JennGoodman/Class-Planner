/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Patrick
 */
@Entity
@Table(name = "building", catalog = "planner", schema = "")
@NamedQueries({
    @NamedQuery(name = "Building_1.findAll", query = "SELECT b FROM Building_1 b"),
    @NamedQuery(name = "Building_1.findByBuildingID", query = "SELECT b FROM Building_1 b WHERE b.buildingID = :buildingID"),
    @NamedQuery(name = "Building_1.findByName", query = "SELECT b FROM Building_1 b WHERE b.name = :name")})
public class Building_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BuildingID")
    private Integer buildingID;
    @Column(name = "Name")
    private String name;

    public Building_1() {
    }

    public Building_1(Integer buildingID) {
        this.buildingID = buildingID;
    }

    public Integer getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(Integer buildingID) {
        Integer oldBuildingID = this.buildingID;
        this.buildingID = buildingID;
        changeSupport.firePropertyChange("buildingID", oldBuildingID, buildingID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buildingID != null ? buildingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Building_1)) {
            return false;
        }
        Building_1 other = (Building_1) object;
        if ((this.buildingID == null && other.buildingID != null) || (this.buildingID != null && !this.buildingID.equals(other.buildingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.Building_1[ buildingID=" + buildingID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
