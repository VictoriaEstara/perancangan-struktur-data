# Kode ini dibagikan oleh Dedad Fajar dan dapat diakses melalaui github: https://github.com/VictoriaEstara/perancangan-struktur-data

# Definisi kelas Stack
class Stack:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[-1]

    def is_empty(self):
        return len(self.items) == 0


# About Infix Notation
    # Inifix Notation adalah Notasi standar yang digunakan dalam matematika pada kehidupan sehari-hari sehingga sering digunakan dalam pemrograman manusia.
    # Metode melakukan evaluasi Infix Notation, yakni menggunakan urutan operasi dan tanda kurung.

# About Postfix Notation
    # Postfix Notation adalah Notasi dimana operator ditempatkan setelah operand-operand yang sesuai, sehingga sering digunakan dalam pemrosesan komputer, terutama algoritma stack.
    # Metode melakukan evaluasi Postfix Notation, yakni menggunakan konsep membaca ekspresi dari kiri ke kanan dan menerapkan operator pada operand yang sesuai, tanpa memperhaikan tanda kurung.

#About Prefix Notation
    #Prefix Notation adalah Notasi dimana operator ditemapatkan sebelum operand-operand yang sesuai.
    # Metode melakukan eksekusi atau evaluasi Prefix Notation, yakni menggunakan konsep membaca ekspresi dari kanan ke kiri (operator terletak di depan dieksekusi terakhir).


# Fungsi untuk mengonversi ekspresi infix menjadi postfix
def infix_to_postfix(expression):
    precedence = {'+': 1, '-': 1, '*': 2, '/': 2}  # Tingkat prioritas operator
    output = []  # Menyimpan ekspresi postfix
    stack = Stack()  # Stack untuk operasi konversi

    # Memisahkan token dengan spasi di antara operator dan operand
    tokens = expression.replace('(', ' ( ').replace(')', ' ) ').split()

    for token in tokens:  # Memproses setiap token dalam ekspresi infix
        if token.isdigit():  # Jika token adalah operand, tambahkan ke output
            output.append(token)
        elif token == '(':  # Jika token adalah kurung buka, push ke stack
            stack.push(token)
        elif token == ')':  # Jika token adalah kurung tutup
            # Pop operator dari stack dan tambahkan ke output sampai menemukan kurung buka yang sesuai
            while not stack.is_empty() and stack.peek() != '(':
                output.append(stack.pop())
            stack.pop()  # Pop kurung buka dari stack
        else:  # Jika token adalah operator
            # Pop operator dari stack dan tambahkan ke output sampai menemukan operator dengan prioritas lebih rendah
            while not stack.is_empty() and precedence.get(stack.peek(), 0) >= precedence.get(token, 0):
                output.append(stack.pop())
            stack.push(token)  # Push token operator ke stack

    # Pop semua operator dari stack dan tambahkan ke output
    while not stack.is_empty():
        output.append(stack.pop())

    # Menggabungkan semua token dalam output menjadi string ekspresi postfix
    return ' '.join(output)


# Fungsi untuk mengonversi ekspresi infix menjadi prefix
def infix_to_prefix(expression):
    precedence = {'+': 1, '-': 1, '*': 2, '/': 2}  # Tingkat prioritas operator
    output = []  # Menyimpan ekspresi prefix
    stack = Stack()  # Stack untuk operasi konversi

    # Memisahkan token dengan spasi di antara operator dan operand, kemudian membalik urutan token
    tokens = expression.replace('(', ' ( ').replace(')', ' ) ').split()[::-1]

    for token in tokens:  # Memproses setiap token dalam ekspresi infix secara terbalik
        if token.isdigit():  # Jika token adalah operand, tambahkan ke output
            output.append(token)
        elif token == ')':  # Jika token adalah kurung tutup, push ke stack
            stack.push(token)
        elif token == '(':  # Jika token adalah kurung buka
            # Pop operator dari stack dan tambahkan ke output sampai menemukan kurung tutup yang sesuai
            while not stack.is_empty() and stack.peek() != ')':
                output.append(stack.pop())
            stack.pop()  # Pop kurung tutup dari stack
        else:  # Jika token adalah operator
            # Pop operator dari stack dan tambahkan ke output sampai menemukan operator dengan prioritas lebih rendah
            while not stack.is_empty() and precedence.get(stack.peek(), 0) > precedence.get(token, 0):
                output.append(stack.pop())
            stack.push(token)  # Push token operator ke stack

    # Pop semua operator dari stack dan tambahkan ke output
    while not stack.is_empty():
        output.append(stack.pop())

    # Menggabungkan semua token dalam output secara terbalik menjadi string ekspresi prefix
    return ' '.join(output[::-1])


