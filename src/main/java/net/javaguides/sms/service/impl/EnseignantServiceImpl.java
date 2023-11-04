package net.javaguides.sms.service.impl;

import net.javaguides.sms.entity.Enseignants;
import net.javaguides.sms.repository.EnseignantsRepository;
import net.javaguides.sms.repository.StudentRepository;
import net.javaguides.sms.service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnseignantServiceImpl implements EnseignantService {

    @Autowired
    private EnseignantsRepository enseignantsRepository;

    @Override
    public List<Enseignants> getAllEnseignant() {
        return enseignantsRepository.findAll();
    }

    @Override
    public Enseignants saveEnseignant(Enseignants enseignants) {
        return enseignantsRepository.save(enseignants);
    }

    @Override
    public Enseignants getEnseignantById(Long id) {
        return enseignantsRepository.findById(id).get();
    }

    @Override
    public Enseignants updateEnseignant(Enseignants enseignants) {
        return enseignantsRepository.save(enseignants);
    }

    @Override
    public void deleteEnseignantById(Long id) {
        enseignantsRepository.deleteById(id);
    }
}
