package wolfboyft.magicalmages.entity.mob.boss.render;

import net.minecraft.client.model.ModelWither;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wolfboyft.magicalmages.entity.mob.boss.actual.HallowMaster;
import wolfboyft.magicalmages.entity.mob.boss.render.layer.LayerHallowMasterAura;

@SideOnly(Side.CLIENT)
public class RenderHallowMaster extends RenderLiving
{
    private static final ResourceLocation invulnerableWitherTextures = new ResourceLocation("magicalmages:textures/entity/hallow/witherHallow/witherHallow_invulnerable.png");
    private static final ResourceLocation witherTextures = new ResourceLocation("magicalmages:textures/entity/hallow/witherHallow/witherHallow.png");
    private static final String __OBFID = "CL_00001034";

    public RenderHallowMaster(RenderManager p_i46130_1_)
    {
        super(p_i46130_1_, new ModelWither(0.0F), 1.0F);
        this.addLayer(new LayerHallowMasterAura(this));
    }

    public void func_180591_a(HallowMaster p_180591_1_, double p_180591_2_, double p_180591_4_, double p_180591_6_, float p_180591_8_, float p_180591_9_)
    {
        BossStatus.setBossStatus(p_180591_1_, true);
        super.doRender((EntityLiving)p_180591_1_, p_180591_2_, p_180591_4_, p_180591_6_, p_180591_8_, p_180591_9_);
    }

    protected ResourceLocation getEntityTexture(HallowMaster entity)
    {
        int i = entity.getInvulTime();
        return i > 0 && (i > 80 || i / 5 % 2 != 1) ? invulnerableWitherTextures : witherTextures;
    }

    protected void func_180592_a(HallowMaster p_180592_1_, float p_180592_2_)
    {
        float f1 = 2.0F;
        int i = p_180592_1_.getInvulTime();

        if (i > 0)
        {
            f1 -= ((float)i - p_180592_2_) / 220.0F * 0.5F;
        }

        GlStateManager.scale(f1, f1, f1);
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        this.func_180591_a((HallowMaster)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        this.func_180592_a((HallowMaster)p_77041_1_, p_77041_2_);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        this.func_180591_a((HallowMaster)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((HallowMaster)entity);
    }

    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        this.func_180591_a((HallowMaster)entity, x, y, z, p_76986_8_, partialTicks);
    }
}