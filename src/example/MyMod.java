package example;

import ethanjones.modularworld.core.logging.Log;
import ethanjones.modularworld.core.mod.Mod;

public class MyMod implements Mod {
  @Override
  public void create() {
    Log.info("Hello World");
  }
}
