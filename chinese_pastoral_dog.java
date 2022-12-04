public class chinese_pastoral_dog extends animal{
    private boolean isVaccineInjected;

    public chinese_pastoral_dog() {
        this.price=100;
    }

    public chinese_pastoral_dog(String name,int age,String gender, boolean isVaccineInjected) {
        this.price=100;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.isVaccineInjected = isVaccineInjected;
    }

    public boolean ISVaccineInjected() {
        return isVaccineInjected;
    }

    public void setIsVaccineInjected(boolean isVaccineInjected) {
        this.isVaccineInjected = isVaccineInjected;
    }

    public String toString() {
        return "中华的田园犬 姓名:" + this.name + " 年龄："+this.age+" 性别："+this.gender+" 买入价格："+ this.price+" 是否注射狂犬疫苗："+this.isVaccineInjected;
    }
}
