package ato.pullpush

import ato.pullpush.block.BlockPulling
import ato.pullpush.proxy.ProxyCommon
import ato.pullpush.tileentity.TileEntityPulling
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.registry.GameRegistry
import cpw.mods.fml.common.{Mod, SidedProxy}

@Mod(modid = "PullPush", modLanguage = "scala")
object PullPush {

  @SidedProxy(
    clientSide = "ato.pullpush.proxy.ProxyClient",
    serverSide = "ato.pullpush.proxy.ProxyCommon"
  )
  var proxy: ProxyCommon = _

  val blockPulling = new BlockPulling()

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) {
    GameRegistry.registerBlock(blockPulling, "PullBlock")

    GameRegistry.registerTileEntity(classOf[TileEntityPulling], "PullingBlock")
  }
}
