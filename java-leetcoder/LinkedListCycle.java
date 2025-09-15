import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for singly-linked list.
 */
public class LinkedListCycle {
  public static void main(String[] args) {
    try {
      // Stream APIを使ってコマンドライン引数をint配列に変換
      int[] ints = Arrays.stream(args)
      .mapToInt(s -> Integer.parseInt(s))
      .toArray();

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
}

