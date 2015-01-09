package ato.pullpush.block

import net.minecraft.block.material.Material
import net.minecraft.block.{Block, ITileEntityProvider}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.util.MathHelper
import net.minecraft.world.World

abstract class BlockPullPush extends Block(Material.iron) with ITileEntityProvider {
  setCreativeTab(CreativeTabs.tabBlock)
  setBlockTextureName("obsidian")

  override def onBlockPlacedBy(world: World, x: Int, y: Int, z: Int, entity: EntityLivingBase, itemstack: ItemStack) {
    val meta = entity.rotationPitch match {
      case p if p > 60 => 1
      case p if p < -60 => 0
      case _ => MathHelper.floor_double((entity.rotationYaw * 4 / 360) + 0.5) & 3 match {
        case 0 => 2
        case 1 => 5
        case 2 => 3
        case 3 => 4
      }
    }
    world.setBlockMetadataWithNotify(x, y, z, meta, 2)
  }
}
