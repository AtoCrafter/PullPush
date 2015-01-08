package ato.pullpush

import ato.pullpush.proxy.ProxyCommon
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.{Mod, SidedProxy}

@Mod(modid = "PullPush", modLanguage = "scala")
object PullPush {

  @SidedProxy(
    clientSide = "ato.pullpush.proxy.ProxyClient",
    serverSide = "ato.pullpush.proxy.ProxyCommon"
  )
  var proxy: ProxyCommon = _

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) {
  }
}
