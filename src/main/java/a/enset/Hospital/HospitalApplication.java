package a.enset.Hospital;

import a.enset.Hospital.entities.*;
import a.enset.Hospital.repositories.ConsultationRepository;
import a.enset.Hospital.repositories.MedecinRepository;
import a.enset.Hospital.repositories.RendezVousRepository;
import a.enset.Hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import a.enset.Hospital.repositories.PatientRepository;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {

		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	CommandLineRunner start(IHospitalService hospitalService,MedecinRepository MedecinRepository,PatientRepository PatientRepository,RendezVousRepository RendezVousRepository,ConsultationRepository ConsultationRepository ){
		return args -> {
			Stream.of("Mohammed","Hassan","Najat").forEach(name->{
				Patient patient = new Patient();
				patient.setNom(name);
				patient.setDateNaissance(new Date());
				patient.setMalade(false);
				hospitalService.savePatient(patient);

			});
			Stream.of("aymane","Hanane","yassmine").forEach(name->{
				Medecin medecin = new Medecin();
				medecin.setNom(name);
				medecin.setEmail(name+"@gmail.com");
				medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
				hospitalService.saveMedecin(medecin);

			});
			Patient patient = PatientRepository.getById(1L);
			Patient patient1 = PatientRepository.findByNom("Mohammed");
			Medecin medecin =MedecinRepository.findByNom("yassmine");
			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
         	rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			RendezVousRepository.save(rendezVous);
			RendezVous rendivous1 = RendezVousRepository.findById(1l).orElse(null);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendivous1);
			consultation.setRapport("Rapport de la consultation .........");
			ConsultationRepository.save(consultation);







		};
	}




}








