package case_study.furama_resort.repository;

import case_study.furama_resort.common.ReadAndWriteCSV;
import case_study.furama_resort.model.facility.Facility;
import case_study.furama_resort.model.facility.House;
import case_study.furama_resort.model.facility.Room;
import case_study.furama_resort.model.facility.Villa;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    private static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    private static List<Villa> villaList = new ArrayList<>();
    private static List<House> houseList = new ArrayList<>();
    private static List<Room> roomList = new ArrayList<>();

    private static final String FACILITY_PATH = "module2/src/case_study/furama_resort/data/facility.csv";

    // Villa(String id, String name, Double usableArea, Double price, int maxQuantity, String typeRental, String roomStandard, Double poolArea, int floor)
    // House(String id, String name, Double usableArea, Double price, int maxQuantity, String typeRental, String roomStandard, int floor)
    // Room(String id, String name, Double usableArea, Double price, int maxQuantity, String typeRental, String freeService)
    @Override
    public Map<Facility, Integer> getAll() {
        List<String> facilityStr = ReadAndWriteCSV.readFile(FACILITY_PATH);
        facilityMap.clear();
        String[] info;
        for (String str : facilityStr) {
            info = str.split(",");
            if (info.length == 10) {
                facilityMap.put(new Villa(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]),
                                Integer.parseInt(info[4]), info[5], info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8])),
                        Integer.parseInt(info[9]));
            } else if (info.length == 9) {
                facilityMap.put(new House(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]),
                        Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7])), Integer.parseInt(info[8]));
            } else if (info.length == 8) {
                facilityMap.put(new Room(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]),
                        Integer.parseInt(info[4]), info[5], info[6]), Integer.parseInt(info[7]));
            }
        }
        return facilityMap;
    }

    @Override
    public List<Villa> getVillaList() {
        List<String> facilityStr = ReadAndWriteCSV.readFile(FACILITY_PATH);
        String[] info;
        for (String str : facilityStr) {
            info = str.split(",");
            if (info[1].contains("VL")) {
                villaList.add(new Villa(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]),
                        Integer.parseInt(info[4]), info[5], info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8])));
            }
        }
        return villaList;
    }

    @Override
    public List<House> getHouseList() {
        List<String> facilityStr = ReadAndWriteCSV.readFile(FACILITY_PATH);
        String[] info;
        for (String str : facilityStr) {
            info = str.split(",");
            if (info[1].contains("HO")) {
                houseList.add(new House(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]),
                        Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7])));
            }
        }
        return houseList;
    }

    @Override
    public List<Room> getRoomList() {
        List<String> facilityStr = ReadAndWriteCSV.readFile(FACILITY_PATH);
        String[] info;
        for (String str : facilityStr) {
            info = str.split(",");
            if (info[1].contains("HO")) {
                roomList.add(new Room(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]),
                        Integer.parseInt(info[4]), info[5], info[6]));
            }
        }
        return roomList;
    }


    @Override
    public void addNew(Facility facility, int index) {
        List<String> facilityStr = new ArrayList<>();
        if (facility.getId().contains("VL")) {
            facilityStr.add(getInfoVillaToCSV((Villa) facility, 0));
        } else if (facility.getId().contains("HO")) {
            facilityStr.add(getInfoHouseToCSV((House) facility, 0));
        } else if (facility.getId().contains("RO")) {
            facilityStr.add(getInfoRoomToCSV((Room) facility, 0));
        }
        ReadAndWriteCSV.writeFile(facilityStr, FACILITY_PATH, true);
    }

    @Override
    public Facility getFacilityID(String id) {
        facilityMap = getAll();
        for (Facility facility : facilityMap.keySet()) {
            if (facility.getId().equals(id)) {
                return facility;
            }
        }
        return null;
    }

    @Override
    public List<Facility> getFacilityByName(String name) {
        facilityMap = getAll();
        List<Facility> facilityList = new ArrayList<>();
        for (Facility key : facilityMap.keySet()) {
            if (key.getName().contains(name)) {
                facilityList.add(key);
            }
        }
        return facilityList;
    }


    public String getInfoVillaToCSV(Villa villa, Integer index) {
        return villa.getId() + "," + villa.getName() + "," + villa.getUsableArea() + "," + villa.getPrice() + "," +
                villa.getMaxQuantity() + "," + villa.getTypeRental() + "," + villa.getRoomStandard() + ","
                + villa.getPoolArea() + "," + villa.getFloor() + "," + index;
    }

    public String getInfoHouseToCSV(House house, Integer index) {
        return house.getId() + "," + house.getName() + "," + house.getUsableArea() + "," + house.getPrice() + "," +
                house.getMaxQuantity() + "," + house.getTypeRental() + "," + house.getRoomStandard() + "," + house.getFloor() +
                "," + index;
    }

    public String getInfoRoomToCSV(Room room, Integer index) {
        return room.getId() + "," + room.getName() + "," + room.getUsableArea() + "," + room.getPrice() + ","
                + room.getMaxQuantity() + "," + room.getTypeRental() + "," + room.getFreeService() + "," + index;
    }
}
