package entity;

public class Subject {
    private Integer id;
    private String name;
    private Integer hours;
    private Double cost;

    public Subject() {}

    public Subject(Integer id, String name, Integer hours, Double cost) {
        this.id = id;
        this.name = name;
        this.hours = hours;
        this.cost = cost;
    }

    public Subject(String name, Integer hours, Double cost) {
        this.name = name;
        this.hours = hours;
        this.cost = cost;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getHours() { return hours; }
    public void setHours(Integer hours) { this.hours = hours; }

    public Double getCost() { return cost; }
    public void setCost(Double cost) { this.cost = cost; }

    @Override
    public String toString() {
        return id + ". " + name + " - " + hours + "h - $" + cost;
    }
}
