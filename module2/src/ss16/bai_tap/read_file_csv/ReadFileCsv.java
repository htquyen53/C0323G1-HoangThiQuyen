package ss16.bai_tap.read_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCsv {
    public static void main(String[] args) {
        List<Country> countries = new ArrayList<>();
        Country country1 = new Country(1, "AU", "Australia");
        Country country2 = new Country(2, "CN", "China");
        Country country3 = new Country(3, "AU", "Australia");
        Country country4 = new Country(4, "CN", "China");
        Country country5 = new Country(5, "JP", "Japan");
        Country country6 = new Country(6, "CN", "China");
        Country country7 = new Country(7, "JP", "Japan");
        Country country8 = new Country(8, "TH", "ThaiLand");
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
        countries.add(country4);
        countries.add(country5);
        countries.add(country6);
        countries.add(country7);
        countries.add(country8);
        writeCountriesToFile(countries,"module2/src/ss16/bai_tap/read_file_csv/countries.csv");
        List<Country> countryList = readCountriesFromFile("module2/src/ss16/bai_tap/read_file_csv/countries.csv");
        for (Country country: countryList) {
            System.out.println(country.getInfoToCSV());
        }
    }

    static void writeCountriesToFile(List<Country> countries, String filePath) {
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < countries.size(); i++) {
                bufferedWriter.write(countries.get(i).getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static List<Country> readCountriesFromFile(String filePath) {
        List<Country> countries = new ArrayList<>();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] countryArray = line.split(",");
                Country country = new Country(Integer.parseInt(countryArray[0]), countryArray[1], countryArray[2]);
                countries.add(country);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countries;
    }
}
