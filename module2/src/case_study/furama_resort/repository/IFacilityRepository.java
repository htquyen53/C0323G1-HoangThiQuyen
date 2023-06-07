package case_study.furama_resort.repository;

import case_study.furama_resort.model.facility.Facility;
import case_study.furama_resort.model.facility.House;
import case_study.furama_resort.model.facility.Room;
import case_study.furama_resort.model.facility.Villa;

import java.util.List;
import java.util.Map;

public interface IFacilityRepository {
    Map<Facility, Integer> getAll();

    List<Villa> getVillaList();

    List<House> getHouseList();

    List<Room> getRoomList();

    void addNew(Facility facility, int index);

    //    boolean containKey(Facility key);
    Facility getFacilityID(String id);
    List<Facility> getFacilityByName (String name);


}
