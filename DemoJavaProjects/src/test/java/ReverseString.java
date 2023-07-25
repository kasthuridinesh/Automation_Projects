public class ReverseString {
/// String reverse using string buffer
            public static void main(String[] args) {
                String original = "Hello, World!";
                String reversed = reverseString(original);
                System.out.println("Original string: " + original);
                System.out.println("Reversed string: " + reversed);
            }

            public static String reverseString(String str) {
                StringBuilder sb = new StringBuilder(str);
                return sb.reverse().toString();
            }

   // reverse string

        }


