import java.util.*;

public class BrainTrainingApp {
    public static void main(String[] args){
        BrainTrainingApp br = new BrainTrainingApp();
        br.start();
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Brain Training App!");
        System.out.println("Select an option:");
        System.out.println("1. Math Exercise");
        System.out.println("2. Memory Game");
        System.out.println("3. Puzzle");
        System.out.println("0. Exit");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                performMathExercise();
                break;
            case 2:
                playMemoryGame();
                break;
            case 3:
                solvePuzzle();
                break;
            case 0:
                System.out.println("Exiting the Brain Training App...\n");
                return;
            default:
                System.out.println("Invalid choice. Please try again.\n");
                break;
        }
       
        // Recursive call to start the app again
        if(choice!=0)
        start();
    }
    
    private void performMathExercise() {
        // Simulating a math exercise
        System.out.println("Solve the following math problem:");
        int num1 = (int) (Math.random() * 10) + 1;
        int num2 = (int) (Math.random() * 10) + 1;
        int answer = num1 + num2;
        
        System.out.println(num1 + " + " + num2 + " = ?");
        
        Scanner scanner = new Scanner(System.in);
        int userAnswer = scanner.nextInt();
        
        if (userAnswer == answer) {
            System.out.println("Correct answer! Good job!\n");
        } else {
            System.out.println("Incorrect answer. Keep practicing!\n");
        }
    }
    
    private void playMemoryGame() {
        // Simulating a memory game
        System.out.println("Welcome to the Memory Game!");
        System.out.println("Try to remember the sequence of numbers.");
        
        int[] sequence = new Random().ints(5, 0, 100).toArray();;
        
        for (int number : sequence) {
            System.out.print(number + " ");
            try {
                // Display each number for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        performRemainingTask(sequence,5);
    }
    
    private void solvePuzzle() {
        // Simulating a puzzle
        System.out.println("Solve the puzzle by arranging the numbers in ascending order:");
        
        int[] puzzle = new Random().ints(5, 0, 100).toArray();
        
        for (int number : puzzle) {
            System.out.print(number + " ");
        }

        Arrays.sort(puzzle);

        performRemainingTask(puzzle,5);
    }

    private void performRemainingTask(int[] arr,int n){

        System.out.println("\nNow, enter the sequence of numbers:");
        
        Scanner scanner = new Scanner(System.in);
        int[] userSequence = new int[n];
        
        for (int i = 0; i < n; i++) {
            userSequence[i] = scanner.nextInt();
        }
        
        boolean isCorrect = true;
        
        for (int i = 0; i < n; i++) {
            if (userSequence[i] != arr[i]) {
                isCorrect = false;
                break;
            }
        }
        
        if (isCorrect) {
            System.out.println("Correct answer! Good job!\n");
        } else {
            System.out.println("Incorrect answer. Keep practicing!\n");
        }
    }
}
