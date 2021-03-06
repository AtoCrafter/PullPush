package ato.pullpush.block

import ato.pullpush.tileentity.TileEntityPulling
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

class BlockPulling extends BlockPullPush {
  setBlockName("PullBlock")

  override def createNewTileEntity(world: World, meta: Int): TileEntity =
    new TileEntityPulling()

  override def faceTextureName: String = "diamond_block"
}
