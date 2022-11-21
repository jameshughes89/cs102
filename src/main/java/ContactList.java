import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Class to keep track of a collection of Friend objects.
 */
public class ContactList {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int NOT_FOUND = -1;

    private int size;
    private Friend[] friends;

    public ContactList() {
        // Call the constructor that
        // takes an int as parameter
        this(DEFAULT_CAPACITY);
    }

    public ContactList(int capacity) {
        size = 0;
        friends = new Friend[capacity];
    }

    /**
     * Add a new friend to the ContactList.
     *
     * @param friend Friend object to add to the ContactList.
     * @return True if the friend was added successfully, false otherwise.
     */
    public boolean add(Friend friend) {
        // If we have run out of space in our array
        // we need to deal with it by making a new array
        if (size() == friends.length) {
            expandCapacity();
        }
        // Add friend to the next available spot
        friends[size] = friend;
        size++;
        return true;
    }

    /**
     * Private helper method for making room in the collection for new Friend objects. This method creates a new Friend
     * array twice the size of the original (this.friends), copies over the contents of the original Friends array in
     * order, and then assigns the friends class attribute to reference the new, bigger friends array.
     */
    private void expandCapacity() {
        // Make a new array of twice the size of the previous
        Friend[] newFriends = new Friend[friends.length * 2];

        // Copy over the contents of the friends array
        // to the new bigger friends array
        for (int i = 0; i < friends.length; ++i) {
            newFriends[i] = friends[i];
        }
        // Have friends now reference the new friends
        friends = newFriends;
    }

    /**
     * Check if a given Friend object exists within the collection.
     *
     * @param friend Friend object to check if it exists within the collection.
     * @return True if the Friend exists within the collection, false otherwise.
     */
    public boolean contains(Friend friend) {
        return find(friend) != NOT_FOUND;
    }

    /**
     * Private helper method to find and return the index of a given Friend object within the collection. If no such
     * Friend exists within the collection, a sentinel value of -1 is returned.
     *
     * @param friend Friend to find the index of.
     * @return Index of the Friend within the collection, or -1 if no such Friend exists.
     */
    private int find(Friend friend) {
        // Linear search for the friend we are trying to find
        for (int i = 0; i < size(); ++i) {
            if (friend.equals(friends[i])) {
                return i;
            }
        }
        // -1 will signify that we didn't find
        // what we were looking for
        return NOT_FOUND;
    }

    /**
     * Return the index of the specified Friend object within the collection. If no such Friend exists within the
     * collection, a NoSuchElementException is thrown.
     *
     * @param friend Friend object to find the index of within the collection.
     * @return Index of the Friend object.
     * @throws NoSuchElementException If no equal Friend object exists within the collection, throw an exception.
     */
    public int indexOf(Friend friend) {
        if (!contains(friend)) {
            throw new NoSuchElementException();
        }
        return find(friend);
    }

    /**
     * Return the Friend object at the specified index. If the provided index is out of bounds an
     * IndexOutOfBoundsException is thrown.
     *
     * @param index Index of the Friend object to be returned.
     * @return Friend object at the specified index.
     * @throws IndexOutOfBoundsException If an invalid index is provided.
     */
    public Friend get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return friends[index];
    }

    /**
     * Removes the specified Friend object from the collection. If no such Friend object exists, a
     * NoSuchElementException is thrown. The removed object is removed from the collection by being replaced in the
     * collection with the Friend object at the end of the collection. This, remove does not preserve the order of
     * the Friend objects within the collection.
     *
     * @param friend Friend object to remove from the collection.
     * @return True if the object was successfully removed, false otherwise.
     * @throws NoSuchElementException If the Friend object does not exist within the collection.
     */
    public boolean remove(Friend friend) {
        if (!contains(friend)) {
            throw new NoSuchElementException();
        }
        int removeIndex = find(friend);
        // Although removeIndex could be equal to size-1, thereby the Friend is overwritten by itself, this will not
        // matter since the array at index size-1 is set to null and size would be set to 0 regardless.
        friends[removeIndex] = friends[size - 1];
        friends[size - 1] = null;
        size--;
        return true;
    }

    /**
     * Clear the contents of the ContactList object; eliminate all Friends form the ContactList.
     */
    public void clear() {
        // Although the Friend object references may remain in the collection, by setting the size to 0, any new
        // additions will automatically overwrite any existing references to Friend objects.
        size = 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    //    public String toString() {
    //        String s = "";
    //        for (int i = 0; i < size(); i++) {
    //            s = s + friends[i].toString() + "\n";
    //        }
    //        return s;
    //    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            builder.append(friends[i].toString());
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContactList that = (ContactList) o;
        return this.size == that.size && Arrays.equals(this.friends, 0, this.size(), that.friends, 0, that.size());
    }

    @Override
    public final int hashCode() {
        int result = Objects.hash(this.size());
        for (int i = 0; i < this.size(); i++) {
            result = result * 97 + Objects.hashCode(this.friends[i]);
        }
        return result;
    }
}


