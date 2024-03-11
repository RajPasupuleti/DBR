package dao;

import java.util.List;
import java.util.Optional;
import model.VictimPojo;

public interface VictimDao {
    List<VictimPojo> fetchAllVictims();
    Optional<VictimPojo> fetchAVictim(int victimAge);
    List<VictimPojo> fetchByVaccinatedStatus(boolean isVaccinated);
    void removeVictim(int victimAge);
    VictimPojo addVictim(VictimPojo newVictim);
    VictimPojo updateVictim(VictimPojo updateVictim);
}