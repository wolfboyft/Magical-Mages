package wolfboyft.magicalmages.entity.projectile.actual;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wolfboyft.magicalmages.init.MageItems;

public class ExcaliburBeam extends BaseProjectile {

	public ExcaliburBeam(World var1) {
		super(var1);
	}

	public ExcaliburBeam(World var1, EntityLivingBase var3, float dam) {
		super(var1, var3, dam);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onUpdate() {
		Random rand = new Random();
		super.onUpdate();
		for (int i = 0; i < 6; ++i) {
		}
	}

	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if (var1.entityHit != null) {
			if (!(var1.entityHit instanceof EntityLivingBase)) {
				this.setDead();
				worldObj.removeEntity(this);
				return;
			} else {
				if (var1.entityHit == getThrower()) {
					this.setDead();
					worldObj.removeEntity(this);
					return;
				}
				this.setDead();
				var1.entityHit.attackEntityFrom(
						DamageSource.causeThrownDamage(this, getThrower()),
						getDamage());
				((EntityLivingBase) var1.entityHit)
						.addPotionEffect(new PotionEffect(Potion.wither.id, 200));
				var1.entityHit.worldObj
						.spawnEntityInWorld(new EntityLightningBolt(
								var1.entityHit.worldObj, var1.entityHit.posX,
								var1.entityHit.posY, var1.entityHit.posZ));
				worldObj.createExplosion(this, posX, posY, posZ, 0.0F, true);
			}
		}

		if (var1.typeOfHit.BLOCK != null) {
			this.setDead();
			this.playSound("random.anvil_land", 0.5F, 0.5F);
			this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK,
					this.posX, this.posY, this.posZ,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					new int[] { Item.getIdFromItem(MageItems.excalibur) });
			this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK,
					this.posX, this.posY, this.posZ,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					new int[] { Item.getIdFromItem(MageItems.excalibur) });
			this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK,
					this.posX, this.posY, this.posZ,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					new int[] { Item.getIdFromItem(MageItems.excalibur) });
			this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK,
					this.posX, this.posY, this.posZ,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					new int[] { Item.getIdFromItem(MageItems.excalibur) });
			this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK,
					this.posX, this.posY, this.posZ,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					new int[] { Item.getIdFromItem(MageItems.excalibur) });
			worldObj.createExplosion(this, posX, posY, posZ, 0.0F, true);
		}
	}

	@Override
	protected float getGravityVelocity() {
		return 0.01F;
	}
}