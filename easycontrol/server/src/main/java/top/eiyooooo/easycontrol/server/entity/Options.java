/*
 * 本项目大量借鉴学习了开源投屏软件：Scrcpy，在此对该项目表示感谢
 */
package top.eiyooooo.easycontrol.server.entity;

public final class Options {
  public static boolean isAudio = true;
  public static int maxSize = 1600;
  public static int maxVideoBit = 4000000;
  public static int maxFps = 60;
  public static boolean keepAwake = true;
  public static boolean TurnOnScreenIfStart = true;
  public static boolean TurnOffScreenIfStart = false;
  public static boolean TurnOffScreenIfStop = false;
  public static boolean TurnOnScreenIfStop = true;
  public static boolean useH265 = true;
  public static boolean useOpus = true;

  public static void parse(String... args) {
    for (String arg : args) {
      int equalIndex = arg.indexOf('=');
      if (equalIndex == -1) throw new IllegalArgumentException("参数格式错误");
      String key = arg.substring(0, equalIndex);
      String value = arg.substring(equalIndex + 1);
      switch (key) {
        case "isAudio":
          isAudio = Integer.parseInt(value) == 1;
          break;
        case "maxSize":
          maxSize = Integer.parseInt(value);
          break;
        case "maxFps":
          maxFps = Integer.parseInt(value);
          break;
        case "maxVideoBit":
          maxVideoBit = Integer.parseInt(value) * 1000000;
          break;
        case "keepAwake":
          keepAwake = Integer.parseInt(value) == 1;
          break;
        case "ScreenMode":
          int ScreenMode = Integer.parseInt(value);
          TurnOnScreenIfStart = (ScreenMode / 1000) % 10 == 1;
          TurnOffScreenIfStart = (ScreenMode / 100) % 10 == 1;
          TurnOffScreenIfStop = (ScreenMode / 10) % 10 == 1;
          TurnOnScreenIfStop = ScreenMode % 10 == 1;
          break;
        case "useH265":
          useH265 = Integer.parseInt(value) == 1;
          break;
        case "useOpus":
          useOpus = Integer.parseInt(value) == 1;
          break;
      }
    }
  }
}

