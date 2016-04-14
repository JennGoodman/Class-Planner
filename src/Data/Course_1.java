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
@Table(name = "course", catalog = "planner", schema = "")
@NamedQueries({
    @NamedQuery(name = "Course_1.findAll", query = "SELECT c FROM Course_1 c"),
    @NamedQuery(name = "Course_1.findByCourseID", query = "SELECT c FROM Course_1 c WHERE c.courseID = :courseID"),
    @NamedQuery(name = "Course_1.findByCourseNumber", query = "SELECT c FROM Course_1 c WHERE c.courseNumber = :courseNumber"),
    @NamedQuery(name = "Course_1.findByCourseName", query = "SELECT c FROM Course_1 c WHERE c.courseName = :courseName"),
    @NamedQuery(name = "Course_1.findByCourseType", query = "SELECT c FROM Course_1 c WHERE c.courseType = :courseType"),
    @NamedQuery(name = "Course_1.findByCapacity", query = "SELECT c FROM Course_1 c WHERE c.capacity = :capacity"),
    @NamedQuery(name = "Course_1.findByMonday", query = "SELECT c FROM Course_1 c WHERE c.monday = :monday"),
    @NamedQuery(name = "Course_1.findByTuesday", query = "SELECT c FROM Course_1 c WHERE c.tuesday = :tuesday"),
    @NamedQuery(name = "Course_1.findByWednesday", query = "SELECT c FROM Course_1 c WHERE c.wednesday = :wednesday"),
    @NamedQuery(name = "Course_1.findByThursday", query = "SELECT c FROM Course_1 c WHERE c.thursday = :thursday"),
    @NamedQuery(name = "Course_1.findByFriday", query = "SELECT c FROM Course_1 c WHERE c.friday = :friday"),
    @NamedQuery(name = "Course_1.findBySaturday", query = "SELECT c FROM Course_1 c WHERE c.saturday = :saturday"),
    @NamedQuery(name = "Course_1.findBySunday", query = "SELECT c FROM Course_1 c WHERE c.sunday = :sunday"),
    @NamedQuery(name = "Course_1.findByFeature1", query = "SELECT c FROM Course_1 c WHERE c.feature1 = :feature1"),
    @NamedQuery(name = "Course_1.findByFeature2", query = "SELECT c FROM Course_1 c WHERE c.feature2 = :feature2"),
    @NamedQuery(name = "Course_1.findByFeature3", query = "SELECT c FROM Course_1 c WHERE c.feature3 = :feature3"),
    @NamedQuery(name = "Course_1.findByPreference1", query = "SELECT c FROM Course_1 c WHERE c.preference1 = :preference1"),
    @NamedQuery(name = "Course_1.findByPreference2", query = "SELECT c FROM Course_1 c WHERE c.preference2 = :preference2"),
    @NamedQuery(name = "Course_1.findByPreference3", query = "SELECT c FROM Course_1 c WHERE c.preference3 = :preference3")})
