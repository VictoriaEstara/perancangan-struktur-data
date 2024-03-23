//Kode ini dibagikan oleh Dedad Fajar dan dapat diakses melalaui github: https://github.com/VictoriaEstara/perancangan-struktur-data

// About Infix Notation
    // Inifix Notation adalah Notasi standar yang digunakan dalam matematika pada kehidupan sehari-hari sehingga sering digunakan dalam pemrograman manusia.
    // Metode melakukan evaluasi Infix Notation, yakni menggunakan urutan operasi dan tanda kurung.

// About Postfix Notation
    // Postfix Notation adalah Notasi dimana operator ditempatkan setelah operand-operand yang sesuai, sehingga sering digunakan dalam pemrosesan komputer, terutama algoritma stack.
    // Metode melakukan evaluasi Postfix Notation, yakni menggunakan konsep membaca ekspresi dari kiri ke kanan dan menerapkan operator pada operand yang sesuai, tanpa memperhaikan tanda kurung.

// About Prefix Notation
    // Prefix Notation adalah Notasi dimana operator ditemapatkan sebelum operand-operand yang sesuai.
    // Metode melakukan eksekusi atau evaluasi Prefix Notation, yakni menggunakan konsep membaca ekspresi dari kanan ke kiri (operator terletak di depan dieksekusi terakhir).

import java.util.Stack;