# Fungsi untuk mengevaluasi ekspresi postfix
def evaluate_postfix(expression):
    stack = Stack()  # Stack untuk evaluasi postfix

    for token in expression.split():  # Memproses setiap token dalam ekspresi postfix
        if token.isdigit():  # Jika token adalah operand, push ke stack
            stack.push(int(token))
        else:  # Jika token adalah operator
            # Pop dua operand teratas dari stack, lakukan operasi, dan push hasilnya kembali ke stack
            operand2 = stack.pop()
            operand1 = stack.pop()
            result = perform_operation(token, operand1, operand2)
            stack.push(result)

    # Hasil evaluasi adalah nilai teratas di stack setelah semua token diproses
    return stack.pop()


# Fungsi untuk mengevaluasi ekspresi prefix
def evaluate_prefix(expression):
    stack = Stack()  # Stack untuk evaluasi prefix

    for token in expression.split()[::-1]:  # Memproses setiap token dalam ekspresi prefix secara terbalik
        if token.isdigit():  # Jika token adalah operand, push ke stack
            stack.push(int(token))
        else:  # Jika token adalah operator
            # Pop dua operand teratas dari stack, lakukan operasi, dan push hasilnya kembali ke stack
            operand1 = stack.pop()
            operand2 = stack.pop()
            result = perform_operation(token, operand1, operand2)
            stack.push(result)

    # Hasil evaluasi adalah nilai teratas di stack setelah semua token diproses
    return stack.pop()


# Fungsi untuk melakukan operasi aritmatika
def perform_operation(operator, operand1, operand2):
    if operator == '+':
        return operand1 + operand2
    elif operator == '-':
        return operand1 - operand2
    elif operator == '*':
        return operand1 * operand2
    elif operator == '/':
        if operand2 == 0:
            raise ValueError("Cannot divide by zero!")
        return operand1 / operand2
    else:
        raise ValueError("Invalid operator: " + operator)


# Tag Mahasiswa Saya
print("================================================")
print("Muhammad Dedad Fajarsodiq AKasatangga, NIM. 22106050003")
print("================================================\n")


# Contoh penggunaan untuk konversi infix ke postfix
print("Contoh Penggunaan untuk konversi infix ke Postfix")
infix_expression = "3 + 4 * (2 - 1)"
print("Ekspresi Infix:", infix_expression)
postfix_expression = infix_to_postfix(infix_expression)
print("--------------------------")
print("Hasil Konversi atau Ekspresi Postfix:", postfix_expression)
print("--------------------------\n")


# Contoh penggunaan untuk konversi infix ke prefix
print("Contoh Penggunaan untuk konversi infix ke Prefix")
infix_expression = "3 + 4 * (2 - 1)"
print("Ekspresi Infix:", infix_expression)
prefix_expression = infix_to_prefix(infix_expression)
print("--------------------------")
print("Hasil Konversi atau Ekspresi Prefix:", prefix_expression)
print("--------------------------\n")


# Contoh penggunaan untuk evaluasi postfix
print("Contoh Penggunaan untuk Evaluasi Postfix")
postfix_expression = "3 4 * 2 1 - +"
print("Ekspresi Postfix:", postfix_expression)
result = evaluate_postfix(postfix_expression)
print("--------------------------")
print("Hasil Evaluasi Ekspresi Postfix:", result)
print("--------------------------\n")


# Contoh penggunaan untuk evaluasi prefix
print("Contoh Penggunaan untuk Evaluasi Prefix")
prefix_expression = "+ * 4 3 - 2 1"
print("Ekspresi Prefix:", prefix_expression)
result = evaluate_prefix(prefix_expression)
print("--------------------------")
print("Hasil Evaluasi Ekspresi Prefix:", result)
print("--------------------------")