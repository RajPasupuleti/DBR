import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import model.VictimPojo;
import presentation.Presentation;
import service.VictimService;
import service.VictimServiceImpl;

public class VictimController {
    VictimService victimService;

    public VictimController() {
        victimService = new VictimServiceImpl();
    }

    public void start() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            int option = Presentation.displayMenu();

            switch (option) {
                case 1:
                    List<VictimPojo> allVictims = victimService.fetchAllVictims();
                    Presentation.displayFetchAllAddresses(allVictims);
                    break;
                case 2:
                    int victimAge = Presentation.scanVictimAge();
                    Optional<VictimPojo> victimPojoOptional = victimService.fetchAVictim(victimAge);
                    Presentation.displayOptionalVictimPojo(victimPojoOptional);
                    break;
                case 3:
                    boolean vaccinationStatus = Presentation.scanVaccinationStatus();
                    List<VictimPojo> allVictimsStatus = victimService.fetchByVaccinatedStatus(vaccinationStatus);
                    if (allVictimsStatus.isEmpty()) {
                        Presentation.displayNoDogBreedFound(vaccinationStatus);
                    } else {
                        Presentation.displayFetchAllAddresses(allVictimsStatus);
                    }
                    break;
                case 4:
                    VictimPojo victim = Presentation.scanBookInput();
                    VictimPojo addedVictim = victimService.addVictim(victim);
                    Presentation.displayVictimPojo(addedVictim);
                    break;
                case 5:
                case 6:
                    int deleteVictimAge = Presentation.scanVictimAge();
                    Optional<VictimPojo> deleteVictimPojoOptional = victimService.fetchAVictim(deleteVictimAge);
                    Presentation.displayOptionalVictimPojo(deleteVictimPojoOptional);
                    if (deleteVictimPojoOptional.isPresent()) {
                        char ch = Presentation.displayConfirmation();
                        if (ch == 'y') {
                            victimService.removeVictim(deleteVictimAge);
                            Presentation.displayDeleteConfirmation(deleteVictimAge);
                        }
                    }
                    break;
                case 7:
                    Presentation.displayExitMessage();
                    System.exit(0);
                default:
                    Presentation.displayInvalidOptionMessage();
            }
        }
    }
}
