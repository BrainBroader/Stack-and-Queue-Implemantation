import java.io.*;
import java.util.*;

public class ReadTagMatching {

    private StringStackImpl<String> Stack = new StringStackImpl<String>();

    public void loadTags(String data) {
        int counter = 0;
        File f = null;
        BufferedReader reader = null;
        String CurrentLine;
        boolean stop;


        try {
            f = new File(data);
        } catch (NullPointerException e) {
            System.err.println("File not found.");
        }

        try {
            reader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file!");
        }

        try {
            CurrentLine = reader.readLine();

            while (CurrentLine != null) {//if the line is not null
                int placeInString = 0;

                while (placeInString < CurrentLine.length()) {
                    if (CurrentLine.substring(placeInString,placeInString+1).equals("<")) {

                        String str = "";
                        stop = true;
                        while (stop) { //copy the tag
                            str = str + CurrentLine.substring(placeInString + 1,placeInString+2);


                            if (CurrentLine.substring(placeInString+1,placeInString+2).equals(">")){
                                stop = false;
                                break;

                            }
                            placeInString++;
                        }


                        matcher(str);


                    }
                    placeInString++;

                }
                CurrentLine = reader.readLine();
            }
        } catch(IOException e) {
            System.err.println("file error");
        }
        try {
            reader.close();
        }catch(IOException e){
            System.out.println("Error closing file");
        }
    }//end LoadTags
   //match the tags
    public void matcher(String str){
        if (str.startsWith("/")){

            if(Stack.peek().equals(str.substring(1))){
                Stack.pop();
            }
            else{
                System.out.println("The file has not matching tags");
                System.exit(0);

            }

        }else{
            Stack.push(str);
        }

    }//end matcher
    //print if the program has matching tags
    public void print(){
        if (Stack.isEmpty()){
            System.out.println("The file has matching tags");
        }
        else {
            System.out.println("The file has not matching tags");
        }

    }//end print


}//end ReadFileTagMachine



			    