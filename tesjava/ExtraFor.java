import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ExtraFor {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("引数を入力してください");
      System.exit(1);
    }
    List<String> data = new ArrayList<>(Arrays.asList("りんご", "ごりら", "らっぱ", "ぱせり", "りんご"));
    data.addAll(Arrays.asList(args));
    for(final var d : data) {
      System.out.println(d);
    }
  }
}

// java版
// class Extrafor {
//   function main(args) {
//     if (args.length == 0) {
//       console.log("引数を入力してください")
//       return
//     }
//
//     data = "りんご", "ごりら", "らっぱ", "ぱせり", "りんご"
//     data.push(...args)
//     data.forEach(d => {
//         console.log(d)
//       })
//   }
// }
