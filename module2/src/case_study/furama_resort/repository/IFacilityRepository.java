package case_study.furama_resort.repository;

import case_study.furama_resort.model.facility.Facility;

import java.util.Map;

public interface IFacilityRepository {
    Map<Facility, Integer> getAll();
    void addNew(Facility facility, int index);
//    boolean containKey(Facility key);
    Facility checkFacilityID (String id);

}
