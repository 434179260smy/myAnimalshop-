import java.util.LinkedList;
import java.net.SocketOption;
import java.util.Scanner;


public class MyAnimalShop implements AnimalShop {
    Scanner sc = new Scanner(System.in);
    private double balance;
    private boolean isBusiness;
    private LinkedList<Costomer> costomers ;
    private LinkedList<animal> animals ;
    private LinkedList<Costomer> dayCostomers ;
    private double turnover =0;

    public void showAnimallist(){
        int i;
        for(i=0;i<this.animals.size();i++){
            System.out.println(animals.get(i).toString());
        }
    }
    public void showSellAnimallist(){
        int i;
        for(i=0;i<this.dayCostomers.size();i++){
            System.out.println(dayCostomers.get(i).toString());
        }
    }
    public void showcostomers(){
        int i;
        for(i=0;i<this.costomers.size();i++){
            System.out.println(costomers.get(i).toString());
        }
    }


    public MyAnimalShop(){
        dayCostomers=new LinkedList<Costomer>();
        costomers=new LinkedList<Costomer>();
        animals=new LinkedList<animal>();
    }



    @Override
    public void buyAnimal()     {
        System.out.println("请选择你要购买的宠物种类：1 中华田园犬 2 猫猫 3 鱼");
        int choose = sc.nextInt();
        int flag=0;
        while(true){
            switch (choose){
                case 1:
                    try {
                        if(balance-100<0){
                            throw new InsufficientBalanceException();
                        }
                        balance=balance-100;
                        chinese_pastoral_dog dog = new chinese_pastoral_dog();
                        System.out.println("请给中华田园犬取个名字吧");
                        dog.setName(sc.next());
                        System.out.println("这条中华田园犬的年龄是");
                        dog.setAge(sc.nextInt());
                        System.out.println("它的中华田园犬的性别是");
                        dog.setGender(sc.next());
                        System.out.println("是否注射狂犬疫苗 1 是 2 否");
                        int chooseTrue=sc.nextInt();
                        int IsVaccineInjectedflag=0;
                        while (true){
                            switch (chooseTrue){
                            case 1:
                                dog.setIsVaccineInjected(true);
                                IsVaccineInjectedflag=1;
                                break;
                            case 2:
                                dog.setIsVaccineInjected(false);
                                IsVaccineInjectedflag=1;
                                break;
                            default:
                                System.out.println("请重新输入");
                                chooseTrue=sc.nextInt();
                            }
                            if (IsVaccineInjectedflag==1){
                                break;
                            }
                        }

                        this.animals.add(dog);
                        flag=1;
                    }
                    catch (InsufficientBalanceException e){
                        flag=1;
                    }
                    break;
                case 2:
                    try {
                        if(balance-200<0){
                            throw new InsufficientBalanceException();
                        }
                        balance=balance-200;
                        cat Cat=new cat();
                        System.out.println("给这只猫的取个名字吧");
                        Cat.setName(sc.next());
                        System.out.println("这只猫的年龄是");
                        Cat.setAge(sc.nextInt());
                        System.out.println("它的性别是");
                        Cat.setGender(sc.next());
                        this.animals.add(Cat);
                        flag=1;
                    }
                    catch (InsufficientBalanceException e){flag=1;}
                    break;
                case 3:
                    try {
                        if(balance-50<0){
                            throw new InsufficientBalanceException();
                        }
                        balance=balance-50;
                        fish Fish=new fish();
                        System.out.println("给这条鱼取个名字吧");
                        Fish.setName(sc.next());
                        System.out.println("这条鱼的年龄是");
                        Fish.setAge(sc.nextInt());
                        System.out.println("它的性别是");
                        Fish.setGender(sc.next());
                        this.animals.add(Fish);
                        flag=1;
                    }
                    catch (InsufficientBalanceException e){
                        flag=1;
                    }
                    break;
                default:
                    System.out.println("选择错误，请重新进行操作");
                    System.out.println("请选择你要购买的宠物种类：1 中华田园犬 2 猫猫 3 鱼");
                    choose=sc.nextInt();
            }
            if(flag==1){
                break;
            }
        }


    }

    @Override
    public void costomer( Costomer costomer) {
        try{
            int j;
            int flag=0;
            for(j=0;j<costomers.size();j++){
                Costomer currCostomer;
                currCostomer = costomers.get(j);
                if(currCostomer.getName().equals(costomer.getName())){
                    flag=1;
                    currCostomer.setFrequency(currCostomer.getFrequency()+1);
                    currCostomer.setTime(costomer.getTime());
                    dayCostomers.add(costomers.get(j));
                    break;
                }
            }
            if(flag==0){
                costomer.setFrequency(1);
                costomers.add(costomer);
                dayCostomers.add(costomer);
            }
            flag=0;
            if(animals.size()==0) {
                throw new AnimalNotFoundException();
            }
            int i;
            System.out.println("这是这只宠物的信息");
            for(i=0;i<animals.size();i++){
                animal Animal;
                Animal= animals.get(i);

                System.out.println(Animal.toString());
                System.out.println("请问是否购买 1 买 2 不买");
                int choose=sc.nextInt();
                if(choose==1){
                    System.out.println("你正在和顾客商量价格，你想卖出的价格是：");
                    int sellPrice=sc.nextInt();
                    while(true){
                        if(sellPrice>Animal.price+100){
                            System.out.println("顾客觉得你是黑心商家，不愿意以这个价格买，重新输入你的价格");
                            sellPrice=sc.nextInt();
                        }
                        else if(sellPrice< Animal.price){
                            System.out.println("顾客很满意你的价格，愿意购买");
                            break;
                        }
                        else {
                            System.out.println("顾客虽然犹豫了，但还是买了");
                            break;
                        }
                    }

                    this.balance=this.balance+sellPrice;
                    turnover = turnover+sellPrice;
                    System.out.println(Animal.toString());
                    animals.remove(i);
                    break;
                }
                else if (choose==2) {
                    System.out.println("让我们看下一只宠物的信息");
                }
                else {
                    System.out.println("好叭，虽然你不想买，但是还是希望按照选项选择");
                    System.out.println("让我们看下一只宠物的信息");
                }

            }
        }
        catch (AnimalNotFoundException e){
        }
    }

    @Override
    public void shutDown() {
        System.out.println("今天的营业额是 "+this.turnover);
        this.turnover=0;
        int i;
        for(i=0;i<dayCostomers.size();i++){
            System.out.println(dayCostomers.get(i).toString());
        }
        dayCostomers.clear();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isIsBusiness() {
        return isBusiness;
    }

    public void setIsBusiness(boolean isBusiness) {
        this.isBusiness = isBusiness;
    }

    public LinkedList<Costomer> getCostomers() {
        return costomers;
    }

    public void setCostomers(LinkedList<Costomer> costomers) {
        this.costomers = costomers;
    }

    public LinkedList<animal> getAnimals() {
        return animals;
    }
    public void setAnimals(LinkedList<animal> animals) {
        this.animals = animals;
    }

    public LinkedList<Costomer> getdaycostomers() {
        return dayCostomers;
    }

    public void setSellAnimals(LinkedList<Costomer> dayCostomers) {
        this.dayCostomers = dayCostomers;
    }

    public double getTurnover() {
        return turnover;
    }
    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

}
