class YieldTest {
  public static void main(String[] day) {
    if(day.length == 0) {
      System.err.println("Error");
      System.exit(1);
    };

    int len =
      switch (day[0]) {
        case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
        case "TUESDAY"                -> 7;
        case "THURSDAY", "SATURDAY"     -> 8;
        case "WEDNESDAY"              -> 9;
        default -> -1;
    };

    System.out.println(len);
  }
}
