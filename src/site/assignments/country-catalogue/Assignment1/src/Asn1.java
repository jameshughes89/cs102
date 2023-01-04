import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Asn1 {

    private static final String RELATIVE_RESOURCES = "./resources/";

    public static void main(String[] args) throws IOException {
        // Load data
        CountryCatalogue countryCatalogue = new CountryCatalogue();
        String countryDataFileString = Files.readString(Paths.get(RELATIVE_RESOURCES + "country_data.csv"));
        String[] allCountryDataLines = countryDataFileString.split("(\r\n|\n)");
        for (String line : allCountryDataLines) {
            String[] countryData = line.split(",");
            Country country = new Country(countryData[0],
                    countryData[1],
                    Long.parseLong(countryData[2]),
                    Double.parseDouble(countryData[3]));
            countryCatalogue.add(country);
        }

        // Alter catalogue contents
        Country england = new Country("England", "Europe", 56489800, 130279.00);
        Country ecuador = new Country("Ecuador", "South America", 18048628, 256370.00);
        Country india = new Country("India", "Asia", 1375586000, 3287263.00);
        countryCatalogue.add(england);
        countryCatalogue.add(ecuador);
        countryCatalogue.add(india);
        countryCatalogue.remove(new Country("Canada", "North America", 34207000, 9976140.0));
        countryCatalogue.remove(new Country("South Korea", "Asia", 50503933, 98076.92));

        // Answering questions
        System.out.println(countryCatalogue.smallestPopulationDensity());
        System.out.println(countryCatalogue.largestPopulationDensity());
        System.out.println(countryCatalogue.mostPopulousContinent());

        // Save filtered data
        CountryCatalogue filteredCatalogue = countryCatalogue.filterByPopulationDensity(200, 450);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < filteredCatalogue.size(); i++) {
            Country country = filteredCatalogue.get(i);
            stringBuilder.append(String.format("%s, %s, %d, %.2f\n",
                    country.getName(),
                    country.getContinent(),
                    country.getPopulation(),
                    country.getArea()));
        }
        Files.writeString(Paths.get(RELATIVE_RESOURCES + "density-200_450.csv"), stringBuilder.toString());
    }
}
