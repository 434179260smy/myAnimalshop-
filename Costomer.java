public class Costomer {
    private  String name;
    private int frequency;
    private LocalDate time;

    public Costomer() {
    }

    public Costomer(String name, int frequency, LocalDate time) {
        this.name = name;
        this.frequency = frequency;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String toString() {
        return "顾客姓名：" + name + " 来店次数： " + frequency + " 最近到店时间： " + time.toString() ;
    }
}
