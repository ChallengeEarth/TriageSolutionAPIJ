package triage.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "patients")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Patient {

    @Id
    private int id;
    private String name;
    private int age;
    private String chiefComplaint;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    public Patient() {
    }

    public Patient(int id, String name, int age, String chiefComplaint, Date createdAt) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.chiefComplaint = chiefComplaint;
        this.createdAt = createdAt;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (getId() != patient.getId()) return false;
        if (getAge() != patient.getAge()) return false;
        if (getName() != null ? !getName().equals(patient.getName()) : patient.getName() != null) return false;
        return !(getChiefComplaint() != null ? !getChiefComplaint().equals(patient.getChiefComplaint()) : patient.getChiefComplaint() != null);

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getAge();
        result = 31 * result + (getChiefComplaint() != null ? getChiefComplaint().hashCode() : 0);
        return result;
    }
}
