import java.util.LinkedList;
import java.util.Scanner;

public abstract class test {
    abstract MyAnimalShop shop();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("你经营了一家宠物店，现在你有的宠物如下");
        MyAnimalShop shop=new MyAnimalShop();
        chinese_pastoral_dog dog_1=new chinese_pastoral_dog("旺财",1,"雄性",true);
        chinese_pastoral_dog dog_2=new chinese_pastoral_dog("大黄",2,"雄性",false);
        cat cat_1=new cat("佳咪",1,"雄性");
        cat cat_2=new cat("小咪",2,"雌性");
        fish fish_1=new fish("小红",1,"雄性");
        fish fish_2=new fish("小蓝",2,"雌性");
        LinkedList<animal> animal=new LinkedList<>();
        animal.add(dog_1);
        animal.add(dog_2);
        animal.add(cat_1);
        animal.add(cat_2);
        animal.add(fish_1);
        animal.add(fish_2);
        shop.setAnimals(animal);
        shop.setBalance(500);
        shop.setTurnover(0);
        shop.showAnimallist();
        LocalDate date=new LocalDate();
        System.out.println("敢问今夕是何年？（请输入分别输入年月日）");
        date.setYear(sc.nextInt());
        while(true){
            if(date.getYear()<0){
                System.out.println("你输入的年份有错误哦，请重新输入");
                date.setYear(sc.nextInt());
            }
            else {
                break;
            }
        }
        date.setMonth(sc.nextInt());
        while(true){
            if(date.getMonth()<0||date.getMonth()>12){
                System.out.println("你输入的月份有错误哦，请重新输入");
                date.setMonth(sc.nextInt());
            }
            else {
                break;
            }
        }
        date.setDay(sc.nextInt());
        while(true){
            if(date.getDay()<0||date.getDay()>31){
                System.out.println("你输入的日期有错哦，请重新输入");
                date.setDay(sc.nextInt());
            }
            else  {

                if(date.getMonth()==1||date.getMonth()==3||date.getMonth()==5||date.getMonth()==7||date.getMonth()==8||date.getMonth()==10||date.getMonth()==12){
                    break;
                }
                else if (date.getMonth()==4||date.getMonth()==6||date.getMonth()==9||date.getMonth()==11) {
                    if(date.getDay()==31) {
                        System.out.println("你输入的日期有错哦，请重新输入");
                        date.setDay(sc.nextInt());
                    }
                    else {
                        break;
                    }
                }
                else {
                    if(date.getYear()%4==0){
                        if(date.getDay()>29){
                            System.out.println("你输入的日期有错哦，请重新输入");
                            date.setDay(sc.nextInt());
                        }
                        else {
                            break;
                        }
                    }
                    else{
                        if(date.getDay()>28){
                            System.out.println("你输入的日期有错哦，请重新输入");
                            date.setDay(sc.nextInt());
                        }
                        else {
                            break;
                        }
                    }
                }

            }
        }
        System.out.println("现在的日期是"+date.toString());
        System.out.println("你现在的余额的是："+shop.getBalance());
        System.out.println("请问你是否还要在宠物店开业之前买一些宠物丰富你的店呢？1 是 2 否");
        int choose=sc.nextInt();
        while(true){
            int flag=0;
            switch (choose){
                case 1:
                    shop.buyAnimal();
                    System.out.println("请问你是否还要在宠物店开业之前买一些宠物丰富你的店呢？1 是 2 否");
                    choose=sc.nextInt();
                    break;
                case 2:
                    flag=1;
                    break;
                default:
                    System.out.println("选择错误，请重新选择");
                    System.out.println("请问你是否还要在宠物店开业之前买一些宠物丰富你的店呢？1 是 2 否");
                    choose=sc.nextInt();
            }
            if(flag==1){
                break;
            }
        }
        System.out.println("你的宠物店正式开业啦，由于你的人手不够，你只能在每天歇业之后再去宠物市场买进宠物");
        System.out.println("这是你宠物店开业的第一天");
        System.out.println("你要干嘛呢：1 接待客人 2 歇业 ");
        choose=sc.nextInt();
        while(true){
            int flag=0;
            switch (choose){
                case 1:
                    Costomer costomer=new Costomer();
                    costomer.setTime(date);
                    System.out.println("你看到迎面走过来一位客人，经过交流之后,你得知他的名字是");
                    costomer.setName(sc.next());
                    shop.costomer(costomer);
                    System.out.println("你要干嘛呢：1 接待客人 2 歇业 ");
                    choose=sc.nextInt();
                    break;
                case 2:
                    System.out.println("经过你今天的辛勤劳动");
                    shop.shutDown();
                    int choose_2;
                    System.out.println("你要做些啥呢：1 买入宠物 2 进入第二天 3 关门大吉 ");
                    choose_2=sc.nextInt();
                    int nextflag=0;
                    while (true){
                        switch (choose_2){
                            case 1:
                                shop.buyAnimal();
                                System.out.println("你要做些啥呢：1 买入宠物 2 进入第二天 3 关门大吉 ");
                                choose_2=sc.nextInt();
                                break;
                            case 2:
                                if(date.getMonth()==1||date.getMonth()==3||date.getMonth()==5||date.getMonth()==7||date.getMonth()==8||date.getMonth()==10){
                                    if(date.getDay()+1==32){
                                        date.setMonth(date.getMonth()+1);
                                        date.setDay(1);
                                    }
                                    else {
                                        date.setDay(date.getDay()+1);
                                    }
                                }
                                else if(date.getMonth()==12){
                                    if(date.getDay()+1==32){
                                        date.setDay(1);
                                        date.setMonth(1);
                                        date.setYear(date.getYear()+1);
                                    }
                                    else {
                                        date.setDay(date.getDay()+1);
                                    }
                                }
                                else if (date.getMonth()==4||date.getMonth()==6||date.getMonth()==9||date.getMonth()==11) {
                                    if(date.getDay()+1==31){
                                        date.setMonth(date.getMonth()+1);
                                        date.setDay(1);
                                    }
                                    else {
                                        date.setDay(date.getDay()+1);
                                    }
                                }
                                else {
                                    if(date.getYear()%4==0){
                                        if (date.getDay()+1==29){
                                            date.setDay(1);
                                            date.setMonth(date.getMonth()+1);
                                        }
                                        else {
                                            date.setDay(date.getDay()+1);
                                        }
                                    }
                                    else {
                                        if(date.getDay()+1==28){
                                            date.setDay(1);
                                            date.setMonth(date.getMonth()+1);
                                        }
                                        else {
                                            date.setDay(date.getDay()+1);
                                        }
                                    }
                                }
                                System.out.println("今天的日期是："+date.toString());
                                nextflag =1;
                                break;
                            case 3:
                                nextflag=1;
                                flag=1;
                                break;
                            default:
                                System.out.println("选择错误，请重新选择");
                                System.out.println("你要做些啥呢：1 买入宠物 2 进入第二天 3 关门大吉 ");
                                choose_2=sc.nextInt();
                        }
                        if(nextflag==1){
                            break;
                        }
                    }
                    if(flag==0){
                        System.out.println("你要干嘛呢：1 接待客人 2 歇业 ");
                        choose=sc.nextInt();
                    }
                    else {

                    }
                    break;
                default:
                    System.out.println("没有这个选项请重新选择哦");
                    System.out.println("你要干嘛呢：1 接待客人 2 歇业 ");
                    choose = sc.nextInt();
            }
            if(flag==1){
                break;
            }
        }
        System.out.println("以下是你接待的客人");
        shop.showcostomers();
        double profit=shop.getBalance()-500;
        if(profit<0){
            System.out.println("经过你的苦心经营，你的余额相比开店之前变少了，也许你在其他方面更有天赋");
        }
        else {
            System.out.println("经过你的苦心经营，你的余额相比开店之前变多了，也许开店创业个不错选择");
        }
    }
}
