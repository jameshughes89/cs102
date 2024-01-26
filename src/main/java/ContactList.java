import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

// [start-class_fields_constructor]

/**
 * Class to keep track of a collection of Friend objects. The underlying contained for the class is an array that
 * will automatically "grow" to accommodate adding beyond the initial capacity.
 */
public class ContactList {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int NOT_FOUND = -1;

    private int size;
    private Friend[] friends;

    /**
     * Create an empty ContactList with the array container's capacity being set to the default capacity.
     */
    public ContactList() {
        // Calls the constructor that takes an int as parameter
        this(DEFAULT_CAPACITY);
    }

    /**
     * Create an empty ContactList with the array container's capacity being set to the specified size.
     *
     * @param initialCapacity Starting capacity of the fixed length array
     */
    public ContactList(int initialCapacity) {
        size = 0;
        friends = new Friend[initialCapacity];
    }
    // [end-class_fields_constructor]

    // [start-add]

    /**
     * Add a new friend to the ContactList.
     *
     * @param friend Friend object to add to the ContactList
     * @return True if the friend was added successfully, false otherwise
     */
    public boolean add(Friend friend) {
        // If we have run out of space in our array we need to deal with it by making a new array
        if (size() == friends.length) {
            friends = expandCapacity(friends);
        }
        // Add friend to the next available spot
        friends[size] = friend;
        size++;
        return true;
    }

    /**
     * Private helper method for making room in the collection for new Friend objects. This method creates a new Friend
     * array twice the size of the original (this.friends), copies over the contents of the original Friends array in
     * order, and then returns the new, bigger friends array.
     */
    private Friend[] expandCapacity(Friend[] oldFriends) {
        // Make a new array of twice the size of the previous
        Friend[] newFriends = new Friend[oldFriends.length * 2];

        // Copy over the contents of the friends array to the new bigger friends array
        for (int i = 0; i < oldFriends.length; i++) {
            newFriends[i] = oldFriends[i];
        }
        // Have friends now reference the new friends
        return newFriends;
    }
    // [end-add]

    // [start-contains_find]

    /**
     * Check if a given Friend object exists within the collection.
     *
     * @param friend Friend object to check if it exists within the collection
     * @return True if the Friend exists within the collection, false otherwise
     */
    public boolean contains(Friend friend) {
        return find(friend) != NOT_FOUND;
    }

    /**
     * Private helper method to find and return the index of a given Friend object within the collection. If no such
     * Friend exists within the collection, a sentinel value of -1 (NOT_FOUND constant) is returned.
     *
     * @param friend Friend to find the index of
     * @return Index of the Friend within the collection, or -1 (NOT_FOUND constant) if no such Friend exists
     */
    private int find(Friend friend) {
        // Linear search for the friend we are trying to find
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(friend, friends[i])) {
                return i;
            }
        }
        // -1 (NOT_FOUND constant) will signify that we didn't find what we were looking for
        return NOT_FOUND;
    }
    // [end-contains_find]

    // [start-indexOf]

    /**
     * Return the index of the specified Friend object within the collection. If no such Friend exists within the
     * collection, a NoSuchElementException is thrown.
     *
     * @param friend Friend object to find the index of within the collection
     * @return Index of the Friend object
     * @throws NoSuchElementException If no equal Friend object exists within the collection, throw an exception
     */
    public int indexOf(Friend friend) {
        if (!contains(friend)) {
            throw new NoSuchElementException(Objects.toString(friend));
        }
        return find(friend);
    }
    // [end-indexOf]

    // [start-get]

    /**
     * Return the Friend object at the specified index. If the provided index is out of bounds an
     * IndexOutOfBoundsException is thrown.
     *
     * @param index Index of the Friend object to be returned
     * @return Friend object at the specified index
     * @throws IndexOutOfBoundsException If an invalid index is provided (negative, or too large)
     */
    public Friend get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(index);
        }
        return friends[index];
    }
    // [end-get]

    // [start-remove]

    /**
     * Removes the specified Friend object from the collection. The removed object is removed from the collection by
     * being replaced in the  collection with the Friend object at the end of the collection. This, remove does not
     * preserve the order of the Friend objects within the collection.
     *
     * @param friend Friend object to remove from the collection
     * @return True if the object was successfully removed, false otherwise
     */
    public boolean remove(Friend friend) {
        if (!contains(friend)) {
            return false;
        }
        int removeIndex = find(friend);
        // Although it is possible that the element being removed is replaced with itself, which happens when it is the
        // last element being removed (when removedIndex is equal to size-1), this will not actually matter since size
        // is decreased by 1 (size--), meaning the next add would happen at the index removedIndex/size-1, thereby
        // overwriting that value anyway.
        friends[removeIndex] = friends[size - 1];
        // Further, by changing the last element to reference null, we know the data is gone.
        friends[size - 1] = null;
        size--;
        return true;
    }
    // [end-remove]

    // [start-clear]

    /**
     * Clear the contents of the ContactList object; eliminate all Friends form the ContactList.
     */
    public void clear() {
        friends = new Friend[friends.length];
        size = 0;
    }
    // [end-clear]

    // [start-isEmpty_size]
    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }
    // [end-isEmpty_size]

    // [start-toString]

    /**
     * Create a string representation of the ContactList. The string representation will be an aggregate of the
     * string representations of each of the Friend objects within the ContactList. Each Friend object's string will
     * be on its own line. If the ContactList is empty, an empty string is returned.
     *
     * @return String representation of the ContactList
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            builder.append(friends[i]);
            builder.append("\n");
        }
        return builder.toString();
    }
    // [end-toString]

    // [start-equals]

    /**
     * Checks if two ContactList objects are equal. ContactList objects are considered equal if the contents of their
     * friends field, an array, are all equal.
     *
     * @param o an "object" being compared to
     * @return True if the two objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContactList that = (ContactList) o;
        return Arrays.equals(this.friends, 0, this.size(), that.friends, 0, that.size());
    }
    // [end-equals]

    // [start-hashCode]
    @Override
    public int hashCode() {
        int result = Objects.hash(this.size);
        for (int i = 0; i < this.size(); i++) {
            result = result * 97 + Objects.hashCode(this.friends[i]);
        }
        return result;
    }
    // [end-hashCode]
}


