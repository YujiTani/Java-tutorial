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
      listCycle.reverseSort();
      listCycle.list();
    } catch(NumberFormatException e) {
      System.err.println("無効な数値が含まれています");
    }
  }

  private List<Integer> data = new ArrayList<>();
  private int index = 0;

  // コンストラクター
  public LinkedListCycle(int[] intArray) {
    for (int i : intArray) {
      data.add(i);
    }

    this.index = intArray.length - 1; 
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

  private List<Integer> reverseSort() {
    for(int i = this.data.size() - 1; i > 0; i--) {
      for(int j = 0; j < this.data.size() - 1; j++){
        if(this.data.get(j) < this.data.get(j + 1)) {
          int tmp = this.data.get(j + 1);
          this.data.set(j + 1, this.data.get(j));
          this.data.set(j, tmp);
        }
      }
    }
    return this.data;
  }

  public boolean isNext() {
    if(this.index == 0 && this.data.get(this.index) == this.data.get(0)) {
      System.out.println("値は一つしかありません");
      return false;
    }

    if (!(this.data.get(this.index - 1))) {
      return false;
    }

    return true;
  }

  public int next() {
    if (this.index == 0) {
      return this.data.get(this.data.size() - 1);
    }

    int res = this.data.get(index - 1);
    this.index--;
    return res;
  }
}

