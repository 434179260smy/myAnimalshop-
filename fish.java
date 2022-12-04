public class fish extends animal{

    public fish() {
        this.price=50;
    }

    public fish(String name,int age,String gender) {
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.price=50;
    }

    public String toString() {

        return "鱼 姓名:" + this.name + " 年龄："+this.age+" 性别："+this.gender+" 买入价格："+ this.price;
    }
}
