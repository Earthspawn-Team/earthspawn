package net.earthspawn.mod.items.melees;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class CrystalSwordItem extends SwordItem {

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            target.hurt(DamageSource.GENERIC, getDamage() + target.getArmorValue());
            target.getServer().getLevel(attacker.getLevel().dimension()).sendParticles(ParticleTypes.WITCH, target.getX(), target.getY(), target.getZ(), 10, 1, 0.5, 0.5, 0.5);
        }
        return super.hurtEnemy(itemStack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(new TranslatableComponent("item.earthspawn.crystal_sword.description"));
        super.appendHoverText(itemStack, level, components, flag);
    }

    public CrystalSwordItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }
}
