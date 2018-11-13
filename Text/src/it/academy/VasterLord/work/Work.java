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
		System.out.println("1 - Найти наибольшее количество предложений текста, в которых есть одина" + 
				"ковые слова.");
		System.out.println("2 - Вывести все предложения заданного текста в порядке возрастания количест" + 
				"ва слов в каждом из них.");
		System.out.println("3 - Найти такое слово в первом предложении, которого нет ни в одном " + 
				"из остальных предложений.");
		System.out.println("4 - Во всех вопросительных предложениях текста найти и напечатать без по" + 
				"вторений слова заданной длины.");
		System.out.println("5 - В каждом предложении текста поменять местами первое слово с послед" + 
				"ним, не изменяя длины предложения.");
		System.out.println("6 - Напечатать слова текста в алфавитном порядке по первой букве. Слова, на" + 
				"чинающиеся с новой буквы, печатать с красной строки.");
		System.out.println("7 - Рассортировать слова текста по возрастанию доли гласных букв (отноше" + 
				"ние количества гласных к общему количеству букв в слове).");
		System.out.println("8 - Слова текста, начинающиеся с гласных букв, рассортировать в алфавитном " + 
				"порядке по первой согласной букве слова.");
		System.out.println("9 - Существует текст и список слов. Для каждого слова из заданного списка " + 
				"найти, сколько раз оно встречается в каждом предложении, и рассортиро" + 
				"вать слова по убыванию общего количества вхождений.");
		System.out.println("10 - В каждом предложении текста исключить подстроку максимальной длины, " + 
				"начинающуюся и заканчивающуюся заданными символами.");
		System.out.println("11 - Из текста удалить все слова заданной длины, начинающиеся на согласную " + 
				"букву.");
		System.out.println("12 -Выход.");
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
           // запись всей строки
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
