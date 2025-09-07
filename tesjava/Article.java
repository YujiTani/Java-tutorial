package to.msn.wings.selflearn.chap05;

import java.io.Serializable;

public class Article implements Serializable {
  // シリアライズUIDを持たせる事で、デシリアライズする時に照合が可能となる
  private static final long serialVersionUID = 1L;
  public String title;
  public String url;
  public transient boolean expired; // transientを付与すると、シリアライズ対象から外す事ができる

  public Article(String title, String url, boolean expired) {
    this.title = title;
    this.url = url;
    this.expired = expired;
  }
}