public class kode {
    // Method untuk mengevaluasi ekspresi postfix
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == ' ') {
                continue; // Langsung ke iterasi berikutnya jika spasi
            } else if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch)); // Push operand ke stack
            } else {
                // Pop dua operand teratas, hitung, dan push hasilnya
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(ch, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop(); // Hasil evaluasi adalah nilai pada puncak stack
    }

    // Method untuk mengevaluasi ekspresi prefix
    public static int evaluatePrefix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);

            if (ch == ' ') {
                continue; // Langsung ke iterasi berikutnya jika spasi
            } else if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch)); // Push operand ke stack
            } else {
                // Pop dua operand teratas, hitung, dan push hasilnya
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                int result = performOperation(ch, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop(); // Hasil evaluasi adalah nilai pada puncak stack
    }

    // Method untuk melakukan operasi aritmatika
    public static int performOperation(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero!");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    // Method untuk mengkonversi ekspresi infix menjadi postfix
    public static String infixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            char ch = infixExpression.charAt(i);

            if (ch == ' ') {
                continue; // Langsung ke iterasi berikutnya jika spasi
            }

            if (Character.isDigit(ch)) {
                postfix.append(ch); // Tambahkan operand ke ekspresi postfix
            } else if (ch == '(') {
                stack.push(ch); // Push '(' ke stack
            } else if (ch == ')') {
                // Pop operator dari stack dan tambahkan ke ekspresi postfix hingga '('
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(" ").append(stack.pop());
                }
                stack.pop(); // Pop '(' dari stack
            } else {
                // Pop operator dari stack dan tambahkan ke ekspresi postfix jika memiliki presedensi lebih besar
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(" ").append(stack.pop());
                }
                stack.push(ch); // Push operator ke stack
            }
        }

        // Pop semua operator dari stack dan tambahkan ke ekspresi postfix
        while (!stack.isEmpty()) {
            postfix.append(" ").append(stack.pop());
        }

        return postfix.toString().trim(); // Return ekspresi postfix
    }

    // Method untuk mengkonversi ekspresi infix menjadi prefix
    public static String infixToPrefix(String infixExpression) {
        StringBuilder prefix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = infixExpression.length() - 1; i >= 0; i--) {
            char ch = infixExpression.charAt(i);

            if (ch == ' ') {
                continue; // Langsung ke iterasi berikutnya jika spasi
            }

            if (Character.isDigit(ch)) {
                prefix.insert(0, ch); // Masukkan operand ke awal ekspresi prefix
            } else if (ch == ')') {
                stack.push(ch); // Push ')' ke stack
            } else if (ch == '(') {
                // Pop operator dari stack dan tambahkan ke ekspresi prefix hingga ')'
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix.insert(0, stack.pop());
                }
                stack.pop(); // Pop ')' dari stack
            } else {
                // Pop operator dari stack dan tambahkan ke ekspresi prefix jika memiliki presedensi lebih besar
                while (!stack.isEmpty() && precedence(stack.peek()) > precedence(ch)) {
                    prefix.insert(0, stack.pop());
                }
                stack.push(ch); // Push operator ke stack
            }
        }

        // Pop semua operator dari stack dan tambahkan ke ekspresi prefix
        while (!stack.isEmpty()) {
            prefix.insert(0, stack.pop());
        }

        return prefix.toString(); // Return ekspresi prefix
    }

    // Method untuk menentukan presedensi operator
    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    // Method untuk menyisipkan spasi antara operator dan operand
    public static String insertSpaces(String expression) {
        StringBuilder result = new StringBuilder();
        boolean prevIsOperator = true;
        for (char ch : expression.toCharArray()) {
            if (ch == ' ') {
                continue; // Langsung ke iterasi berikutnya jika spasi
            }
            if (isOperator(ch) || ch == '(' || ch == ')') {
                if (!prevIsOperator && ch != '(') {
                    result.append(" "); // Tambahkan spasi sebelum operator kecuali '('
                }
                result.append(ch); // Tambahkan operator
                result.append(" "); // Tambahkan spasi setelah operator
                prevIsOperator = true;
            } else {
                result.append(ch); // Tambahkan operand
                prevIsOperator = false;
            }
        }
        return result.toString(); // Return ekspresi dengan spasi
    }

    // Method untuk mengecek apakah karakter adalah operator
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static void main(String[] args) {
        // Tag Mahasiswa Saya
        System.out.println("================================");
        System.out.println("Muhammad Dedad Fajarsodiq Akastangga, 22106050003");
        System.out.println("================================");

        // Contoh penggunaan untuk konversi infix
        System.out.println("Contoh Penggunaan untuk konversi infix ke Postfix");
        String infixExpression = "3+4*(2-1)";
        System.out.print("Ekspresi Infix: ");
        System.out.println(insertSpaces(infixExpression).trim());
        String postfixResult = infixToPostfix(infixExpression);
        System.out.println("--------------------------");
        System.out.print("Hasil Konversi atau Ekspresi Postfix: ");
        System.out.println(insertSpaces(postfixResult).trim());
        System.out.println("--------------------------\n");

        // Contoh penggunaan untuk konversi infix ke prefix
        System.out.println("Contoh Penggunaan untuk konversi infix ke Prefix");
        infixExpression = "3 + 4 * (2 - 1)";
        System.out.print("Ekspresi Infix: ");
        System.out.println(insertSpaces(infixExpression).trim());
        String prefixResult2 = infixToPrefix(infixExpression);
        System.out.println("--------------------------");
        System.out.print("Hasil Konversi atau Ekspresi Prefix: ");
        System.out.println(insertSpaces(prefixResult2).trim());
        System.out.println("--------------------------\n");

        // Contoh penggunaan untuk evaluasi postfix
        System.out.println("Contoh Penggunaan untuk Evaluasi Postfix");
        String postfixExpression = "34*21-+";
        System.out.println("Ekspresi Postfix: " + postfixExpression.replace("", " ").trim());
        int result = evaluatePostfix(postfixExpression);
        System.out.println("--------------------------");
        System.out.println("Hasil Evaluasi Ekspresi Postfix: " + result);
        System.out.println("--------------------------\n");

        // Contoh penggunaan untuk evaluasi prefix
        System.out.println("Contoh Penggunaan untuk Evaluasi Prefix");
        String prefixExpression = "+ * 4 3 - 2 1";
        System.out.println("Ekspresi Prefix: " + prefixExpression.replace("", " ").trim());
        int prefixResult = evaluatePrefix(prefixExpression);
        System.out.println("--------------------------");
        System.out.println("Hasil Evaluasi Ekspresi Prefix: " + prefixResult);
        System.out.println("--------------------------");
    }
}