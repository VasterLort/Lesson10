package it.academy.VasterLord.work;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import it.academy.VasterLord.patterns.Sentence;
import it.academy.VasterLord.patterns.Word;

public class Work {
	public void start() {
		work();
	}
	
	private void work() {
		int sel = 0;
		StringBuffer s = readFile();
		while(sel != 17) {
			sel = menu();
			Word word = new Word(s);
			Sentence sentence = new Sentence(s);
			if(sel == 1)word.equalsWords();
			else if(sel == 2)sentence.sortSentences();	
			else if(sel == 3)sentence.searchSentences();
			else if(sel == 4)sentence.wordsQuestions();
			else if(sel == 5)sentence.changeWords();
			else if(sel == 6)word.sortWords(); 	
			else if(sel == 7)word.sortVowels(); 	
			else if(sel == 8)word.sortConsonants(); 	
			else if(sel == 9)word.amountWords(); 	
			else if(sel == 10)word.removeSubstring();	
			else if(sel == 11) word.removeWords();
		}
	}
		
	private int menu() {
		System.out.println();
		System.out.println("1 - ����� ���������� ���������� ����������� ������, � ������� ���� �����" + 
				"����� �����.");
		System.out.println("2 - ������� ��� ����������� ��������� ������ � ������� ����������� ��������" + 
				"�� ���� � ������ �� ���.");
		System.out.println("3 - ����� ����� ����� � ������ �����������, �������� ��� �� � ����� " + 
				"�� ��������� �����������.");
		System.out.println("4 - �� ���� �������������� ������������ ������ ����� � ���������� ��� ��" + 
				"�������� ����� �������� �����.");
		System.out.println("5 - � ������ ����������� ������ �������� ������� ������ ����� � ������" + 
				"���, �� ������� ����� �����������.");
		System.out.println("6 - ���������� ����� ������ � ���������� ������� �� ������ �����. �����, ��" + 
				"���������� � ����� �����, �������� � ������� ������.");
		System.out.println("7 - �������������� ����� ������ �� ����������� ���� ������� ���� (������" + 
				"��� ���������� ������� � ������ ���������� ���� � �����).");
		System.out.println("8 - ����� ������, ������������ � ������� ����, �������������� � ���������� " + 
				"������� �� ������ ��������� ����� �����.");
		System.out.println("9 - ���������� ����� � ������ ����. ��� ������� ����� �� ��������� ������ " + 
				"�����, ������� ��� ��� ����������� � ������ �����������, � ����������" + 
				"���� ����� �� �������� ������ ���������� ���������.");
		System.out.println("10 - � ������ ����������� ������ ��������� ��������� ������������ �����, " + 
				"������������ � ��������������� ��������� ���������.");
		System.out.println("11 - �� ������ ������� ��� ����� �������� �����, ������������ �� ��������� " + 
				"�����.");
		System.out.println("12 -�����.");
		int select = input();
		return select;
	}
		
	private int input() {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int select = 0;
		try {
			select = Integer.parseInt(read.readLine());
			System.out.println();
		}catch(IOException e) {e.printStackTrace();}
		return select;
	}
	
	private String inputS() {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String select = null;
		try {
			select = read.readLine();
		}catch(IOException e) {e.printStackTrace();}
		return select;
	}
	
	private void writeFile() {
		try(FileWriter writer = new FileWriter("D:/Java/Eclipse/workspace/Test/T.txt", false))
        {
           // ������ ���� ������
            String text = "H";
            writer.write(text);
             
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
	}
	
	private StringBuffer readFile() {
		StringBuffer s = new StringBuffer();
		try(FileReader reader = new FileReader("D:/Java/Eclipse/workspace/Test/Test.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                 s.append((char)c);
            } 
        }
        catch(IOException e){
             e.printStackTrace();
        }
		return s;
	}
}
