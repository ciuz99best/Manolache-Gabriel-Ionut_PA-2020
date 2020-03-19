import java.util.*;
public class Hospital implements Comparable, Comparator<Hospital> {
    ArrayList<Resident> preferences;
    int capacity;
    int id;

    public Hospital(int newCapacity) {
        this.capacity = newCapacity;
        preferences = new ArrayList<>();
    }

    public Hospital(int newId, int newCapcacity) {
        this.capacity = newCapcacity;
        this.id = newId;
        preferences = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    
    public int getCapacity() {
        return capacity;
    }

    
    public ArrayList<Resident> getPreferences() {
        return preferences;
    }

    public void setPreferences(ArrayList<Resident> newPreferences) {
        this.preferences = newPreferences;
    }
    
    public boolean addResident(Resident newResident)
    {
        if(preferences.size() < capacity)
        {
            preferences.add(newResident);
            return true;
        }
        else
            return false;
    }
    
    public boolean addResident(Resident newResident, int preferenceLevel)
    {
        if(this.preferences.size() < capacity)
        {
            this.preferences.add(preferenceLevel < preferences.size() ? preferenceLevel : preferences.size(),newResident);
            return true;
        }
        else
            return false;
    }

    @Override
    public int compareTo(Object arg0) {
        final Hospital other = (Hospital) arg0;
        if (this.id >= other.id) {
            return 1;
        }
        else
            return -1;
    }

    @Override
    public int compare(Hospital arg0, Hospital arg1) {
        if(arg0.getPreferences().size()< arg1.getPreferences().size())
            return -1;
        if(arg0.getPreferences().size() == arg0.getPreferences().size())
            return 0;
        return 1;
    }
    
    
    
}
