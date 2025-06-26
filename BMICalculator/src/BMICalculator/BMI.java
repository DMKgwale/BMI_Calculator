package BMICalculator;
import java.util.Scanner;

public class BMI{

    public static void main(String[] args) {
        

        char repeat;

// welcome page // start of the code
        do {
          Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the BMI Calculator!");

            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            
            System.out.println("Enter your age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter your gender (Male/Female): ");
            String gender = scanner.nextLine();

            int unitChoice = getUnitChoice(scanner);

            double weight = (unitChoice ==1)? getValidInput(scanner, "\nEnter your weight in kilograms: ",10,600)
            : getValidInput(scanner, "\nEnter your weight in pounds", 20,100);

            double height = (unitChoice == 1)? getValidInput(scanner, "\nEnter your height in meters:",0.5,2.5)
            : getValidInput(scanner, "\nEnter your height in inches", 20,100);

            double bmi = calculateBMI(unitChoice,weight,height);

            System.out.println("\nName: "+ name + "\nAge: " + age + "\nGender: "+ gender );
           // System.out.println("Formula used: BMI = weight (kg) / (height (m) * height (m))");

            System.out.println("Your BMI is: " + bmi);

            	System.out.print(name);
            displayCategoryAndAdvice(bmi);
            repeat = askToRepeat(scanner);
            

        } while (repeat == 'Y' || repeat == 'y');

        System.out.println("Thank you for using the BMI Calculator! Stay healthy!");
    }

 // Method to display BMI category and health advice
    public static void displayCategoryAndAdvice(double bmi) {
         System.out.print( " Your BMI Category is: ");

        if (bmi < 16.0) {
            System.out.println("Severely Underweight");
            System.out.println("Advice: Please consult a healthcare provider. You may need to gain weight for health.");
        } else if (bmi <= 18.4) {
            System.out.println("Underweight");
            System.out.println("Advice: Consider a nutritious diet and strength training exercises.");
        } else if (bmi <= 24.9) {
            System.out.println("Normal");
            System.out.println("Advice: Great! Maintain your healthy lifestyle.");
        } else if (bmi <= 29.0) {
            System.out.println("Overweight");
            System.out.println("Advice: Consider regular exercise and a balanced diet.");
        } else if (bmi <= 34.9) {
            System.out.println("Moderately Obese");
            System.out.println("Advice: It's advisable to consult a doctor or nutritionist.");
        } else if (bmi <= 39.9) {
            System.out.println("Severely Obese");
            System.out.println("Advice: Health risks increase. Professional medical advice is strongly recommended.");
        } else {
            System.out.println("Morbidly Obese");
            System.out.println("Advice: Immediate medical guidance is necessary to reduce health risks.");
        }
    }
    public static double getValidInput(Scanner scanner, String prompt, double min, double max){
        double value;
        while (true) { 
            System.out.println(prompt);

            if(scanner.hasNextDouble()){
                value = scanner.nextDouble();
            if(value >= min && value <= max){
                break;
            }else{
                System.out.printf("Please enter value between %.1f and %.1f. \n ", min, max);
            }
            } else {
                System.out.println("Invalid input. please enter a value");
                scanner.next();
            }
        }
        return value;
    }


// Method to get unit choice
    public static int getUnitChoice(Scanner scanner) {
        int choice;
        while (true) {
            System.out.println("\nSelect a preferred unit:");
            System.out.println("1. Metric (kg, m)");
            System.out.println("2. Imperial (lbs, in)");
            System.out.println("Enter 1 or 2: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return choice;
    }

// Method to ask user if they want to repeat
    public static char askToRepeat(Scanner scanner) {
        char choice=0;

         System.out.print("\nDo you want to calculate BMI again? (Y/N): ");
            choice = scanner.next().charAt(0);

        while (true) {
           
            if (choice == 'Y' || choice == 'y' || choice == 'N' || choice == 'n') {
                break;
            } else {
                System.out.println("Invalid input. Please enter Y/y or N/n.");
            }
        }
        return choice;
    }

    private static double calculateBMI(int unitChoice, double weight, double height) {
        double totalBMI;
        
        if(unitChoice ==1){
            totalBMI = weight / (height * height );
        }else{
            totalBMI = weight / (height * height );
        }
        return totalBMI;
    }
}
 