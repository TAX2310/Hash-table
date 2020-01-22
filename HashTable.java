import java.util.*;

public class HashTable {

    // public for testing purposes
    public int buckets[];

    long a,c;
    int m;

    public HashTable(long _a, long _c, long _m) {
        
        this.a = _a;
        this.c = _c;
        this.m = (int)_m;
        
        buckets = new int[m];
        Arrays.fill(buckets, -1);

        // System.out.println(Arrays.toString(buckets));
    }

    public void insert(int key) {


        int h = (int) hash(key);

        if (loadFactor() == 1) {
                extend();
            }
        for (int i = 0; i < m; i++) {
            if (buckets[(h+i)%m] == -1) {
                    buckets[(h+i)%m] = key;
                    break;
            }
        }
        // System.out.println(Arrays.toString(buckets)+"B");
    }

    public void extend(){

        int temp[] = new int[m];

        int tempLen = temp.length;

        for (int i = 0; i < m; i++) {
            temp[i] = buckets[i];
             System.out.println(Arrays.toString(temp)+"T");
        }

        buckets = new int[m * 2];
        Arrays.fill(buckets, -1);

        m = buckets.length;

        for (int j = 0; j < tempLen; j++) {
            insert(temp[j]);
        }

    }

    public boolean find(int key) {

        int h = (int) hash(key);

        for (int i = 0; i < m; i++) {
            if (buckets[(h+i)%m] == key) {
                return true;
            }
        }
        return false;
    }

    public void remove(int key) {

        int h = (int) hash(key);

        for (int i = 0; i < m; i++) {
            if (buckets[(h+i)%m] == key) {
                buckets[(h+i)%m] = -1;
            }
        }
        System.out.println(Arrays.toString(buckets));
    }

    public double loadFactor() {

        double count = 0;

        for (int i = 0; i < m; i++) {
            if (buckets[i] != -1) {
                count = count + 1;
            }
        }

        double factor = count/m;

        return factor;
    }

    public long hash(int key) {

        long h = (a * key + c) % m;
        System.out.println(h);
        return h;
    }


}
