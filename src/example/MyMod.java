package example;

import ethanjones.cubes.core.logging.Log;
import ethanjones.cubes.core.mod.Mod;

public class MyMod implements Mod {

  @Override
  public void create() {
    Log.info("Hello World");
  }
}
