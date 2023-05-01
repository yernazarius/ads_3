public class TempClass {
    public String str1;
    public String str2;

    public TempClass(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        for (char ch: str1.toCharArray()) {
            hash = ch + 31 * hash;
        }
        int another_hash = 0;
        for (char ch: str2.toCharArray()) {
            another_hash = ch + 31 * another_hash;
        }

        return hash + 31 * another_hash;
    }
}