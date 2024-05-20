package ArraysStrings;

public class URL {
    public static void main(String[] args) {
        String s = "Mr John Smith"; // original string without extra spaces
        int trueLength = s.length(); // the true length of the string
        char[] str = new char[trueLength + 3 * 2]; // allocate space for additional characters
        for (int i = 0; i < trueLength; i++) {
            str[i] = s.charAt(i);
        }
        replace(str, trueLength);
    }

    static void replace(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;

        // Count the number of spaces in the true part of the string
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        // Calculate the new length of the array after replacements
        index = trueLength + spaceCount * 2;

        // Ensure the array has enough space
        if (index > str.length) {
            throw new IllegalArgumentException("Not enough space in the array to replace spaces");
        }

        // Replace spaces from the end to the beginning
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }

        // Print the modified string
        System.out.println(new String(str));
    }
}
