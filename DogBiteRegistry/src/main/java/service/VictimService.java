package service;

import java.util.List;
import java.util.Optional;
import model.VictimPojo;

public interface VictimService {
    List<VictimPojo> fetchAllVictims();
    Optional<VictimPojo> fetchAVictim(int victimAge);
    List<VictimPojo> fetchByVaccinatedStatus(boolean isVaccinated);
    void removeVictim(int victimAge);
    VictimPojo addVictim(VictimPojo newVictim);
    VictimPojo updateVictim(VictimPojo updateVictim);
}