import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class CountryCatalogueTest {

    private static final Country EXISTING_COUNTRY = new Country("Name0", "Continent0", 10, 10.0);
    private static final Country NONEXISTENT_COUNTRY = new Country("Name99", "Continent99", 10, 10.0);


    private CountryCatalogue classUnderTest;
    private CountryCatalogue preState;

    @BeforeEach
    void createCountryCatalogues() {
        classUnderTest = new CountryCatalogue();
        preState = new CountryCatalogue();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void add_successfulAdd_returnsTrue() {
            assertTrue(classUnderTest.add(new Country("", "", 0, 0.0)));
        }

        @Test
        void remove_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.remove(NONEXISTENT_COUNTRY));
        }

        @Test
        void contains_empty_returnsFalse() {
            assertFalse(classUnderTest.contains(NONEXISTENT_COUNTRY));
        }

        @Test
        void indexOf_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.indexOf(NONEXISTENT_COUNTRY));
        }

        @Test
        void get_negativeIndex_throwsIndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(-1));
        }

        @Test
        void get_tooLargeIndex_throwsIndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(0));
        }

        @Test
        void smallestPopulationDensity_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.smallestPopulationDensity());
        }

        @Test
        void largestPopulationDensity_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.largestPopulationDensity());
        }

        @Test
        void filterByPopulationDensity_empty_returnsEmptyCountryCatalogue() {
            assertEquals(new CountryCatalogue(), classUnderTest.filterByPopulationDensity(0, 10000));

        }

        @Test
        void mostPopulousContinent_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.mostPopulousContinent());
        }

        @Test
        void isEmpty_empty_returnsTrue() {
            assertTrue(classUnderTest.isEmpty());
        }

        @Test
        void size_empty_returnsZero() {
            assertEquals(0, classUnderTest.size());
        }

        @Test
        void toString_empty_returnsEmptyString() {
            assertEquals("", classUnderTest.toString());
        }

        @Nested
        class WhenSingleton {

            @BeforeEach
            void addSingleCountry() {
                classUnderTest.add(new Country("Name0", "Continent0", 10, 10.0));
                preState.add(new Country("Name0", "Continent0", 10, 10.0));
            }

            @Test
            void add_successfulAdd_returnsTrue() {
                assertTrue(classUnderTest.add(new Country("", "", 0, 0.0)));
            }

            @Test
            void remove_singleton_emptyCollection() {
                classUnderTest.remove(EXISTING_COUNTRY);
                assertEquals(new CountryCatalogue(), classUnderTest);
            }

            @Test
            void remove_existingCountry_returnsTrue() {
                assertTrue(classUnderTest.remove(EXISTING_COUNTRY));
            }

            @Test
            void remove_existingCountry_removesFriend() {
                classUnderTest.remove(EXISTING_COUNTRY);
                assertFalse(classUnderTest.contains(EXISTING_COUNTRY));
            }

            @Test
            void remove_nonexistentCountry_throwsNoSuchElementException() {
                assertThrows(NoSuchElementException.class, () -> classUnderTest.remove(NONEXISTENT_COUNTRY));
            }

            @Test
            void contains_existingCountry_returnsTrue() {
                assertTrue(classUnderTest.contains(EXISTING_COUNTRY));
            }

            @Test
            void contains_nonexistentCountry_returnsFalse() {
                assertFalse(classUnderTest.contains(NONEXISTENT_COUNTRY));
            }

            @Test
            void indexOf_existingFriend_returnsCorrectIndex() {
                assertEquals(0, classUnderTest.indexOf(EXISTING_COUNTRY));
            }

            @Test
            void indexOf_nonexistentFriend_throwsNoSuchElementException() {
                assertThrows(NoSuchElementException.class, () -> classUnderTest.indexOf(NONEXISTENT_COUNTRY));
            }

            @Test
            void get_validIndex_returnsCorrectFriend() {
                assertEquals(EXISTING_COUNTRY, classUnderTest.get(0));
            }

            @Test
            void get_negativeIndex_throwsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(-1));
            }

            @Test
            void get_tooLargeIndex_throwsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(1));
            }

            @Test
            void smallestPopulationDensity_singleton_returnsCountry() {
                assertEquals(EXISTING_COUNTRY, classUnderTest.smallestPopulationDensity());
            }

            @Test
            void largestPopulationDensity_singleton_returnsCountry() {
                assertEquals(EXISTING_COUNTRY, classUnderTest.largestPopulationDensity());
            }

            @Test
            void filterByPopulationDensity_countryInRange_returnsCountryCatalogueWithCountry() {
                CountryCatalogue expected = new CountryCatalogue();
                expected.add(EXISTING_COUNTRY);
                assertEquals(expected, classUnderTest.filterByPopulationDensity(0, 2));
            }

            @Test
            void filterByPopulationDensity_countryAtLowerLimit_returnsCountryCatalogueWithCountry() {
                CountryCatalogue expected = new CountryCatalogue();
                expected.add(EXISTING_COUNTRY);
                assertEquals(expected, classUnderTest.filterByPopulationDensity(1, 2));
            }

            @Test
            void filterByPopulationDensity_countryAtUpperLimit_returnsEmptyCountryCatalogue() {
                assertEquals(new CountryCatalogue(), classUnderTest.filterByPopulationDensity(0, 1));
            }

            @Test
            void filterByPopulationDensity_countryNotInRange_returnsEmptyCountryCatalogue() {
                assertEquals(new CountryCatalogue(), classUnderTest.filterByPopulationDensity(10, 20));
            }

            @Test
            void mostPopulousContinent_singleton_returnsCorrectString() {
                assertEquals("Continent0", classUnderTest.mostPopulousContinent());
            }

            @Test
            void isEmpty_singleton_returnsFalse() {
                assertFalse(classUnderTest.isEmpty());
            }

            @Test
            void size_singleton_returnsOne() {
                assertEquals(1, classUnderTest.size());
            }

            @Test
            void toString_singleton_returnsCorrectString() {
                String expected = "Country(name=Name0, continent=Continent0, population=10, area=10.00)\n";
                assertEquals(expected, classUnderTest.toString());
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

                static Stream<Country> existingCountyObjectsStream() {
                    return Stream.of(new Country("Name0", "Continent0", 10, 10.0),
                            new Country("Name2", "Continent1", 1, 10.0),
                            new Country("Name4", "Continent2", 3, 10.0));
                }

                static Stream<Arguments> existingCountryObjectStreamAndIndices() {
                    return Stream.of(Arguments.of(new Country("Name0", "Continent0", 10, 10.0), 0),
                            Arguments.of(new Country("Name2", "Continent1", 1, 10.0), 2),
                            Arguments.of(new Country("Name4", "Continent2", 3, 10.0), 4));
                }

                @BeforeEach
                void addManyCountry() {
                    classUnderTest.add(new Country("Name1", "Continent1", 100, 10.0));
                    classUnderTest.add(new Country("Name2", "Continent1", 1, 10.0));
                    classUnderTest.add(new Country("Name3", "Continent2", 2, 10.0));
                    classUnderTest.add(new Country("Name4", "Continent2", 3, 10.0));
                    preState.add(new Country("Name1", "Continent1", 100, 10.0));
                    preState.add(new Country("Name2", "Continent1", 1, 10.0));
                    preState.add(new Country("Name3", "Continent2", 2, 10.0));
                    preState.add(new Country("Name4", "Continent2", 3, 10.0));
                }

                @Test
                void add_successfulAdd_returnsTrue() {
                    assertTrue(classUnderTest.add(new Country("", "", 0, 0.0)));
                }

                @ParameterizedTest
                @MethodSource("existingCountyObjectsStream")
                void remove_existingCountry_returnsTrue(Country country) {
                    assertTrue(classUnderTest.remove(country));
                }

                @ParameterizedTest
                @MethodSource("existingCountyObjectsStream")
                void remove_existingCountry_removesFriend(Country country) {
                    classUnderTest.remove(country);
                    assertFalse(classUnderTest.contains(country));
                }

                @Test
                void remove_nonexistentCountry_throwsNoSuchElementException() {
                    assertThrows(NoSuchElementException.class, () -> classUnderTest.remove(NONEXISTENT_COUNTRY));
                }

                @ParameterizedTest
                @MethodSource("existingCountyObjectsStream")
                void contains_existingCountry_returnsTrue(Country country) {
                    assertTrue(classUnderTest.contains(country));
                }

                @Test
                void contains_nonexistentCountry_returnsFalse() {
                    assertFalse(classUnderTest.contains(NONEXISTENT_COUNTRY));
                }

                @ParameterizedTest
                @MethodSource("existingCountryObjectStreamAndIndices")
                void indexOf_existingFriend_returnsCorrectIndex(Country country, int index) {
                    assertEquals(index, classUnderTest.indexOf(country));
                }

                @Test
                void indexOf_nonexistentFriend_throwsNoSuchElementException() {
                    assertThrows(NoSuchElementException.class, () -> classUnderTest.indexOf(NONEXISTENT_COUNTRY));
                }

                @ParameterizedTest
                @MethodSource("existingCountryObjectStreamAndIndices")
                void get_validIndex_returnsCorrectFriend(Country country, int index) {
                    assertEquals(country, classUnderTest.get(index));
                }

                @Test
                void get_negativeIndex_throwsIndexOutOfBoundsException() {
                    assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(-1));
                }

                @Test
                void get_tooLargeIndex_throwsIndexOutOfBoundsException() {
                    assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(5));
                }

                @Test
                void smallestPopulationDensity_many_returnsCountryWithSmallestPopulationDensity() {
                    assertEquals(new Country("Name2", "Continent1", 1, 10.0),
                            classUnderTest.smallestPopulationDensity());
                }

                @Test
                void largestPopulationDensity_many_returnsCountryWithLargestPopulationDensity() {
                    assertEquals(new Country("Name1", "Continent1", 100, 10.0),
                            classUnderTest.largestPopulationDensity());
                }


                @Test
                void filterByPopulationDensity_countriesInRange_returnsCorrectCountryCatalogue() {
                    CountryCatalogue expected = new CountryCatalogue();
                    expected.add(new Country("Name2", "Continent1", 1, 10.0));
                    expected.add(new Country("Name3", "Continent2", 2, 10.0));
                    expected.add(new Country("Name4", "Continent2", 3, 10.0));
                    assertEquals(expected, classUnderTest.filterByPopulationDensity(0, 0.5));
                }

                @Test
                void filterByPopulationDensity_countriesAtLowerLimit_returnsCorrectCountryCatalogue() {
                    CountryCatalogue expected = new CountryCatalogue();
                    expected.add(new Country("Name3", "Continent2", 2, 10.0));
                    expected.add(new Country("Name4", "Continent2", 3, 10.0));
                    assertEquals(expected, classUnderTest.filterByPopulationDensity(0.2, 0.5));
                }

                @Test
                void filterByPopulationDensity_countriesAtUpperLimit_returnsCorrectCountryCatalogue() {
                    CountryCatalogue expected = new CountryCatalogue();
                    expected.add(new Country("Name2", "Continent1", 1, 10.0));
                    expected.add(new Country("Name3", "Continent2", 2, 10.0));
                    expected.add(new Country("Name4", "Continent2", 3, 10.0));
                    assertEquals(expected, classUnderTest.filterByPopulationDensity(0, 1.0));
                }

                @Test
                void filterByPopulationDensity_countriesNotInRange_returnsEmptyCountryCatalogue() {
                    assertEquals(new CountryCatalogue(), classUnderTest.filterByPopulationDensity(100, 200));
                }

                @Test
                void mostPopulousContinent_many_returnsCorrectString() {
                    assertEquals("Continent1", classUnderTest.mostPopulousContinent());
                }

                @Test
                void isEmpty_many_returnsFalse() {
                    assertFalse(classUnderTest.isEmpty());
                }

                @Test
                void size_singleton_returnsCorrectSize() {
                    assertEquals(5, classUnderTest.size());
                }

                @Test
                void toString_singleton_returnsCorrectString() {
                    String expected = """
                            Country(name=Name0, continent=Continent0, population=10, area=10.00)
                            Country(name=Name1, continent=Continent1, population=100, area=10.00)
                            Country(name=Name2, continent=Continent1, population=1, area=10.00)
                            Country(name=Name3, continent=Continent2, population=2, area=10.00)
                            Country(name=Name4, continent=Continent2, population=3, area=10.00)
                            """;
                    assertEquals(expected, classUnderTest.toString());
                }
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenDuplicate {

                @BeforeEach
                void addDuplicated() {
                    classUnderTest.add(new Country("Name1", "Continent1", 100, 10.0));
                    classUnderTest.add(new Country("Name0", "Continent0", 10, 10.0));
                    classUnderTest.add(new Country("Name3", "Continent2", 2, 10.0));
                    classUnderTest.add(new Country("Name30", "Continent20", 2, 10.0));
                    classUnderTest.add(new Country("Name10", "Continent10", 100, 10.0));
                    classUnderTest.add(new Country("Name0", "Continent0", 10, 10.0));
                }

                @Test
                void remove_duplicates_removesFirstOccurrence() {
                    classUnderTest.remove(EXISTING_COUNTRY);
                    assertEquals(1, classUnderTest.indexOf(EXISTING_COUNTRY));
                }

                @Test
                void remove_allDuplicates_removesAllOccurrence() {
                    classUnderTest.remove(EXISTING_COUNTRY);
                    classUnderTest.remove(EXISTING_COUNTRY);
                    classUnderTest.remove(EXISTING_COUNTRY);
                    assertFalse(classUnderTest.contains(EXISTING_COUNTRY));
                }

                @Test
                void indexOf_existingCountry_returnsIndexOfFirstOccurrence() {
                    assertEquals(0, classUnderTest.indexOf(EXISTING_COUNTRY));
                }

                @Test
                void smallestPopulationDensity_duplicate_returnsFirstOccurrence() {
                    assertEquals(new Country("Name3", "Continent2", 2, 10.0),
                            classUnderTest.smallestPopulationDensity());
                }

                @Test
                void largestPopulationDensity_duplicate_returnsFirstOccurrence() {
                    assertEquals(new Country("Name1", "Continent1", 100, 10.0),
                            classUnderTest.largestPopulationDensity());
                }

                @Test
                void filterByPopulationDensity_duplicateDensities_returnsCountryCatalogueWithAllDuplicates() {
                    CountryCatalogue expected = new CountryCatalogue();
                    expected.add(new Country("Name3", "Continent2", 2, 10.0));
                    expected.add(new Country("Name30", "Continent20", 2, 10.0));
                    assertEquals(expected, classUnderTest.filterByPopulationDensity(0.15, 0.25));
                }
            }
        }
    }

    @Nested
    class WhenLarge {

        @Test
        void add_large_successfullyExpandsCapacity() {
            for (int i = 0; i < 1000; i++) {
                classUnderTest.add(new Country("Name", "Continent", 1234567890, 98765432.10));
            }
            assertEquals(1000, classUnderTest.size());
        }
    }
}
