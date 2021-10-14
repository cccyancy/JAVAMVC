package FamilyAccount;

public class FamilyAccount {
    public static void main(String[] args) {

        boolean isFlag = true;
        //details for income and spend
        String details = "Income\tBalance\tAmount\tMemo\n";
        int amount = 10000;

        while(isFlag) {
            System.out.println("\n-----------------Family Balance Sheet-----------------\n");
            System.out.println("\n                 1. Record Detail                     \n");
            System.out.println("\n                 2. Add Income                        \n");
            System.out.println("\n                 3. Add Spend                         \n");
            System.out.println("\n                 4. Sign Out                          \n");

            System.out.println("\n                 Please select(1 - 4):                \n");

            //Get user selection. between 1 - 4
            char selection = Utility.readMenuSelection();

            switch (selection) {
                case '1':
                    //System.out.println("1. Record Detail");
                    System.out.println(
                            "                      Record Detail               ");
                    System.out.println(details);
                    System.out.println("--------------------------------");
                    break;

                case '2':
                    System.out.println("");
                    System.out.println("Income amount");
                    int money = Utility.readNumber();
                    System.out.println("Memo");
                    String info = Utility.readString();

                    amount += money;
                    details += ("Income\t" + amount + "\t\t" + money + "\t\t" + info + "\n");
                    System.out.println("----------------Finish-----------------");
                    break;

                case '3':
                    //System.out.println("3. Add Spend");
                    System.out.println("Spend amount: ");
                    money = Utility.readNumber();
                    if(amount < money ) {
                        System.out.println("Cannot spend more than the balance");
                        money = Utility.readNumber();
                    } else {
                        amount -= money;
                    }
                    System.out.println("Memo");
                    info = Utility.readString();




                    details += ("Income\t" + amount + "\t\t" + money + "\t\t" + info + "\n");

                    System.out.println("----------------Finish-----------------");


                    break;

                case '4':
                    System.out.println("Are you sure(Y/N)?");
                    char isExit = Utility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
            }


            //isFlag = false;

        }


    }
}
