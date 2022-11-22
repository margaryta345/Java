public class CyberTest {


    public static void main(String[] args) {
        String line = "hello how are era you olleh ";
            String[] str;
            str = line.split("\\s");
            for (String word : str) {
                System.out.print(word + " ");
            }
            System.out.println("\n------------");
            int i = 0, j = 0;
            while (i < str.length) {
                String tempi = str[i];
                for (j = 0; j < str.length; j++) {
                    String tempj = str[j];
                    String sb = new StringBuffer(tempj).reverse().toString();
                    if (tempi.equals(sb)) {
                        System.out.println(tempi + " " + tempj);
                    }
                }

                i++;
            }
        }
    }

