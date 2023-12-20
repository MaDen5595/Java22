import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RPN{
    public static void main(String[] args) {
        Stack<Double> nums = new Stack<>();
        Pattern sym = Pattern.compile("[a-zA-Z]+");
        Matcher m;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите запись RPN: ");
        String[] rpn = sc.nextLine().split(" ");
        label:
        for (String s : rpn) {
            m = sym.matcher(s);
            boolean b = m.matches();
            if(b){
                System.out.println("Без букв");
                flag = false;
                break;
            }
            else{
                switch (s) {
                    case "+" -> {
                        if (nums.size() < 2) {
                            System.out.println("Ты по моему перепутал");
                            flag = false;
                            break label;
                        }
                        Double fir = nums.pop();
                        Double sec = nums.pop();
                        nums.push(sec + fir);

                    }
                    case "-" -> {
                        if (nums.size() < 2) {
                            System.out.println("Ты по моему перепутал");
                            flag = false;
                            break label;
                        }
                        Double fir = nums.pop();
                        Double sec = nums.pop();
                        nums.push(sec - fir);
                    }
                    case "/" -> {
                        if (nums.size() < 2) {
                            System.out.println("Ты по моему перепутал");
                            flag = false;
                            break label;
                        }
                        Double fir = nums.pop();
                        Double sec = nums.pop();
                        nums.push(sec / fir);

                    }
                    case "*" -> {
                        if (nums.size() < 2) {
                            System.out.println("Ты по моему перепутал");
                            flag = false;
                            break label;
                        }
                        Double fir = nums.pop();
                        Double sec = nums.pop();
                        nums.push(sec * fir);

                    }
                    default -> nums.push(Double.parseDouble(s));
                }
            }
        }
        if(flag) {
            if(nums.size()!=1){
                System.out.println("Чёт цифр дофига");
            }
            else{
                System.out.println(nums.pop());
            }
        }
    }
}
