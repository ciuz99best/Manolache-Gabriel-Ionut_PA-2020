import java.util.*;
public class Main {
    public static void main(String[] args) {
        Resident resident0 = new Resident();
        Resident resident1 = new Resident();
        Resident resident2 = new Resident();
        Resident resident3 = new Resident();
        List<Resident> residents = new ArrayList<>();
        residents.add(resident0);
        residents.add(resident1);
        residents.add(resident2);
        residents.add(resident3);
        
        Hospital hospital0 = new Hospital(1,1);
        Hospital hospital1 = new Hospital(2,2);
        Hospital hospital2 = new Hospital(3,2);
        
        Set<Hospital> hospitals = new TreeSet<>();
        
        hospitals.add(hospital0);
        hospitals.add(hospital1);
        hospitals.add(hospital2);
        
        resident0.addHospital(hospital0);
        resident0.addHospital(hospital1);
        resident0.addHospital(hospital2);
        
        
        resident1.addHospital(hospital0);
        resident1.addHospital(hospital1);
        resident1.addHospital(hospital2);
        
        
        resident2.addHospital(hospital0);
        resident2.addHospital(hospital1);
        
        
        resident3.addHospital(hospital0);
        resident3.addHospital(hospital2);
        
        hospital0.addResident(resident3);
        hospital0.addResident(resident0);
        hospital0.addResident(resident1);
        hospital0.addResident(resident2);
        
        hospital1.addResident(resident0);
        hospital1.addResident(resident2);
        hospital1.addResident(resident1);
        
        hospital2.addResident(resident0);
        hospital2.addResident(resident1);
        hospital2.addResident(resident3);
        
        
        Collections.sort(residents, (Resident rresident1, Resident rresident2) -> { 
            return rresident1.compareTo(rresident2);
        });
        Map<Resident, ArrayList<Hospital>> hashMapResidents = new HashMap<>();
        
        hashMapResidents.put(resident0, resident0.getPreferences());
        hashMapResidents.put(resident1, resident1.getPreferences());
        hashMapResidents.put(resident2, resident2.getPreferences());
        hashMapResidents.put(resident3, resident3.getPreferences());
        
        Map<Hospital, ArrayList<Resident>> treeMapHospitals = new TreeMap<>();
        
        treeMapHospitals.put(hospital0, hospital0.getPreferences());
        treeMapHospitals.put(hospital1, hospital1.getPreferences());
        treeMapHospitals.put(hospital2, hospital2.getPreferences());
        
        System.out.println("\nResidentts preffering both hospital0 and hospital2:");
        hashMapResidents.entrySet().stream()
                .filter(res -> res.getValue().contains(hospital0) || res.getValue().contains(hospital2))
                .forEach(res -> System.out.println(res));
        
        System.out.println("\nHospitals with top pref = Resident0");
        treeMapHospitals.entrySet().stream()
                .filter(hos -> hos.getValue().indexOf(resident0) == 0 )
                .forEach(hos -> System.out.println(hos));
        
    }
    
}
