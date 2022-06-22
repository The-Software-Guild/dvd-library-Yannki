package dto;

public class Studio {
    private String name = "NA";
    private String location = "NA";

    public Studio(){}

    public Studio(String name) {
        this.name = name;
    }

    public Studio(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return name;
    }
}
