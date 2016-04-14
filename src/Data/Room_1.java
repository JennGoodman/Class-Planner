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
@Table(name = "room", catalog = "planner", schema = "")
@NamedQueries({
    @NamedQuery(name = "Room_1.findAll", query = "SELECT r FROM Room_1 r"),
    @NamedQuery(name = "Room_1.findByRoomID", query = "SELECT r FROM Room_1 r WHERE r.roomID = :roomID"),
    @NamedQuery(name = "Room_1.findByClassType", query = "SELECT r FROM Room_1 r WHERE r.classType = :classType"),
    @NamedQuery(name = "Room_1.findByCapacity", query = "SELECT r FROM Room_1 r WHERE r.capacity = :capacity"),
    @NamedQuery(name = "Room_1.findByRoomNum", query = "SELECT r FROM Room_1 r WHERE r.roomNum = :roomNum"),
    @NamedQuery(name = "Room_1.findByBuildingID", query = "SELECT r FROM Room_1 r WHERE r.buildingID = :buildingID")})
public class Room_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RoomID")
    private Integer roomID;
    @Column(name = "ClassType")
    private Integer classType;
    @Column(name = "Capacity")
    private Integer capacity;
    @Column(name = "RoomNum")
    private Integer roomNum;
    @Column(name = "BuildingID")
    private Integer buildingID;

    public Room_1() {
    }

    public Room_1(Integer roomID) {
        this.roomID = roomID;
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        Integer oldRoomID = this.roomID;
        this.roomID = roomID;
        changeSupport.firePropertyChange("roomID", oldRoomID, roomID);
    }

    public Integer getClassType() {
        return classType;
    }

    public void setClassType(Integer classType) {
        Integer oldClassType = this.classType;
        this.classType = classType;
        changeSupport.firePropertyChange("classType", oldClassType, classType);
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        Integer oldCapacity = this.capacity;
        this.capacity = capacity;
        changeSupport.firePropertyChange("capacity", oldCapacity, capacity);
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        Integer oldRoomNum = this.roomNum;
        this.roomNum = roomNum;
        changeSupport.firePropertyChange("roomNum", oldRoomNum, roomNum);
    }

    public Integer getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(Integer buildingID) {
        Integer oldBuildingID = this.buildingID;
        this.buildingID = buildingID;
        changeSupport.firePropertyChange("buildingID", oldBuildingID, buildingID);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomID != null ? roomID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room_1)) {
            return false;
        }
        Room_1 other = (Room_1) object;
        if ((this.roomID == null && other.roomID != null) || (this.roomID != null && !this.roomID.equals(other.roomID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.Room_1[ roomID=" + roomID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
