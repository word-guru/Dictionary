import dictionary.Dictionary;

public class Main {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary();

        //dic.printDictionary();
        dic.toChange("Monday","Nooo");
        dic.printDictionary("Monday");
        dic.addWord("word","слово");
        dic.printDictionary();
    }
}