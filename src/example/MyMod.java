package example;

import ethanjones.cubes.block.Block;
import ethanjones.cubes.core.IDManager;
import ethanjones.cubes.core.logging.Log;
import ethanjones.cubes.core.mod.Mod;
import ethanjones.cubes.core.mod.ModEventHandler;
import ethanjones.cubes.core.mod.event.PreInitializationEvent;

@Mod
public class MyMod {

  private Block myBlock;

  @ModEventHandler
  public void preInit(PreInitializationEvent event) {
    Log.info("Hello World");                            //Log "Hello World"
    myBlock = new Block("MyMod:texture");               //Make instance of a custom block
    IDManager.register(myBlock);                        //Register MyBlock
  }
}
