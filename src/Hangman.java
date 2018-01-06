
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



/**
 *
 * @author Tevin
 */
public class Hangman{
    static String [] words= new String [72875];
    static Scanner in2= new Scanner(System.in);
    static int wordLength;
    static int guesses;
    static String sWord;
    
    public void Hangman() throws IOException{
        run();}
    
    public static void run()throws IOException{
    Scanner in= new Scanner(new FileReader("words.txt"));
    for( int i = 0; i < words.length; i++){
        if(in.hasNext()){
            String word = in.next();
            words[i]= word;}}
    l();
    l2();
    solve();}
  
    public static void l(){
            System.out.println("Enter the length of the word: ");
       while(!in2.hasNextInt()){
            System.out.println("Please enter a number.");
            System.out.println("Enter the length of the word: ");
           in2.next();}
        wordLength = in2.nextInt();
        if(wordLength>1 && wordLength<22){
            while(true){   
            Random rand = new Random();
            int n = rand.nextInt(words.length+1);
            if(words[n].length()==wordLength){
            sWord = words[n];
           /* System.out.println(sWord);
            * Use this see the chosen word.
            */
            break;}}}
        else{System.out.println("Please enter a number between 2-21. ");
        l();}}
    
    public static void l2(){
           System.out.println("Enter the number of guesses: ");
           while(!in2.hasNextInt()){
           System.out.println("Please enter a number.");
           System.out.println("Enter the number of guesses: ");
           in2.next();}
           guesses = in2.nextInt();
           if(guesses<=2||guesses>=24){
               System.out.println("Please enter a number between 3-23.");
            l2();}}
   
    public static void solve() throws IOException{
        StringBuilder b = new StringBuilder();
        char [] solution = new char[ sWord.length()];
        for (int i= 0; i< solution.length; i++){
            solution[i]='_';
            System.out.print(solution[i]+ " ");
        }
        System.out.println("");
        while(guesses != 0){
            System.out.println("Enter your guess");
        char c= in2.next().charAt(0);
        char v= Character.toLowerCase(c);
        for (int i = 0; i < sWord.length(); i++) {
            if( sWord.charAt(i)==v){
               solution[i]=v;
            }
            System.out.print(solution[i]+" ");
            
        }
        b.append(v).append(" ");
    System.out.println("Used letter "+ b.toString());
  guesses--;
  System.out.println("You have "+ guesses+" guesses left.");
   if(guesses==0 && Arrays.equals(solution,sWord.toCharArray()) || Arrays.equals(solution,sWord.toCharArray())){
      System.out.println("You Won.");
      retry();}
   else if(guesses==0){
       System.out.println("You loss. The word was "+ sWord);
       retry();
   }}}
        
    
    public static void retry() throws IOException{
        System.out.println("Try again? Y/N");
        char a= in2.next().charAt(0);
        if(a=='Y'||a=='y'){
            run();
        }
        else if(a=='N'||a=='n'){
            System.out.println("Thanks for playing...");
            System.exit(0);
        }
        else{
            System.out.println("Invalid Input.");
            retry();
        }
    }
}



