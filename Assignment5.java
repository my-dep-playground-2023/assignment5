import java.util.Scanner;

public class Assignment5 {

   private static final Scanner Scanner=new Scanner(System.in);
   public static void main(String[] args) {

    final String CLEAR = "\033[H\033[2J";
    final String COLOR_BLUE_BOLD = "\033[34;1m";
    final String COLOR_RED_BOLD = "\033[31;1m";
    final String COLOR_GREEN_BOLD = "\033[33;1m";
    final String RESET = "\033[0m";

    final String DASHBOARD = "💵 Welcome to Smart Banking";
    final String CREATE_NEWACCOUNT = "➕ Create New Account";
    final String DEPOSITS = "DEPOSITS";
    final String WITHDRAWS = "🖨 WITHDRAWS";
    final String TRANSFERS = "🖨 TRANSFERS";
    final String CHECK_ACCOUNT_BALANCE = "🖨 CHECK ACCOUNT BALANCE";
    final String DELETE_ACCOUNT = "🖨 DELETE ACCOUNT";

    String screen=DASHBOARD;
    String [] customers=new String[0];
    Double[] deposits=new Double[0];

    do{
        final String APP_TITLE = String.format("%s%s%s",
        COLOR_BLUE_BOLD, screen, RESET);

System.out.println(CLEAR);
// System.out.println("-".repeat(30));
System.out.println("\t" + APP_TITLE + "\n");
// System.out.println("-".repeat(30));

        switch(screen){
            case DASHBOARD: 
                System.out.println("\t[1]. Create New Account");
                System.out.println("\t[2]. Deposits");
                System.out.println("\t[3]. Withdrawals");
                System.out.println("\t[4]. Transfer");
                System.out.println("\t[5]. Print Statement");
                System.out.println("\t[6]. Delete Account");
                System.out.println("\t[7]. Exit");
                System.out.print("\tEnter an option to continue: ");
                int option = Scanner.nextInt();
                Scanner.nextLine();
                

                        switch (option){
                            case 1: screen = CREATE_NEWACCOUNT; break;
                            case 2: screen = DEPOSITS; break;
                            case 3: screen = WITHDRAWS; break;
                            case 4: screen = TRANSFERS; break;
                            case 5: screen = CHECK_ACCOUNT_BALANCE; break;
                            case 6: screen = DELETE_ACCOUNT; break;
                            case 7: System.out.println(CLEAR); System.exit(0);
                            default: continue;
                        }
                        break;
            case CREATE_NEWACCOUNT:
            System.out.printf("\t ID:SDB-S%03d \n", (customers.length + 1));

            boolean valid;
            String name;
            double deposit;
            do{
                valid = true;
                System.out.print("\tEnter  Name: ");
                name = Scanner.nextLine().strip();

                System.out.println("\tEnter Inial deposit");
                deposit=Scanner.nextDouble();
                Scanner.nextLine();

                if (name.isBlank()){
                    System.out.printf("\t%sName can't be empty%s\n", COLOR_RED_BOLD, RESET);
                    valid = false;
                    continue;
                }
                for (int i = 0; i < name.length(); i++) {
                    if (!(Character.isLetter(name.charAt(i)) || 
                        Character.isSpaceChar(name.charAt(i))) ) {
                        System.out.printf("\t%sInvalid Name%s\n", COLOR_RED_BOLD, RESET);
                        valid = false;
                        break;
                    }
                }
            }while(!valid);

            String[] newcustomers = new String[customers.length + 1];
            for (int i = 0; i < customers.length; i++) {
                newcustomers[i] = customers[i];
            }
            newcustomers[newcustomers.length -1] = name;
            customers = newcustomers;


            Double[] newdeposits = new Double[deposits.length + 1];
            for (int i = 0; i < deposits.length; i++) {
                newdeposits [i] = deposits[i];}
            
            newdeposits[newdeposits.length -1] = deposit;
            deposits =newdeposits;

            System.out.println();
            System.out.print("\t" + name + " added sucessfully.\n\tDo you want to add new Account (Y/n)? ");
            if (Scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
            screen = DASHBOARD;
            break;

                    }


      }while(true);

   
   }}