package a.enset.Hospital.repositories;

import a.enset.Hospital.entities.Medecin;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
