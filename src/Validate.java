
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Thao Chi
 */
public class Validate {
    private final static Scanner in = new Scanner(System.in);
    /*
    \\d{10} người dùng phải nhập số 10
    \\d* người dùng có thể nhập thêm số hoặc không
     */
    private static final String PHONE_VALID = "^\\d{10}\\d*$";

    /*
    [A-Za-z0-9.-+%]+ người dùng phải nhập từ a-z bỏ qua trường hợp, 0-9 và .-+% ít nhất một lần
    @ người dùng phải được nhập "@"
    [A-Za-z.-]+ người dùng phải nhập từ a-z bỏ qua trường hợp, "." "-" ít nhất một lần
    \\. người dùng phải nhập "."
    [A-Za-z]{2,4} người dùng phải nhập từ a-z bỏ qua 2 - 4 lần
     */
    private static final String EMAIL_VALID
            = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    //kiểm tra giới hạn số đầu vào của người dùng
    public static int checkInputIntLimit(int min, int max) {
        // vòng lặp cho đến khi người dùng nhập đúng
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //kiểm tra chuỗi đầu vào 
    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //kiểm tra đầu vào của người dùng y/Y hoặc n/N
    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    // kiểm tra số điện thoại có tối thiểu 10 ký tự
    public static String checkInputPhone() {
        while (true) {
            String result = checkInputString();
            if (result.matches(PHONE_VALID)) { // //kiểm tra điện thoại người dùng nhập có hợp lệ không
                return result;
            } else {
                System.err.println("Phone is number with minimum 10 characters");
                System.out.print("Enter again: ");
            }
        }
    }

    //kiểm tra email với định dạng <tên tài khoản>@<domain>. (ví dụ: annguyen@fpt.edu.vn)
    public static String checkInputEmail() {
        while (true) {
            String result = checkInputString();
            if (result.matches(EMAIL_VALID)) { // ktra email nhap vao
                return result;
            } else {
                System.err.println("Email with format <account name>@<domain>");
                System.out.print("Enter again: ");
            }
        }
    }

    // kiểm tra thứ hạng tốt nghiệp đầu vào của người dùng
    public static String checkInputGraduationRank() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }

    //kiểm tra id có tồn tại hay không
    public static boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist.");
                return false;
            }
        }
        return true;
    }

    //kiểm tra kinh nghiệm phải nhỏ hơn tuổi
    public static int checkInputExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = checkInputIntLimit(1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }

    }
}
