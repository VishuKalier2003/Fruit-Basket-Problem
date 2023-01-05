/* You are visiting a farm that has a single row of fruit trees arranged from left to right... The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces...You want to collect as much fruit as possible... However, the owner has some strict rules that you must follow:
* You only have two baskets, and each basket can only hold a single type of fruit... There is no limit on the amount of fruit each basket can hold...
* Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right... The picked fruits must fit in one of your baskets...
* Once you reach a tree with fruit that cannot fit in your baskets, you must stop...
Given the integer array fruits, return the maximum number of fruits you can pick. 
  * Eg 1: fruits = [1, 2, 1]            Basket = 3   Reason: We can hold fruits of all three trees...
  * Eg 2: fruits = [0, 1, 2, 2]         Basket = 3   Reason: We pick [1, 2, 2]...
  * Eg 3: fruits = [1, 2, 3, 2, 2]      Basket = 4   Reason: We pick [2, 3, 2, 2]...*/
import java.util.*;
public class FruitBasket
{
    public int MaximumFruits(int tree[])
    {
        Map<Integer, Integer> count = new HashMap<>();   // Mapping Integer to Integer...
        int i = 0, j;
        for (j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            if (count.size() > 2) {    // When size of Hash map is more than 2...
                count.put(tree[i], count.get(tree[i]) - 1);
                count.remove(tree[i++], 0);
            }
        }
        return j - i;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the number of Fruits : ");
        x = sc.nextInt();
        int tree[] = new int[x];
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter the type of fruit of "+(i+1)+" th Tree : ");
            tree[i] = sc.nextInt();
        }
        FruitBasket fruitbasket = new FruitBasket();   // Object creation...
        x = fruitbasket.MaximumFruits(tree);      // Function call...
        System.out.println("The Maximum fruits possible : "+x);
        sc.close();
    }
}


// Time Complexity  - O(n) time...
// Space Complexity - O(n) space...

/* DEDUCTIONS :- 
 * 1. We use the criterion of Hash map and store the first two elements in the Hash map...
 * 2. Traverse the Array in the form of Queue...
*/