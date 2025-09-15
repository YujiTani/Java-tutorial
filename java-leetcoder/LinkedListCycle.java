import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for singly-linked list.
 */
public class LinkedListCycle {
  public static void main(String[] args) {
    try {
      int[] ints = parseStringToInteger(args);
      LinkedListCycle listCycle = new LinkedListCycle(ints);
      listCycle.list();
    } catch(NumberFormatException e) {
      System.err.println("無効な数値が含まれています");
    }
  }

  private List<Integer> data = new ArrayList<>();

  // コンストラクター
  public LinkedListCycle(int[] intArray) {
    for (int i : intArray) {
      data.add(i);
    }
  }

  public void list() {
    System.out.println(this.data);
  }

  public boolean hasCycle() {
    return false;
  }

  // StringをInt[]に変換
  private static int[] parseStringToInteger(String[] strings) {
    if (validation(strings)) {
      return Arrays.stream(strings)
      .mapToInt(s -> Integer.parseInt(s))
      .toArray();
    }
    return new int[0];
  }

  // コンストラクターの受け取る値がStringかチェック
  private static boolean validation(String[] string) {
    if (string == null) {
      System.err.println("引数がnullになっています");
      return false;
    }

    if (!(string instanceof String[])) {
      System.err.println("引数が String[] ではありません。現在の型 "
      + string.getClass().getName());
      return false;
    }



    return true;
  }
}

