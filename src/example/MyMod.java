package example;

import ethanjones.cubes.core.IDManager;
import ethanjones.cubes.core.event.EventHandler;
import ethanjones.cubes.core.event.world.generation.GenerationEvent;
import ethanjones.cubes.core.logging.Log;
import ethanjones.cubes.core.mod.Mod;
import ethanjones.cubes.core.mod.ModEventHandler;
import ethanjones.cubes.core.mod.event.PostInitializationEvent;
import ethanjones.cubes.core.mod.event.PreInitializationEvent;
import ethanjones.cubes.core.mod.event.StartingClientEvent;
import ethanjones.cubes.core.mod.event.StartingServerEvent;
import ethanjones.cubes.side.Sided;

@Mod
public class MyMod {

  private MyBlock myBlock;

  //Methods annotated with ModEventHandler can be called whatever you want
  //The parameter tells Cubes the type of ModEvent the method handles
  @ModEventHandler
  public void preInit(PreInitializationEvent event) {
    Log.info("Hello World");                            //Log "Hello World"
  }

  @ModEventHandler
  public void postInit(PostInitializationEvent event) {
    myBlock = new MyBlock();                            //Make instance of MyBlock
    myBlock.loadGraphics();                             //Graphics have to be loaded in PostInitializationEvent
  }

  @ModEventHandler
  public void startingClient(StartingClientEvent event) {
    IDManager.register(myBlock);          //Blocks have to registered in StartingClientEvent and StartingServerEvent
  }

  @ModEventHandler
  public void startingServer(StartingServerEvent event) {
    IDManager.register(myBlock);          //Blocks have to registered in StartingClientEvent and StartingServerEvent
    Sided.getEventBus().register(this);                 //Sets this as an EventHandler server side
  }

  //Methods annotated with EventHandler can be called whatever you want
  //The parameter tells Cubes the type of Event the method handles
  @EventHandler
  public void generationEvent(GenerationEvent event) {
    if (event.getAreaReference().areaX != 0 || event.getAreaReference().areaZ != 0) {
      event.getArea().setBlock(myBlock, 7, 100, 7);
      event.getArea().setBlock(myBlock, 7, 100, 8);
      event.getArea().setBlock(myBlock, 8, 100, 7);
      event.getArea().setBlock(myBlock, 8, 100, 8);
      event.getArea().setBlock(myBlock, 7, 101, 7);
      event.getArea().setBlock(myBlock, 7, 101, 8);
      event.getArea().setBlock(myBlock, 8, 101, 7);
      event.getArea().setBlock(myBlock, 8, 101, 8);
    }
  }
}
