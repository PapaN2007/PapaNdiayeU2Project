public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    public LinearEquation(){

    }
    public LinearEquation(int x1,int y1,int  x2,int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public double distance(){
        double xDifference = (x2 - x1);
        double yDifference = (y2 - y1);
        double xSquared =  Math.pow(xDifference, 2);
        double ySquared = Math.pow(yDifference, 2);
        double total = xSquared + ySquared;
        double distace = Math.sqrt(total);
        distace = roundedtoHundredth(distace);
        return distace;
    }
    public double slope(){
        double calculateSlope = 0;
        double numerator = ( y2 - y1);
        double denominator = (x2 - x1);
        if(denominator == 0){
            return 0;
        }else {
            calculateSlope = (numerator / denominator);
            calculateSlope = roundedtoHundredth(calculateSlope);
        }
        return calculateSlope;
    }
    public double yIntercept(){
        double xValue = (slope() * x1);
        double yInt = y1 - xValue;
        yInt = roundedtoHundredth(yInt);
        return yInt;
    }
    public String equation() {
        String str = "";
        int remainder = 0;
        int slope = 0;
        int xSlope = (x2 - x1);
        int ySlope = (y2 - y1);
        double yInt = yIntercept();
        if (xSlope == 0){
            str = "";
        }else {
            remainder = ySlope % xSlope;
            if ((remainder) == 0) {
                slope = ySlope / xSlope;
            }
        }if ((slope == -1) && (yInt == 0)) {
            str = ("y = " + " - x");
        }else if ((slope == 1) && (yInt == 0)) {
            str = ("y = " + "x");
        }else if (slope == 1) {
            str = ("y = " + "x + " + yInt);

        } else if (slope == -1) {
            str = ("y = " + "-x + " + yInt);
        }
        else if ((remainder == 0) && (slope > 0) && (yInt > 0)) {
            str = ("y = " + slope + "x +" + yInt);
        }
        else if ((remainder == 0) && (slope > 0) && (yInt < 0)) {
            str = ("y = " + slope + "x " + yInt);
        }
        else if ((remainder == 0) && (slope < 0) && (yInt > 0)) {
            str = ("y = " + slope + "x +" + yInt);
        }
        else if ((remainder == 0) && (slope < 0) && (yInt < 0)) {
            str = ("y = " + slope + "x " + yInt);
        }
        else if ((remainder == 0) && (yInt == 0)) {
            str = ("y = " + slope + "x");
        }
        else if (ySlope == 0) {
            str = ("y = " + (int) yInt);
        }
        else if ((ySlope < 0) && (xSlope < 0)) {
            ySlope *= -1;
            xSlope *= -1;
            str = ("y = " + ySlope + "/" + xSlope + "x + " + yInt);
        }
        else if (xSlope < 0) {
            xSlope *= -1;
            ySlope *= -1;
            str = ("y = " + ySlope + "/" + xSlope + "x + " + yInt);

        }
        else if (yInt == 0) {
            System.out.println("true");
            str = ("y = " + ySlope + "/" + xSlope + "x");
        }
        else if (yInt < 0) {
            yInt *= -1;
            str = ("y = " + ySlope + "/" + xSlope + "x - " + yInt);

        } else {
            str = ("y = " + ySlope + "/" + xSlope + "x + " + yInt);

        }

        return str;
    }
    public String coordinateForX(double x){
        double y = (slope() * x) + yIntercept();
        String cord = ("(" + x + "," + y + ")");
        return cord;
    }
    public String lineInfo(){
        String info = "";
        info = ("The two points are: (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ")" + "\n");
        info += ("The equation of the line between these points is: " + equation() + "\n");
        info += ("The slope of this line is: " + slope() + "\n");
        info += ("The y-intercept of this line is: " + yIntercept() + "\n");
        info += ("The distance between these points is " + distance());
        return info;
    }
    private double roundedtoHundredth(double toRound){
        double rounded = Math.round(toRound * 100) / 100.0;
        return rounded;
    }

}