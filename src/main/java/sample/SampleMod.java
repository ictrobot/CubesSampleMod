package sample;

import ethanjones.cubes.block.Block;
import ethanjones.cubes.core.id.IDManager;
import ethanjones.cubes.core.logging.Log;
import ethanjones.cubes.core.mod.Mod;
import ethanjones.cubes.core.mod.ModEventHandler;
import ethanjones.cubes.core.mod.event.PreInitializationEvent;

@Mod
public class SampleMod {

  private Block sampleBlock;

  @ModEventHandler
  public void preInit(PreInitializationEvent event) {
    Log.info("Hello World");                            //Log "Hello World"
    sampleBlock = new Block("samplemod:sample");        //Make instance of a custom block
    IDManager.register(sampleBlock);                    //Register MyBlock
  }
}
