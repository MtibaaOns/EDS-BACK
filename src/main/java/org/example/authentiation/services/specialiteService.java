package org.example.authentiation.services;


import jakarta.transaction.Transactional;
import org.example.authentiation.entities.specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.authentiation.repositories.specialiteRepo;
import org.example.authentiation.exception.specialiteNotFoundException;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class specialiteService {
    private final specialiteRepo specialiteRepo;

    @Autowired
    public specialiteService(specialiteRepo specialiteRepo) {
        this.specialiteRepo = specialiteRepo;
    }

    private static Integer idCounter2 = 0;

    public specialite addSpecialite(specialite specialite) {
        Integer newcodeSpec = generateUniquecodeSpec();
        specialite.setCodeSpec(newcodeSpec);
        return specialiteRepo.save(specialite);
    }

    public specialite addSpecialite(String libSpec, String code) {
        specialite newSpecialite = new specialite(libSpec, code);
        Integer newcodeSpec = generateUniquecodeSpec();
        newSpecialite.setCodeSpec(newcodeSpec);
        return specialiteRepo.save(newSpecialite);
    }

    private synchronized Integer generateUniquecodeSpec() {
        return ++idCounter2;
    }

    public List<specialite> findAllSpecialites() {
        return specialiteRepo.findAll();
    }

    public specialite updateSpecialite(specialite specialite, Integer codeSpec, String libSpec) {
        Optional<specialite> optionalSpecialite = specialiteRepo.findSpecialiteBycodeSpec(codeSpec);
        specialite myspecialite = optionalSpecialite.orElseThrow(() -> new specialiteNotFoundException("specialite by id " + codeSpec + " was not found"));
        myspecialite.setLibSpec(libSpec);
        return specialiteRepo.save(myspecialite);
    }

    public specialite findSpecialiteBycodeSpec(Integer codeSpec) {
        return specialiteRepo.findSpecialiteBycodeSpec(codeSpec).orElseThrow(() -> new specialiteNotFoundException("specialite by id " + codeSpec + " was not found"));
    }

    public void deleteSpecialite(Integer codeSpec) {
        specialiteRepo.deleteSpecialiteByCodeSpec(codeSpec);
    }
}