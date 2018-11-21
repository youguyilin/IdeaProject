package algorithm;
/**
 * PackageName: algorithm
 * ClassName: ReplaceBlank
 * Author: CYP2017
 * Date: 2018/11/8 15:15
 * Description:
 */
public class FeiboNaQie {
    public static void main(String[] args){

        System.out.println(Feibl(10));
    }

    private static long Feibl(int n){
        return n < 2 ?(n < 1 ? 0 : 1) :Feibl(n - 1) + Feibl(n - 2);
    }
}
