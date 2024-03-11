package service;

import java.util.List;
import java.util.Optional;
import dao.VictimDao;
import dao.VictimDaoJdbcImpl;
import model.VictimPojo;

public class VictimServiceImpl implements VictimService {

    VictimDao victimDao;

    public VictimServiceImpl() {
        victimDao = new VictimDaoJdbcImpl();
    }

    @Override
    public List<VictimPojo> fetchAllVictims() {
        return victimDao.fetchAllVictims();
    }

    @Override
    public Optional<VictimPojo> fetchAVictim(int victimAge) {
        return victimDao.fetchAVictim(victimAge);
    }

    @Override
    public List<VictimPojo> fetchByVaccinatedStatus(boolean isVaccinated) {
        return victimDao.fetchByVaccinatedStatus(isVaccinated);
    }

    @Override
    public void removeVictim(int victimAge) {
        victimDao.removeVictim(victimAge);
    }

    @Override
    public VictimPojo addVictim(VictimPojo newVictim) {
        return victimDao.addVictim(newVictim);
    }

    @Override
    public VictimPojo updateVictim(VictimPojo updateVictim) {
        return victimDao.updateVictim(updateVictim);
    }
}
