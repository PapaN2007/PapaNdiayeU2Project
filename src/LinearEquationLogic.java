import java.util.Scanner;
public class LinearEquationLogic {

    private Scanner myScanner;
    private String cordinate1;
    private String cordinate2;
    private LinearEquation data;


    public LinearEquationLogic() {
        myScanner = new Scanner(System.in);
        cordinate1 = null;
        cordinate2 = null;
        data = new LinearEquation();
        System.out.println("Welcome to the Linear Equation Calculator");
    }


    // method that gets called which starts the program

    public void start() {
        getCordinate();
    }


    // private helper method
    private void getCordinate() {
        System.out.print("Enter the first coordinate: ");
        cordinate1 = myScanner.nextLine();
        System.out.print("Enter the second coordinate: ");
        cordinate2 = myScanner.nextLine();
        System.out.println(" ");

        int cordComma = cordinate1.indexOf(",");
        String HalfCord = (cordinate1.substring(1,cordComma));
        String OtherHalf1 = (cordinate1.substring(cordComma + 1, cordinate1.length() -1));
        int x1 = Integer.parseInt(HalfCord);
        int y1 = Integer.parseInt(OtherHalf1);

        int cord2Comma = cordinate2.indexOf(",");
        String FirstHalf2 = (cordinate2.substring(1,cord2Comma ));
        String OtherHalf2 = (cordinate2.substring(cord2Comma + 1, cordinate2.length() -1));
        int x2 = Integer.parseInt(FirstHalf2);
        int y2 = Integer.parseInt(OtherHalf2);
        if ((x1 - x2) == 0){
            System.out.println("These points are on a vertical line: x = " + x1);
            newContinue();
        }else{
            data = new LinearEquation(x1, y1, x2, y2);
            getData();
            System.out.println(" ");
            newCord();
            newContinue();
        }
    }



    private void getData() {
        String totalData = data.lineInfo();
        System.out.println(totalData);
    }
    private void newCord(){
        System.out.print("Enter a value for x: ");
        double newX = myScanner.nextDouble();
        myScanner.nextLine();
        System.out.println(" ");
        System.out.println("The point on the line is " + data.coordinateForX(newX));
    }
    private void newContinue(){
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        String answer = myScanner.nextLine();
        if (answer.equals("y")){
            start();
        }else{
            ending();
        }
    }
    private void ending(){
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }
}