package ato.pullpush.block

import ato.pullpush.tileentity.TileEntityPushing
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

class BlockPushing extends BlockPullPush {
  setBlockName("PushBlock")

  override def createNewTileEntity(world: World, meta: Int): TileEntity =
    new TileEntityPushing()
}
