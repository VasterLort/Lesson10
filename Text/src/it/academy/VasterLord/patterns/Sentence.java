package it.academy.VasterLord.patterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Sentence {
	private StringBuffer s;
	public Sentence(StringBuffer s) {
		this.s = s;
	}
	
	public void sortSentences() {
		Map<Integer, String> map = new TreeMap();
		String[] str = s.toString().split("(?=[А-Я_A-Z])");
		for(int i = 0; i < str.length; i++) {
			String[] words = str[i].split("[\\s.,;:]\\s*");
			map.put(words.length, str[i]);
		}
		
		for(Map.Entry<Integer, String> entry : map.entrySet()) {
	           System.out.println(entry.getValue());
	       }
	}
	
	public void searchSentences() {
		String string = null;
		boolean check = false;
		String[] str = s.toString().split("(?=[А-Я_A-Z])");
		String[] words = str[0].split("[\\s.,;:]\\s*");
		for(int i = 0; i < words.length; i++) {
			for(int j = 1; j < str.length; j++) {
				if(str[j].toLowerCase().contains(words[i].toLowerCase())) {
					check = false;
					break;
				}else {
					check = true;
					string = words[i];
				}
			}
			if(check == true)break;
		}
		if(check == true)System.out.println("Слово которое находится, только в 1 предложении: " + string);
		else System.out.println("Слово которое находится, только в 1 предложении: таких нет");
	}
	
	public void wordsQuestions() {
		System.out.println("Введите размер слова:");
		int l = input();
		boolean b = false;
		String[] str = s.toString().split("(?=[А-Я_A-Z])");
		for(int i = 0; i < str.length; i++) {
			if(str[i].contains("?")) {
				String[] words = str[i].split("[\\s.,;:]\\s*");
				for(int j = 0; j < words.length; j++) {
					if(words[j].length() == l) {
						b = true;
						System.out.println(words[j]);
					}
				}
			}
		}
		if(b == false)System.out.println("Нет слов заданной длины: " + l);
	}
	
	public void changeWords() {
		String[] str = s.toString().split("(?=[А-Я_A-Z])");
		for(int i = 0; i < str.length; i++) {
			String[] words = str[i].split("\\s");
			int amount = words.length;
			amount--;
			String tmp = words[0];
			words[0] = words[amount];
			words[amount] = tmp;
			
			StringBuilder builder = new StringBuilder();
			for(String s : words) {
			    builder.append(s + " ");
			}
			String string = builder.toString();
			str[i] = string;
		}
		for(int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}	
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
}
