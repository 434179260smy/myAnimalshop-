public class cat extends animal{


    public cat() {
        this.price=200;
    }

    public cat(String name,int age,String gender) {
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.price = 200;
    }


    public String toString() {
        return "猫猫 姓名:" + this.name + " 年龄："+this.age+" 性别："+this.gender+" 买入价格："+ this.price;
    }
}
