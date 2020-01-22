public class HashTest {    

    public static void main(String[] args) {

        HashTable test = new HashTable(11342,11630,71269);

        int testArr[] = new int[]{33572080};

        for (int i = 0; i < testArr.length; i++) {
            test.insert(testArr[i]);
        }
         // System.out.println(test.find(4));

         // test.remove(4);

         // System.out.println(test.find(4));
    }

}