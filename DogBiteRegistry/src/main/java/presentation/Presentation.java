package presentation;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;


import model.VictimPojo;


public class Presentation {
	
	static Scanner scan;
	
	static {
		scan = new Scanner(System.in);
	}

	static public int displayMenu() {
		
		System.out.println("***********************************");
		System.out.println("DOG BITE REGISTRY");
		System.out.println("***********************************");
		System.out.println("MENU");
		System.out.println("***********************************");
		System.out.println("1. Fetch all Addresses");
		System.out.println("2. Fetch a Address");
		System.out.println("3. Fetch all Addresses by Age");
		System.out.println("4. Add a Address");
		System.out.println("5. Update a Address");
		System.out.println("6. Remove a Address");
		System.out.println("7. Exit");
		System.out.println("***********************************");
		System.out.println("Enter the menu option:");
		int option = scan.nextInt();
		return option;
		
		
		
	}
	
	public static void displayFetchAllAddresses(List<VictimPojo> allAddresses) {
		System.out.println("*******************************************************************************************************");
		System.out.println("VictimName\tVictimAge\t\t\t\t\t\tDogBreed\t\tVaccinatedStatus\t\tVictimAddress");
		System.out.println("*******************************************************************************************************");
		for(VictimPojo eachAddress: allAddresses) {
			System.out.println(eachAddress.getName() + "\t" + eachAddress.getAge() + "\t\t" + eachAddress.getDogBreed() + "\t\t" + eachAddress.isDogVaccinatedStatus() + "\t\t" + eachAddress.getAddress()) ;
		}
	}
	
	
	public static void displayExitMessage() {
		System.out.println("***********************************");
		System.out.println("Thankyou for using DBR");
		System.out.println("***********************************");
	}
	
	public static int scanVictimAge() {
		System.out.println("Enter Victim age:");
		int VictimAge = scan.nextInt();
		return VictimAge;
	}
	
	public static void displayOptionalVictimPojo(Optional<VictimPojo> optionalVP) {
		Optional<VictimPojo> optionalBP = java.util.Optional.empty();
		if(optionalBP.isPresent()) {
			System.out.println("***********************************");
			System.out.println("Victim Information");
			System.out.println("***********************************");
			System.out.println("Victim Age: " 				+ 	optionalVP.get().getAge());
			System.out.println("Victim Name: " 				+ 	optionalVP.get().getName());
			System.out.println("Dog Breed: " 				+ 	optionalVP.get().getDogBreed());
			System.out.println("Vaccinated Status: " 		+ 	optionalVP.get().isDogVaccinatedStatus());
			System.out.println("Victim Address: " 			+ 	optionalVP.get().getAddress());
			System.out.println("***********************************");
		} else {
			System.out.println("Sorry! Victim Address does not exist!");
		}
	}
	
	public static void displayInvalidOptionMessage() {
		System.out.println("***********************************");
		System.out.println("Invalid Menu Option. Please Try Again!");
		System.out.println("***********************************");
	}
	
	public static char displayConfirmation() {
		System.out.println("***********************************");
		System.out.println("Are you sure you want to remove the Address(y/n)?");
		System.out.println("***********************************");
		char ans = scan.next().charAt(0);
		return ans;
	}
	
	public static void displayDeleteConfirmation(int VictimAge) {
		System.out.println("***********************************");
		System.out.println("Victim with Age: " + VictimAge + " has been removed!");
		System.out.println("***********************************");
	}
	
	public static String scanDogBreed() {
		System.out.println("Please enter the Dog Breed:");
		String DogBreed = scan.next();
		return DogBreed;
	}
	
	public static void displayNoDogBreedFound(boolean vaccineStatus) {
		System.out.println("***********************************");
		System.out.println("No Adresses of partical dog breed are found: " + vaccineStatus);
		System.out.println("***********************************");
	}
	
	
	public static VictimPojo scanBookInput() {
		System.out.println("***********************************");
		System.out.println("Please enter Address of the victim...");
		System.out.println("***********************************");
		System.out.println("Enter Victim Address: ");
		scan.nextLine();
		String vAddress = scan.nextLine();
		System.out.println("Enter Dog Breed: ");
		String vDogBreed = scan.nextLine();
		System.out.println("Enter Victim Name: ");
		String vName = scan.nextLine();
		System.out.println("Enter Vaccinated Status: ");
		int vStatus = scan.nextInt();
		
		// construct the new victim pojo object
		VictimPojo newVictim = new VictimPojo(0, vAddress,  vDogBreed, vName, vStatus, "");
		return newVictim;

	}
	
	public static void displayVictimPojo(VictimPojo victim) {
		System.out.println("***********************************");
		System.out.println("New Victim Address added with victim age : " + victim.getAge());
		System.out.println("***********************************");
	}
	
	public static boolean scanVaccineStatus() {
        System.out.println("Enter Vaccinated Status (true/false):");
        return scan.nextBoolean();
    }
	
	public static VictimPojo scanVictimInput() {
	    System.out.println("***********************************");
	    System.out.println("Please enter details for the new victim...");
	    System.out.println("***********************************");
	    System.out.println("Enter Victim Address: ");
	    scan.nextLine(); // Consume the newline character left by previous nextInt or next
	    String vAddress = scan.nextLine();
	    System.out.println("Enter Dog Breed: ");
	    String vDogBreed = scan.nextLine();
	    System.out.println("Enter Victim Name: ");
	    String vName = scan.nextLine();
	    System.out.println("Enter Vaccinated Status (1 for true, 0 for false): ");
	    int vStatus = scan.nextInt();

	    // construct the new victim pojo object
	    VictimPojo newVictim = new VictimPojo(vName, 0, vDogBreed, vStatus == 1, vAddress);
	    return newVictim;
	}


}

