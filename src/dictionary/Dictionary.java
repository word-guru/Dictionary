package dictionary;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String,String> engRus;
    private Map<String, Integer> count;

    public Dictionary() {
        engRus = new HashMap<>();
        count = new HashMap<>();
        engRus.put("Monday", "Понедельник");
        count.put("Monday", 0);
        engRus.put("Tuesday", "Вторник");
        count.put("Tuesday", 0);
        engRus.put("Wednesday", "Среда");
        count.put("Wednesday", 0);
        engRus.put("Thursday", "Четверг");
        count.put("Thursday", 0);
        engRus.put("Friday", "Пятница");
        count.put("Friday", 0);
    }

    public void printDictionary()
    {
        for(var item : engRus.entrySet()) {
            System.out.println(item);
        }
    }
    public void printDictionary(String key)
    {
        if(engRus.containsKey(key)) {
            System.out.println(key + " - " + engRus.get(key));
            count.computeIfPresent(key, (k,v) -> v++);
        }
        else
            System.out.println("Нет такого слова в словаре!!!");
    }
    public void addWord(String key,String value)
    {
        if(!engRus.containsKey(key)) {
            engRus.putIfAbsent(key, value);
            count.putIfAbsent(key,0);
        }
        else
            System.out.println("Такое слово уже есть в словаре!!!");
    }
    public void revoveWord(String key)
    {
        engRus.remove(key);
        count.remove(key);
    }
    public void toChange(String key,String value)
    {
        engRus.computeIfPresent(key, (k,v) -> v = value);

    }
    public void popularWord()
    {
        int max = (Collections.max(count.values()));
        String key ="";
        for (var item : count.entrySet())
        {
            if(item.getValue() == max){
                key = item.getKey();
                break;
            }
        }
        printDictionary(key);
    }
    public void unpopularWord()
    {
        int min = (Collections.min(count.values()));
        String key ="";
        for (var item : count.entrySet())
        {
            if(item.getValue() == min){
                key = item.getKey();
                break;
            }
        }
        printDictionary(key);
    }

}
