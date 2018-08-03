import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        welcomeMsg();
        System.out.println("Input your name.");
        String name = new java.util.Scanner(System.in).nextLine();
        Player p = new Player(name);
        Monster m = new Monster();
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
                int monsterHit = 3-homerun-hit;
                if (homerun == 0 && hit == 0){
                    System.out.println("No hit.");
                    System.out.println(p.getName() + " is damaged by " + 5*monsterHit + "points.");
                    System.out.println(p.getName() + ":"+ p.getHp()+", "+ m.getName()+":" + m.getHp());

                }else{
                    System.out.println(homerun + "home run, " + hit + "hit.");
                    for(int k=1; k<=homerun; k++){
                        p.kick(m);
                    }
                    for(int l=1; l<=hit; l++){
                        p.attack(m);
                    }
                    for(int n=1; n<=monsterHit; n++){
                        m.attack(p);
                    }

                    System.out.println(p.getName() + " attacked.");
                    System.out.println(m.getName() + " is damaged by " + (10*homerun + 5*hit) + "points.");
                    System.out.println(p.getName() + " is damaged by " + 5*monsterHit + "points.");
                    System.out.println(p.getName() + ":"+ p.getHp()+", "+ m.getName()+":" + m.getHp());
                }
            }
        }
        System.out.println("Game end");
        System.out.println("The answer is" + Arrays.toString(ans));
    }

    public static void welcomeMsg(){
        System.out.println("Number Game!");
        System.out.println("Rule: The answer is 3-digit number, and doesn't contain 0.");
        System.out.println("      Each of the digits must be unique.");
        System.out.println("      You have 40hp,  Monster has 100hp.");
        System.out.println("      Homerun=10pt, Hit=5pt");
        System.out.println("      You will attack the monster by 10pt for one homerun or 5pt for one hit.");
        System.out.println("      If you can not hit, you will be damaged by 5 pt.");
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
