package daos;

public class Bikes implements DTOInterface {
    private String Make;
    private String Model;
    private int Year;
    private String Color;
    private Integer Size;
    private int Id;

    public Bikes(String Make, String Model, int Year, String Color, Integer Size, int Id){
        this.Make = Make;
        this.Model = Model;
        this.Year = Year;
        this.Color = Color;
        this.Size = Size;
        this.Id = Id;
    }
    public Bikes(String Make, String Model, int Year, String Color, Integer Size){
        this.Make = Make;
        this.Model = Model;
        this.Year = Year;
        this.Color = Color;
        this.Size = Size;
    }
    public Bikes(){}

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getYear() {
        return Year;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setYear(int year) {
        Year = year;
    }

    public Integer getSize() {
        return Size;
    }

    public void setSize(Integer size) {
        Size = size;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Bikes [id= " + getId() + ", color= " + getColor() + ", make= " + getMake() +
                ", model= " + getModel() + ", size= " + getSize() + ", year= " + getYear() + "]";
    }
}
