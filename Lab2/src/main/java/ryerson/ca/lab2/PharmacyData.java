/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.lab2;

import java.util.ArrayList;
/**
 *
 * @author Jeanie
 */
class PharmacyData {

    // list of prescriptions for prototype
    private ArrayList<Prescription> incoming = new ArrayList<>();

    public void addPrescription(Prescription p) {
        // add to list
        incoming.add(p);
    }

    public ArrayList<Prescription> getIncoming() {
        // return list
        return incoming;
    }
}