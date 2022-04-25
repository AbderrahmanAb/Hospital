package a.enset.Hospital.service;

import a.enset.Hospital.entities.Consultation;
import a.enset.Hospital.entities.Medecin;
import a.enset.Hospital.entities.Patient;
import a.enset.Hospital.entities.RendezVous;
import a.enset.Hospital.repositories.ConsultationRepository;
import a.enset.Hospital.repositories.MedecinRepository;
import a.enset.Hospital.repositories.PatientRepository;
import a.enset.Hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saceConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
