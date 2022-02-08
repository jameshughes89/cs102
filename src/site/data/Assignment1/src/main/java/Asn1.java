import java.io.IOException;

public class Asn1 {

    static final String RELATIVE_RESOURCES = "./src/main/resources/asn1/";

    public static void main(String[] args) throws IOException {

        CountryCatalogue catalogue = new CountryCatalogue();
        loadCountries(RELATIVE_RESOURCES + "data.txt",RELATIVE_RESOURCES + "continent.txt", catalogue);
        Country country;

        System.out.println("Check constructor, add, expand, search");
        country = catalogue.find("Canada");
        System.out.println(country);
        country = catalogue.find("Ghana");
        System.out.println(country);
        country = catalogue.find("Not a Country");
        System.out.println(country);

        System.out.println("\nCheck print");
        System.out.println(catalogue);

        System.out.println("\nCheck add");
        catalogue.add("Hughesland", 1, 1, "Hughes");
        country = catalogue.find("Hughesland");
        System.out.println(country);

        System.out.println("\nCheck remove");
        catalogue.remove("Hughesland");
        country = catalogue.find("Hughesland");
        System.out.println(country);
        catalogue.remove("Hughesland");
        country = catalogue.find("Hughesland");
        System.out.println(country);

        System.out.println("\nCheck number countries on continent");
        System.out.println(catalogue.numberCountriesOnContinent("North America"));
        System.out.println(catalogue.numberCountriesOnContinent("Hughes"));

        System.out.println("\nFilter countries by continent");
        CountryCatalogue filtered = catalogue.filterCountriesByContinent("North America");
        System.out.println(filtered);
        filtered = catalogue.filterCountriesByContinent("Hughes");
        System.out.println(filtered);

        System.out.println("\nCheck set population");
        catalogue.setPopulation("Canada", 1234567890);
        System.out.println(catalogue.find("Canada"));

        System.out.println("\nLargest population");
        System.out.println(catalogue.findCountryLargestPopulation());

        System.out.println("\nCheck largest continent population");
        System.out.println(catalogue.findMostPopulousContinent());
    }

    public static void loadCountries(String countryFile, String continentFile, CountryCatalogue catalogue) throws IOException {
        // Fill me in
    }
}