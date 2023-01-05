/**
 * A CountryCatalogue is a collection for holding Country objects. The class responsibilities include adding/removing
 * and searching for Country objects. The class provides functionality to probe the catalogue about the population
 * densities of Country objects and determining the most populated continent.
 */
public class CountryCatalogue {


//    /**
//     * Two CountryCatalogue objects are equal if (a) all Country objects between the CountryCatalogue objects are equal
//     * and (b) the Country objects appear within the CountryCatalogue in the same order.
//     *
//     * @param o Other object to compare to.
//     * @return True if the CountryCatalogue objects are equal.
//     */
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (null == o || this.getClass() != o.getClass()) {
//            return false;
//        }
//        CountryCatalogue that = (CountryCatalogue) o;
//        // Compare the arrays' contents between 0 -- size
//        return Arrays.equals(this.catalogue, 0, this.size, that.catalogue, 0, that.size);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hash(this.size);
//        for (int i = 0; i < this.size; i++) {
//            result = 31 * result + Objects.hash(this.catalogue[i]);
//        }
//        return result;
//    }
}
