package finaltext;

import java.time.LocalDateTime;

public class Order {
    private int user;
    private String name;
    private LocalDateTime time;
    private Double price;

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order() {
    }

    public Order(int user, String name, LocalDateTime time, Double price) {
        this.user = user;
        this.name = name;
        this.time = time;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", price=" + price +
                '}';
    }
}
