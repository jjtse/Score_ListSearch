//資管二甲 405401138 陳佳澤

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class MyScoreList {

    public static LinkedList<Score> theList = new LinkedList<Score>();

    public static void main(String[] args) {
        readFile();        
        System.out.println("Please enter your choice:");
        System.out.println("1: 查詢  " + "2: 新增  " + "3: 刪除  " + "4: 列出  " + "5: 離開  ");
        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt(); //read in command
        while (choice != 5) {
            if (choice == 1) {
                enquiry();
                System.out.println("Please enter your choice: ");
            } else if (choice == 2) {
                addNewScore();
                System.out.println("Please enter your choice: ");
            } else if (choice == 3) {
                deleteScore();
                System.out.println("Please enter your choice: ");
            } else if (choice == 4) {
                listAllScore();
                System.out.println("Please enter your choice: ");
            } else {
                System.out.println("Invalid choice. Please enter your choice: ");
            }
            choice = keyboard.nextInt();
           } 
        }


    public static void readFile() {
        String nameSt;
        String stLine;
        int credit;
        int score;
        Score theNode;
        try {
            File inFile = new File("D:\\score.txt");
            Scanner sc = new Scanner(inFile);
            while (sc.hasNext()) {
                stLine = sc.nextLine();
                Scanner sc2 = new Scanner(stLine);
                while (sc2.hasNext()) {
                    nameSt = sc2.next();
                    System.out.println(nameSt);
                    credit = sc2.nextInt();
                    System.out.println(credit);
                    score = sc2.nextInt();
                    System.out.println(score);
                    theNode = new Score(nameSt, credit, score);
                    theList.add(theNode);
                }
            }
            sc.close();
        } catch (IOException e) {
        }
    }

    public static void enquiry() {
    	Scanner input=new Scanner(System.in);
    	System.out.println("Please enter the name");
    	String enquiryname=input.nextLine();
    	int data=0;
    	for(int i=0; i<theList.size(); i++) {
    		if(enquiryname.equalsIgnoreCase(theList.get(i).getName())) {
    			System.out.print("Score: "+theList.get(i).getScore()+"  ");
    			data+=1;
    		}
    	}
    	if(data==0) {
    		System.out.println("Name no found");
    	}
    }

    public static void addNewScore() {
    	Scanner input=new Scanner(System.in);
    	Score scoreNode;
    	Score theNode;
    	System.out.println("Please enter the name");
    	String addname=input.nextLine();
    	int data=0;
    	for(int i=0; i<theList.size(); i++) {
    		if(addname.equalsIgnoreCase(theList.get(i).getName())) {
    			System.out.println("Please enter the credit and score");
        		int addcredit=input.nextInt();
        		int addscore=input.nextInt();
        		int newcerdit=theList.get(i).getCredit()+addcredit;
        		int newscore=((theList.get(i).getCredit()*theList.get(i).getScore()+addcredit*addscore)/(theList.get(i).getCredit()+addcredit));
        		theList.remove(i);
        		theNode=new Score(addname,newcerdit,newscore);
        		theList.add(i,theNode);
    			data+=1;
    		}
    	}	
    	if(data==0) {
    		System.out.println("Please enter the credit and score");
    		int addcredit=input.nextInt();
    		int addscore=input.nextInt();
    		scoreNode = new Score(addname, addcredit, addscore);
            theList.add(scoreNode);
    		
    	}
    }

    public static void deleteScore() {
    	Scanner input=new Scanner(System.in);
    	System.out.println("Please enter the name");
    	String deletename=input.nextLine();
    	int data=0;
    	for(int i=0; i<theList.size(); i++) {
    		if(deletename.equalsIgnoreCase(theList.get(i).getName())) {
    			System.out.print("Score: "+theList.get(i).getScore()+"  ");
    			theList.remove(i);
    			System.out.println("Deleted!");
    			data+=1;
    		}
    	}
    	if(data==0) {
    		System.out.println("Name no found");
    	}
    }

    public static void listAllScore() {
    	for(int i = 0; i < theList.size(); i++) {
            System.out.print("Name: "+ theList.get(i).getName()+" / Score: "+theList.get(i).getScore()+"  ");
    	}
    }
}
