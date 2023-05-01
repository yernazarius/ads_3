import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyHashTable<TempClass, Integer> hashTable = new MyHashTable<>();
        for(int i = 0; i < 10000; i++) {
            String str1 = stringGenerator(12);
            String str2 = stringGenerator(12);
            TempClass tempClass = new TempClass(str1, str2);
            hashTable.put(tempClass, i);
        }
        System.out.println(Arrays.toString(hashTable.printBucketSize()));
    }

    public static String stringGenerator(int length) {
        String str = "";
        for (int i = 0; i < length; i++) {
            str += (char) (Math.random() * 26 + 'a');
        }
        return str;
    }
}