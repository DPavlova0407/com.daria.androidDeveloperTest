package com.daria.androidDeveloperTest.tasks.Task2;

import com.daria.androidDeveloperTest.Task;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Daria on 05.02.2018.
 */
public class Task2 implements Task {
    private String text = "";
    Scanner scanner;
    ArrayList<Character> symbols = new ArrayList<>();
    Set<Character> setOfLetters = new HashSet<>();
    @Override
    public void run() throws FileNotFoundException {
        createSymbols();
        getText();
        showText();
        System.out.println("Искомые буквы: ");
        Set<Character> characterSet = getLetter();
        for (char c : characterSet){
            System.out.println(c);
        }

    }
    public Set<Character> getLetter(){
        text = text.toLowerCase();
        int max = 0;
        Map<Integer, Set<Character>> letterNum = new HashMap<>();

        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if (!symbols.contains(c) && !setOfLetters.contains(c)){
                setOfLetters.add(c);
                int k = numberOfLetterRepetitions(c);
                if (k > max)
                    max = k;
                if (letterNum.containsKey(k))
                    letterNum.get(k).add(c);
                else {
                    Set<Character> st = new HashSet<>();
                    st.add(c);
                    letterNum.put(k, st);
                }
            }
        }
        return letterNum.get(max);
    }

    public int numberOfLetterRepetitions(char c){
        int res = 0;
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == c)
                res++;
        }
        return res;
    }

    public void createSymbols(){
        symbols.add('\n');
        symbols.add(',');
        symbols.add('.');
        symbols.add(':');
        symbols.add(';');
        symbols.add('!');
        symbols.add('?');
        symbols.add(' ');
        symbols.add('-');
    }

    public void getText() throws FileNotFoundException {
        //scanner = new Scanner(new File("C:\\Users\\Daria\\com.daria.androidDeveloperTest\\src\\com\\daria\\androidDeveloperTest\\resources\\text.txt"));
        scanner = new Scanner(System.in);
        String input;
        while ((input = scanner.nextLine()).length() > 0)
            text += input;
        scanner.close();
    }
    public void showText(){
        System.out.println(text);
    }
}
