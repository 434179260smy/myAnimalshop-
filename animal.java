public  abstract class  animal {
    protected String name;
    protected int age;
    protected double price;
    protected String gender;

    public animal(String name,int age,double price,String gender){
        this.name=name;
        this.age=age;
        this.price=price;
        this.gender=gender;
    }


    public animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public abstract String  toString();


}
