import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        welcomeMsg();
        boolean duplicates=true;
        int[] ans = new int[3];
        while(duplicates){
            ans = generateAns();
            duplicates = duplicates(ans);
        }
        System.out.println("Input 3-digit number.");
        boolean isCorrect = false;
        while (!isCorrect){
            int input = new java.util.Scanner(System.in).nextInt();
            int[] inputArr = new int[3];
            inputArr[0] = input / 100;
            inputArr[1] = input % 100 / 10;
            inputArr[2] = input % 100 % 10;
            String[] result = new String[3];
            if (java.util.Arrays.equals(ans, inputArr)){
                isCorrect = true;
            }else{
                int homerun = 0;
                int hit = 0;
                for (int i=0; i<3; i++){
                    for (int j=0; j<3; j++){
                        if (i == j && ans[i] == inputArr[j]){
                            homerun++;
                        }else if (i != j && ans[i] == inputArr[j]){
                            hit++;
                        }else {
                        }
                    }
                }
                if (homerun == 0 && hit == 0){
                    System.out.println("No hit.");
                }else{
                    System.out.println(homerun + "home run, " + hit + "hit.");
                }
            }
        }
        System.out.println("Game end");
        System.out.println("The answer is" + Arrays.toString(ans));
    }

    public static void welcomeMsg(){
        System.out.println("Number Game!");
        System.out.println("Rule: The answer is 3-digit number, and doesn't contain 0.");
        System.out.println("The number of each digit must be unique.");
    }

    public static int[] generateAns(){
        int[] ans = new int [3];
        for (int i =0; i<3; i++){
            ans[i] = new java.util.Random().nextInt(9)+1;
            //out.println(ans[i]);
        }
        return ans;
    }
    public static boolean duplicates(int[] array) {
        boolean duplicates = false;
        for (int j=0; j < array.length; j++){
            for (int k=j+1; k < array.length; k++){
                if (k!=j && array[k] == array[j]){
                    duplicates = true;
                }else{
                    duplicates = false;
                }
            }
        }
        return duplicates;
    }
}
