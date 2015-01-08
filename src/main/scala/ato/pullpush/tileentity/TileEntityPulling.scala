package ato.pullpush.tileentity

import net.minecraft.entity.Entity
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.AxisAlignedBB
import net.minecraftforge.common.util.ForgeDirection

import scala.collection.JavaConverters._
import scala.math._

class TileEntityPulling extends TileEntity {

  override def updateEntity() {
    val world = getWorldObj
    val dir = ForgeDirection.getOrientation(getBlockMetadata)
    val range = 16
    val ((sx, sy, sz), (dx, dy, dz)): ((Double, Double, Double), (Double, Double, Double)) = dir match {
      case ForgeDirection.UP => ((xCoord, yCoord + 1, zCoord), (xCoord + 1, yCoord + 1 + range, zCoord + 1))
      case ForgeDirection.DOWN => ((xCoord, yCoord - range, zCoord), (xCoord + 1, yCoord, zCoord + 1))
      case ForgeDirection.NORTH => ((xCoord, yCoord, zCoord - range), (xCoord + 1, yCoord + 1, zCoord))
      case ForgeDirection.SOUTH => ((xCoord, yCoord, zCoord + 1), (xCoord + 1, yCoord + 1, zCoord + 1 + range))
      case ForgeDirection.EAST => ((xCoord + 1, yCoord, zCoord), (xCoord + 1 + range, yCoord + 1, zCoord + 1))
      case ForgeDirection.WEST => ((xCoord - range, yCoord, zCoord), (xCoord, yCoord + 1, zCoord + 1))
    }
    val aabb = AxisAlignedBB.getBoundingBox(sx, sy, sz, dx, dy, dz)
    val entities = world.getEntitiesWithinAABB(classOf[Entity], aabb)
      .asInstanceOf[java.util.List[Entity]]
    val k = -0.2 * 10
    val (cx, cy, cz) = (xCoord + 0.5, yCoord + 0.5, zCoord + 0.5)
    for (e <- entities.asScala) {
      val dist = sqrt(pow(e.posX - cx, 2) + pow(e.posY - cy, 2) + pow(e.posZ - cz, 2))
      if (dist < range) {
        val dist2 = pow(max(dist, 1.5), 2)
        e.addVelocity(k * dir.offsetX / dist2, k * dir.offsetY / dist2, k * dir.offsetZ / dist2)
      }
    }
  }
}
