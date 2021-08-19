/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbs.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Muhammed Atallah
 */
@Entity
@Table(name = "clients")
@XmlRootElement
public class Clients extends StanderdRegistInformation {

    @OneToMany(mappedBy = "clientId")
    private List<Appointment> appointmentList;

    public Clients() {
    }

    public Clients(Long id) {
        super(id);
    }

    public Clients(String firstName, String secondName, String lastName) {
        super(firstName, secondName, lastName);
    }

    public List<Appointment> getAttendanceList() {
        return appointmentList;
    }

    public void setAttendanceList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getSecondName() + " " + getLastName();
    }
}
