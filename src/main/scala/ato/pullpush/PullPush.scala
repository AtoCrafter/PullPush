package ato.pullpush

import ato.pullpush.block.{BlockPulling, BlockPushing}
import ato.pullpush.proxy.ProxyCommon
import ato.pullpush.tileentity.{TileEntityPulling, TileEntityPushing}
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.registry.GameRegistry
import cpw.mods.fml.common.{Mod, SidedProxy}
import net.minecraft.init.Blocks
import net.minecraft.item.ItemStack

@Mod(modid = "PullPush", modLanguage = "scala")
object PullPush {

  @SidedProxy(
    clientSide = "ato.pullpush.proxy.ProxyClient",
    serverSide = "ato.pullpush.proxy.ProxyCommon"
  )
  var proxy: ProxyCommon = _

  val blockPulling = new BlockPulling()
  val blockPushing = new BlockPushing()

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) {
    GameRegistry.registerBlock(blockPulling, "PullBlock")
    GameRegistry.registerBlock(blockPushing, "PushBlock")

    GameRegistry.registerTileEntity(classOf[TileEntityPulling], "PullingBlock")
    GameRegistry.registerTileEntity(classOf[TileEntityPushing], "PushingBlock")

    GameRegistry.addRecipe(new ItemStack(blockPulling),
      "OOO",
      " DO",
      "OOO",
      new Character('O'), Blocks.obsidian,
      new Character('D'), Blocks.diamond_block)
    GameRegistry.addRecipe(new ItemStack(blockPushing),
      "OOO",
      " EO",
      "OOO",
      new Character('O'), Blocks.obsidian,
      new Character('E'), Blocks.emerald_block)
  }
}
