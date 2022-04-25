package a.enset.Hospital.service;

import a.enset.Hospital.entities.Consultation;
import a.enset.Hospital.entities.Medecin;
import a.enset.Hospital.entities.Patient;
import a.enset.Hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saceConsultation(Consultation consultation);
}
