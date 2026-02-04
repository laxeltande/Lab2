/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.lab2;

import java.util.Date;
/**
 *
 * @author Jeanie
 */
public class Prescription {

    String rxId;
    String patientName;
    String medication;
    Date receivedDate;
    String status; // RECEIVED or READY

    public Prescription(String rxId, String patientName, String medication, Date receivedDate, String status) {
        // saving values in object
        this.rxId = rxId;
        this.patientName = patientName;
        this.medication = medication;
        this.receivedDate = receivedDate;
        this.status = status;
    }

    public String getRxId() {
        // return id
        return rxId;
    }

    public String getPatientName() {
        // return patient
        return patientName;
    }

    public String getMedication() {
        // return medication string
        return medication;
    }

    public Date getReceivedDate() {
        // date
        return receivedDate;
    }

    public String getStatus() {
        // status
        return status;
    }

    public void setStatus(String status) {
        // update status
        this.status = status;
    }
}
