public class InsufficientBalanceException extends RuntimeException{

    public InsufficientBalanceException() {
        System.out.println("天呐，你的余额不能够买到这只宠物了，虽然你很喜欢，但是还是看看其他宠物吧");
    }

}
