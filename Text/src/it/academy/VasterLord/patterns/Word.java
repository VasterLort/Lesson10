package it.academy.VasterLord.patterns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Word {
	private StringBuffer s;
	private static String global;
	
	public Word(StringBuffer s) {
		this.s = s;
	}
	
	public void equalsWords() {
		int counter = 0;
		int max = 0;
		int check = 0;
		int now = 0;
		String[] str = s.toString().split("(?=[А-Я_A-Z])");
		for(int i = 0; i < str.length; i++) {
			String[] words = str[i].split("[\\s.,;:]\\s*");
			for(int j = 0; j < words.length; j++) {
				for(int n = 0; n < words.length; n++) {
					if(words[j].equals(words[n])) {
						now++;
					}
				}
				if(now > max) {
					max = now;
				}
				now = 0;
			}
			if(max > check) {
				check = max;
				counter = 1;
			}else if(max == check) {
				counter++;
			}
			max = 0;
		}
		System.out.println(counter);
	}
	
	public void sortWords() {
		String[] str = s.toString().split("(?=[А-Я_A-Z])");
		List<String> list = new ArrayList<>();
		for(int i = 0; i < str.length; i++) {
			String[] words = str[i].split("\\s");
			for(int j = 0; j < words.length; j++) {
				if(!words[j].isEmpty())list.add(words[j]);
			}
		}
		
		Collections.sort(list, ALPHABETICAL_ORDER);
		String s1 = list.get(0).toLowerCase();
		System.out.print(" ");
		for(String l : list) {
			String s2 = l.toLowerCase();
			char c1 = s1.charAt(0);
			char c2 = s2.charAt(0);
			if(c1 != c2) {
				System.out.print(" ");
				s1 = s2;
			}
			System.out.println(l);
		}
	}
	
	public void sortVowels() {
		String[] str = s.toString().split("(?=[А-Я_A-Z])");
		List<String> list = new ArrayList<>();
		for(int i = 0; i < str.length; i++) {
			String[] words = str[i].split("\\s");
			for(int j = 0; j < words.length; j++) {
				if(!words[j].isEmpty())list.add(words[j]);
			}
		}
		
		Collections.sort(list, VOWELS);
		for(String l : list) {
			System.out.println(l);
		}
	}
	
	public void sortConsonants() {
		String[] str = s.toString().split("(?=[А-Я_A-Z])");
		List<String> list = new ArrayList<>();
		for(int i = 0; i < str.length; i++) {
			String[] words = str[i].split("\\s");
			for(int j = 0; j < words.length; j++) {
				if(!words[j].isEmpty())list.add(words[j]);
			}
		}
		
		Collections.sort(list, CONSONANTS);
		for(String l : list) {
			System.out.println(l);
		}
	}
	
	public void amountWords() {
		String[] str = s.toString().split("(?=[А-Я_A-Z])");
		StringBuffer word = readWords();
		int count = 0;
		int c = 0;
		String[] w = word.toString().split("\\s+");
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < str.length; i++) {
			String[] words = str[i].split("[\\s.,;:]\\s*");
			for(int j = 0; j < w.length; j++) {
				for(int n = 0; n < words.length; n++) {
					if(w[j].equals(words[n]))count++;
				}
				c = i + 1; 
				System.out.println(w[j] + " встречается в количестве " + count + " раз в " + c + " предложении");
				count = 0;
			}
		}
	}
	
	public void removeSubstring() {
		String[] str = s.toString().split("(?=[А-Я_A-Z])");
		System.out.print("Введите символ, с которого начинается слово: ");
		String c1 = input();
		System.out.print("Введите символ, с которого заканчивается слово: ");
		String c2 = input();
		int size = 0;
		int count = 0;
		int p1 = 99;
		int p2 = 0;
		int max = 0;
		
		System.out.println();
		for(int i = 0; i < str.length; i++) {
			String[] words = str[i].split("\\s+");
			for(int j = 0; j < words.length; j++) {
				char[] symbol = words[j].toCharArray();
				for(int n = 0; n < symbol.length; n++) {
					if(c1.charAt(0) == symbol[n] && p1 == 99) {
						p1 = n;
					}
					if(c2.charAt(0) == symbol[n] && p1 < n) {
						p2 = n;
					}
				}
				if(p1 < p2) {
					size = p2 - p1;
					if(max < size) {
						max = size;
						count = 1;
					}else if(max == size) {
						count++;
					}
				}
				p1 = 99;
				p2 = 0;
			}
			
			for(int j = 0; j < words.length; j++) {
				char[] symbol = words[j].toCharArray();
				for(int n = 0; n < symbol.length; n++) {
					if(c1.charAt(0) == symbol[n] && p1 == 99) {
						p1 = n;
					}
					if(c2.charAt(0) == symbol[n] && p1 < n) {
						p2 = n;
					}
				}
				if(p1 < p2) {
					size = p2 - p1;
					if(max == size) {
						StringBuilder sb = new StringBuilder(words[j]);
						p1++;
						sb.delete(p1, p2);
						words[j] = sb.toString();
					}
				}
				p1 = 99;
				p2 = 0;
			}
			max = 0;
			
			StringBuilder builder = new StringBuilder();
			for(String s : words) {
			    builder.append(s + " ");
			}
			
			String string = builder.toString();
			str[i] = string;
		}
		
		for(String s : str) {
		    System.out.println(s);
		}
	}
	
	
	public void removeWords() {
		String[] str = s.toString().split("(?=[А-Я_A-Z])");
		System.out.print("Какого размера слова, вы хотите удалить: ");
		int size = inputInt();
		for(int i = 0; i < str.length; i++) {
			String[] words = str[i].split("[\\s.,;:]\\s*");
			StringBuilder sb = new StringBuilder("");
			for(int j = 0; j < words.length; j++) {
				if(size != words[j].length()) {
					sb.append(words[j] + " ");
				}
			}

			String string = sb.toString();
			str[i] = string;
		}
		
		for(String s : str) {
		    System.out.println(s);
		}
	}
	
	private StringBuffer readWords() {
		StringBuffer s = new StringBuffer();
		try(FileReader reader = new FileReader("D:/Java/Eclipse/workspace/Test/Words.txt"))
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
	
	private static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
	    public int compare(String str1, String str2) {
	        int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
	        if (res == 0) {
	            res = str1.compareTo(str2);
	        }
	        return res;
	    }
	};
	
	private static Comparator<String> VOWELS = new Comparator<String>() {
		public int compare(String o1, String o2) {
			int count1 = 0;
			int count2 = 0;
			char[] vowels = {'а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я', 
					'А', 'О', 'И', 'Е', 'Ё', 'Э', 'Ы', 'У', 'Ю', 'Я'};
			
	        for(int i = 0; i < o1.length(); i++) {
	        	for(int j = 0; j < vowels.length; j++) {
	        		if(o1.charAt(i) == vowels[j]) {
	        			count1++;
	        		}
		        }	
	        }
	        for(int i = 0; i < o2.length(); i++) {
	        	for(int j = 0; j < vowels.length; j++) {
	        		if(o2.charAt(i) == vowels[j]) {
	        			count2++;
	        		}
		        }	
	        }
            return count1 - count2;
        }
	};
	
	private static Comparator<String> CONSONANTS = new Comparator<String>() {
		public int compare(String o1, String o2) {
			int count1 = 0;
			int count2 = 0;
			char[] vowels = {'а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я', 
					'А', 'О', 'И', 'Е', 'Ё', 'Э', 'Ы', 'У', 'Ю', 'Я'};
			char[] symbol = {'а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я', 
					'А', 'О', 'И', 'Е', 'Ё', 'Э', 'Ы', 'У', 'Ю', 'Я', ',', ';', 
					':', '.', '!', '?', '(', ')'};
			
			String sym1 = o1;
			String sym2 = o2;
	        for(int i = 0; i < vowels.length; i++) {
	        	if(o1.charAt(0) == vowels[i] ) {
	        		for(int j = 0; j < o1.length(); j++) {
	    	        	for(int n = 0; n < symbol.length; n++) {
	    	        		if(o1.charAt(j) != symbol[n]) {
	    	        			sym1 = Character.toString(o1.charAt(j));
	    	        			break;
	    	        		}
	    		        }	
	    	        }
	        	}
	        }
	        
	        for(int i = 0; i < vowels.length; i++) {
	        	if(o2.charAt(0) == vowels[i] ) {
	        		for(int j = 0; j < o2.length(); j++) {
	    	        	for(int n = 0; n < symbol.length; n++) {
	    	        		if(o2.charAt(j) != symbol[n]) {
	    	        			sym1 = Character.toString(o2.charAt(j));
	    	        			break;
	    	        		}
	    		        }	
	    	        }
	        	}
	        }
	        
	        int res = sym1.compareTo(sym2);
            return res;
        }
	};
	
	private String input() {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try {
			s = read.readLine();
			System.out.println();
		}catch(IOException e) {e.printStackTrace();}
		return s;
	}
	
	private int inputInt() {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int s = 0;
		try {
			s = Integer.parseInt(read.readLine());
			System.out.println();
		}catch(IOException e) {e.printStackTrace();}
		return s;
	}
}
