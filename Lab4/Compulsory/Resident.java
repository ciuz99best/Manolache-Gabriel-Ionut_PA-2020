import java.util.*;
public class Resident implements Comparable,Comparator<Resident>{
    ArrayList<Hospital> preferences = new ArrayList<>();

    public ArrayList<Hospital> getPreferences() {
        return preferences;
    }

    public void setPreferences(ArrayList<Hospital> newPreferences) {
        this.preferences =  newPreferences;
    }
    public void addHospital(Hospital newHospital)
    {
        preferences.add(newHospital);
    }
    
    public void addHospital(Hospital newHospital, int preferenceLevel)
    {
        this.preferences.add(preferenceLevel < preferences.size() ? preferenceLevel : preferences.size(), newHospital );
    }
    

    @Override
    public int compareTo(Object arg0) {
        if(this.preferences.size()< ((Resident)arg0).getPreferences().size())
            return -1;
        if(this.preferences.size() == ((Resident)arg0).getPreferences().size())
            return 0;
        return 1;
    }

    @Override
    public int compare(Resident arg0, Resident arg1) {
        return 0;
    }
    
    
}
