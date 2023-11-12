package finaltext2;

import java.util.AbstractList;
import java.util.Arrays;

public class user {
    String name;
    AbstractList<String> destination;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractList<String> getDestination() {
        return destination;
    }

    public void setDestination(AbstractList<String> destination) {
        this.destination = destination;
    }

    public user() {
    }

    public user(String name, AbstractList<String> destination) {
        this.name = name;
        this.destination = destination;
    }
}
