package org.example.authentiation.services;



import jakarta.transaction.Transactional;
import org.example.authentiation.entities.Société;
import org.example.authentiation.exception.SociétéNotFoundException;
import org.example.authentiation.repositories.SociétéRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SociétéService {
    private final SociétéRepo sociétéRepo;
@Autowired
    public SociétéService(SociétéRepo sociétéRepo) {
        this.sociétéRepo = sociétéRepo;
    }
    private static long idCounter = 0;
    public Société addSociété(Société société) {
        long newId = generateUniqueId();
        société.setId(newId);
        return sociétéRepo.save(société);
    }
    private synchronized long generateUniqueId() {
        return ++idCounter;
    }
    public List<Société> findAllSociétés(){
    return sociétéRepo.findAll();
    }
    public Société updateSociété(Société société, Long id, String raisonSocial, String email,String adresse,String tel,String mf) {
        Optional<Société> optionalSociété = sociétéRepo.findSociétéById(id);
        Société mySociete = optionalSociété.orElseThrow(() -> new SociétéNotFoundException("Société by id " + id + " was not found"));

        // Mettre à jour les propriétés de mySociete avec les nouvelles valeurs
        mySociete.setRaisonSocial(raisonSocial);
        mySociete.setAdresse(adresse);
        mySociete.setEmail(email);
        mySociete.setTel(tel);
        mySociete.setMp(mf);
        // Vous pouvez également mettre à jour d'autres propriétés si nécessaire

        return sociétéRepo.save(mySociete);
    }
    public Société findSociétéById(Long id){
    return sociétéRepo.findSociétéById(id)
            .orElseThrow(() -> new SociétéNotFoundException("Société by id " + id + " was not found"));
    }
   public void deleteSociété(Long id){
       sociétéRepo.deleteSociétéById(id);
        }
    }









