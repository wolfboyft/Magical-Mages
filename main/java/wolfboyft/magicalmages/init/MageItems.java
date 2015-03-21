package wolfboyft.magicalmages.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolfboyft.magicalmages.Reference;
import wolfboyft.magicalmages.entity.projectile.actual.WitherBolt;
import wolfboyft.magicalmages.misc.Staves;

public class MageItems {
	public static final Item staffWither = new Staves("staffWither", 0, 7, true, WitherBolt.class);
	
	public static void init(){
	}
	
	public static void register(){
		GameRegistry.registerItem(staffWither, staffWither.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders(){
		registerRender(staffWither);
	}
	
	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
