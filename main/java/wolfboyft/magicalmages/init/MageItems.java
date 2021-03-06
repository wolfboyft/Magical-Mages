package wolfboyft.magicalmages.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolfboyft.magicalmages.MagicalMages;
import wolfboyft.magicalmages.Reference;
import wolfboyft.magicalmages.entity.projectile.actual.ExcaliburBeam;
import wolfboyft.magicalmages.entity.projectile.actual.Kunai;
import wolfboyft.magicalmages.entity.projectile.actual.MagicKunai;
import wolfboyft.magicalmages.entity.projectile.actual.MagicShuriken;
import wolfboyft.magicalmages.entity.projectile.actual.Shuriken;
import wolfboyft.magicalmages.entity.projectile.actual.WitherBolt;
import wolfboyft.magicalmages.items.AdvancedSword;
import wolfboyft.magicalmages.items.Staves;
import wolfboyft.magicalmages.items.ThrowableWeapon;
import wolfboyft.magicalmages.misc.EnumArmour;

public class MageItems {
	public static final Item staffWither = new Staves("staffWither", 1024, 7, false, WitherBolt.class);
	public static final Item witherBone = new Item().setUnlocalizedName("witherBone")
			.setCreativeTab(MagicalMages.tabModMM);
	public static final Item witherRib = new Item().setUnlocalizedName("witherRib")
			.setCreativeTab(MagicalMages.tabModMM);
	public static final Item shuriken = new ThrowableWeapon("shuriken", 5, Shuriken.class);
	public static final Item kunai = new ThrowableWeapon("kunai", 4, Kunai.class);
	public static final Item magicShuriken = new ThrowableWeapon("magicShuriken", 20, MagicShuriken.class);
	public static final Item magicKunai = new ThrowableWeapon("magicKunai", 16, MagicKunai.class);
	public static Item witherHelmet;
	public static Item witherChest;
	public static Item witherLegs;
	public static Item witherBoots;
	public static Item ninjaHelmet;
	public static Item ninjaChest;
	public static Item ninjaLegs;
	public static Item ninjaBoots;

	public static ToolMaterial god = EnumHelper.addToolMaterial("GodMaterial", 100, -1, 5, 50, 5245);

	public static final Item excalibur = new AdvancedSword(god, "excalibur", ExcaliburBeam.class, true, true);

	public static void init() {
		int HEAD = Armours.HEAD;
		int BODY = Armours.BODY;
		int LEGS = Armours.LEGS;
		int BOOTS = Armours.BOOTS;
		witherHelmet = new Armours(EnumArmour.WITHER, HEAD);
		witherChest = new Armours(EnumArmour.WITHER, BODY);
		witherLegs = new Armours(EnumArmour.WITHER, LEGS);
		witherBoots = new Armours(EnumArmour.WITHER, BOOTS);
		ninjaHelmet = new Armours(EnumArmour.NINJA, HEAD);
		ninjaChest = new Armours(EnumArmour.NINJA, BODY);
		ninjaLegs = new Armours(EnumArmour.NINJA, LEGS);
		ninjaBoots = new Armours(EnumArmour.NINJA, BOOTS);
	}

	public static void register() {
		GameRegistry.registerItem(witherBone, witherBone.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(witherRib, witherRib.getUnlocalizedName().substring(5));
		GameRegistry.addRecipe(new ItemStack(staffWither, 1), "CBC", " A ", " D ", 'A', witherBone, 'B',
				Items.nether_star, 'C', witherRib, 'D', new ItemStack(Items.skull, 1, 1));
		GameRegistry.addRecipe(new ItemStack(shuriken, 16), "A A", " B ", "A A", 'A', Items.flint, 'B',
				Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(kunai, 16), "  A", "CA ", "BC ", 'A', Items.flint, 'B', Items.stick, 'C',
				Items.string);
		GameRegistry.addRecipe(new ItemStack(magicKunai, 8), "ACA", "CBC", "ACA", 'A', Items.iron_ingot, 'B', kunai,
				'C', Items.gold_nugget);
		GameRegistry.addRecipe(new ItemStack(magicShuriken, 8), "ACA", "CBC", "ACA", 'A', Items.iron_ingot, 'B',
				shuriken, 'C', Items.gold_nugget);
		GameRegistry.addRecipe(new ItemStack(witherHelmet, 1), "AAA", "ABA", 'A', witherBone, 'B', Items.nether_star);
		GameRegistry.addRecipe(new ItemStack(witherChest, 1), "ABA", "AAA", "AAA", 'A', witherBone, 'B',
				Items.nether_star);
		GameRegistry.addRecipe(new ItemStack(witherLegs, 1), "AAA", "ABA", "A A", 'A', witherBone, 'B',
				Items.nether_star);
		GameRegistry.addRecipe(new ItemStack(witherBoots, 1), "ABA", "A A", 'A', witherBone, 'B', Items.nether_star);
		GameRegistry.addRecipe(new ItemStack(excalibur, 1), "DED", "BAB", "DCD", 'A', Blocks.dragon_egg, 'B',
				Items.nether_star, 'C', Items.stick, 'D', new ItemStack(Items.golden_apple, 6, 1), 'E', staffWither);
		GameRegistry.addRecipe(new ItemStack(ninjaHelmet), "BAB", "ACA", 'A', Blocks.wool, 'B', Items.leather, 'C',
				Items.gold_nugget);
		GameRegistry.addRecipe(new ItemStack(ninjaChest), "BCB", "AAA", "AAA", 'A', Blocks.wool, 'B', Items.leather,
				'C', Items.gold_nugget);
		GameRegistry.addRecipe(new ItemStack(ninjaLegs), "ABA", "ACA", "B B", 'A', Blocks.wool, 'B', Items.leather, 'C',
				Items.gold_nugget);
		GameRegistry.addRecipe(new ItemStack(ninjaBoots), "ACA", "B B", 'A', Blocks.wool, 'B', Items.leather, 'C',
				Items.gold_nugget);
	}

	public static void registerRenders() {
		registerRender(staffWither);
		registerRender(witherBone);
		registerRender(witherRib);
		registerRender(shuriken);
		registerRender(kunai);
		registerRender(magicShuriken);
		registerRender(magicKunai);
		registerRender(witherHelmet);
		registerRender(witherChest);
		registerRender(witherLegs);
		registerRender(witherBoots);
		registerRender(ninjaHelmet);
		registerRender(ninjaChest);
		registerRender(ninjaLegs);
		registerRender(ninjaBoots);
		registerRender(excalibur);
	}

	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(
				Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
