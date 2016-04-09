package OATest;

import java.util.*;

/*
搜狐员工小王最近利用假期在外地旅游，在某个小镇碰到一个马戏团表演，精彩的表演结束后发现团长正和大伙在帐篷前激烈讨论，
小王打听了下了解到， 马戏团正打算出一个新节目“最高罗汉塔”，即马戏团员叠罗汉表演。考虑到安全因素，要求叠罗汉过程中，
站在某个人肩上的人应该既比自己矮又比自己瘦，或相等。 团长想要本次节目中的罗汉塔叠的最高，由于人数众多，正在头疼如何安排人员的问题。
小王觉得这个问题很简单，于是统计了参与最高罗汉塔表演的所有团员的身高体重，并且很快找到叠最高罗汉塔的人员序列。 
现在你手上也拿到了这样一份身高体重表，请找出可以叠出的最高罗汉塔的高度，这份表中马戏团员依次编号为1到N。 
 */

/*解析：
  这是一类的题目，要求每个人由不同的属性，然后按照某些属性来排序求最值，注意点：
  1: 需要自己设计Actor类并且实现Comparator或者Comparable接口
  2:根据一个属性排序，注意override的compare或者compareTo函数
  3: 对于另外的属性，可以转换成LIS问题
 
 */

//别人的解法，自己再单独写一遍！！！！
public class SohuTest1 
{
    public static class people implements Comparator<people>{
        int num;
        int weight;
        int height;
        public int compare(people o1, people o2) {
            if(o1.weight != o2.weight){
                return o1.weight - o2.weight;
            }else{
                return o2.height - o1.height;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            people[] p=new people[n];
            for(int i=0;i<n;i++){
                p[i]=new people();
                p[i].num=in.nextInt();
                p[i].weight=in.nextInt();
                p[i].height=in.nextInt();
            }
            Arrays.sort(p,new people());
            int[] b=new int[n];
            b[0]=1;
            for(int i=1;i<n;i++){
                b[i]=1;
                for(int j=0;j<i;j++){
                    if(p[i].height>=p[j].height&&b[i]<b[j]+1){
                        b[i]=b[j]+1;
                    }
                }
            }
            int max=0;
            for(int i=0;i<n;i++){
                if(max<b[i]){
                    max=b[i];
                }
            }
            System.out.println(max);
        }
    }

}