public class Course_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CourseID")
    private Integer courseID;
    @Column(name = "CourseNumber")
    private String courseNumber;
    @Column(name = "CourseName")
    private String courseName;
    @Column(name = "CourseType")
    private String courseType;
    @Column(name = "Capacity")
    private Integer capacity;
    @Column(name = "Monday")
    private Boolean monday;
    @Column(name = "Tuesday")
    private Boolean tuesday;
    @Column(name = "Wednesday")
    private Boolean wednesday;
    @Column(name = "Thursday")
    private Boolean thursday;
    @Column(name = "Friday")
    private Boolean friday;
    @Column(name = "Saturday")
    private Boolean saturday;
    @Column(name = "Sunday")
    private Boolean sunday;
    @Column(name = "Feature1")
    private Boolean feature1;
    @Column(name = "Feature2")
    private Boolean feature2;
    @Column(name = "Feature3")
    private Boolean feature3;
    @Column(name = "Preference1")
    private String preference1;
    @Column(name = "Preference2")
    private String preference2;
    @Column(name = "Preference3")
    private String preference3;

    public Course_1() {
    }

    public Course_1(Integer courseID) {
        this.courseID = courseID;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        Integer oldCourseID = this.courseID;
        this.courseID = courseID;
        changeSupport.firePropertyChange("courseID", oldCourseID, courseID);
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        String oldCourseNumber = this.courseNumber;
        this.courseNumber = courseNumber;
        changeSupport.firePropertyChange("courseNumber", oldCourseNumber, courseNumber);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        String oldCourseName = this.courseName;
        this.courseName = courseName;
        changeSupport.firePropertyChange("courseName", oldCourseName, courseName);
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        String oldCourseType = this.courseType;
        this.courseType = courseType;
        changeSupport.firePropertyChange("courseType", oldCourseType, courseType);
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        Integer oldCapacity = this.capacity;
        this.capacity = capacity;
        changeSupport.firePropertyChange("capacity", oldCapacity, capacity);
    }

    public Boolean getMonday() {
        return monday;
    }

    public void setMonday(Boolean monday) {
        Boolean oldMonday = this.monday;
        this.monday = monday;
        changeSupport.firePropertyChange("monday", oldMonday, monday);
    }

    public Boolean getTuesday() {
        return tuesday;
    }

    public void setTuesday(Boolean tuesday) {
        Boolean oldTuesday = this.tuesday;
        this.tuesday = tuesday;
        changeSupport.firePropertyChange("tuesday", oldTuesday, tuesday);
    }

    public Boolean getWednesday() {
        return wednesday;
    }

    public void setWednesday(Boolean wednesday) {
        Boolean oldWednesday = this.wednesday;
        this.wednesday = wednesday;
        changeSupport.firePropertyChange("wednesday", oldWednesday, wednesday);
    }

    public Boolean getThursday() {
        return thursday;
    }

    public void setThursday(Boolean thursday) {
        Boolean oldThursday = this.thursday;
        this.thursday = thursday;
        changeSupport.firePropertyChange("thursday", oldThursday, thursday);
    }

    public Boolean getFriday() {
        return friday;
    }

    public void setFriday(Boolean friday) {
        Boolean oldFriday = this.friday;
        this.friday = friday;
        changeSupport.firePropertyChange("friday", oldFriday, friday);
    }

    public Boolean getSaturday() {
        return saturday;
    }

    public void setSaturday(Boolean saturday) {
        Boolean oldSaturday = this.saturday;
        this.saturday = saturday;
        changeSupport.firePropertyChange("saturday", oldSaturday, saturday);
    }

    public Boolean getSunday() {
        return sunday;
    }

    public void setSunday(Boolean sunday) {
        Boolean oldSunday = this.sunday;
        this.sunday = sunday;
        changeSupport.firePropertyChange("sunday", oldSunday, sunday);
    }

    public Boolean getFeature1() {
        return feature1;
    }

    public void setFeature1(Boolean feature1) {
        Boolean oldFeature1 = this.feature1;
        this.feature1 = feature1;
        changeSupport.firePropertyChange("feature1", oldFeature1, feature1);
    }

    public Boolean getFeature2() {
        return feature2;
    }

    public void setFeature2(Boolean feature2) {
        Boolean oldFeature2 = this.feature2;
        this.feature2 = feature2;
        changeSupport.firePropertyChange("feature2", oldFeature2, feature2);
    }

    public Boolean getFeature3() {
        return feature3;
    }

    public void setFeature3(Boolean feature3) {
        Boolean oldFeature3 = this.feature3;
        this.feature3 = feature3;
        changeSupport.firePropertyChange("feature3", oldFeature3, feature3);
    }

    public String getPreference1() {
        return preference1;
    }

    public void setPreference1(String preference1) {
        String oldPreference1 = this.preference1;
        this.preference1 = preference1;
        changeSupport.firePropertyChange("preference1", oldPreference1, preference1);
    }

    public String getPreference2() {
        return preference2;
    }

    public void setPreference2(String preference2) {
        String oldPreference2 = this.preference2;
        this.preference2 = preference2;
        changeSupport.firePropertyChange("preference2", oldPreference2, preference2);
    }

    public String getPreference3() {
        return preference3;
    }

    public void setPreference3(String preference3) {
        String oldPreference3 = this.preference3;
        this.preference3 = preference3;
        changeSupport.firePropertyChange("preference3", oldPreference3, preference3);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseID != null ? courseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course_1)) {
            return false;
        }
        Course_1 other = (Course_1) object;
        if ((this.courseID == null && other.courseID != null) || (this.courseID != null && !this.courseID.equals(other.courseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.Course_1[ courseID=" + courseID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
