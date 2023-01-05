import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void getName_onlyUseCase_returnsName() {
        Country country = new Country("Name", "Continent", 1234567890, 98765432.10);
        assertEquals("Name", country.getName());
    }

    @Test
    void getContinent_onlyUseCase_returnsContinent() {
        Country country = new Country("Name", "Continent", 1234567890, 98765432.10);
        assertEquals("Continent", country.getContinent());
    }

    @Test
    void getPopulation_onlyUseCase_returnsPopulation() {
        Country country = new Country("Name", "Continent", 1234567890, 98765432.10);
        assertEquals(1234567890, country.getPopulation());
    }

    @Test
    void getArea_onlyUseCase_returnsArea() {
        Country country = new Country("Name", "Continent", 1234567890, 98765432.10);
        assertEquals(98765432.10, country.getArea());
    }

    @Test
    void populationDensity_generalCase_returnsPopulationDensity() {
        Country country = new Country("Name", "Continent", 1234567890, 98765432.10);
        assertEquals(12.4999998861, country.populationDensity(), 0.00000000001);
    }

    @Test
    void populationDensity_zeroPopulation_returnsZero() {
        Country country = new Country("Name", "Continent", 0, 98765432.10);
        assertEquals(0, country.populationDensity());
    }

    @Test
    void populationDensity_zeroArea_returnsInfinity() {
        Country country = new Country("Name", "Continent", 1234567890, 0);
        assertTrue(Double.isInfinite(country.populationDensity()));
    }

    @Test
    void toString_onlyUseCase_returnsString() {
        Country country = new Country("Name", "Continent", 1234567890, 98765432.10000);
        assertEquals("Country(name=Name, continent=Continent, population=1234567890, area=98765432.10)",
                country.toString());
    }

    @Test
    void equals_equalCountryObjects_areEqual(){
        Country countryA = new Country("Name", "Continent", 1234567890, 98765432.10000);
        Country countryB = new Country("Name", "Continent", 1234567890, 98765432.10000);
        assertEquals(countryA, countryB);
    }

    @Test
    void equals_unequalCountryObjects_areNotEqual(){
        Country countryA = new Country("Name", "Continent", 1234567890, 98765432.10000);
        Country countryB = new Country("Eman", "Tnenitnoc", 987654321, 123456789.0);
        assertNotEquals(countryA, countryB);
    }
}
