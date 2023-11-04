package net.javaguides.sms.service;


import net.javaguides.sms.entity.Enseignants;

import java.util.List;

public interface EnseignantService {

    List<Enseignants> getAllEnseignant();

    Enseignants saveEnseignant(Enseignants enseignants);

    Enseignants getEnseignantById(Long id);

    Enseignants updateEnseignant(Enseignants enseignants);

    void deleteEnseignantById(Long id);
}
