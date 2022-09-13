package net.earthspawn.mod.entities.classes;

import net.earthspawn.mod.Earthspawn;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID)
public class GoblinEntity extends Monster implements IAnimatable {

    static int attack_tick = 0;
    static boolean play_attack = false;

    private final AnimationFactory factory = new AnimationFactory(this);

    public GoblinEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.5f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.20f)
                .build();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.3f, false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblin.walk", true));
            event.getController().setAnimationSpeed(event.getLimbSwingAmount() * 6f);
            return  PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblin.idle", true));
        return PlayState.CONTINUE;
    }

    private <E extends IAnimatable> PlayState predicate_attacks(AnimationEvent<E> event) {
        System.out.print(attack_tick);
        System.out.print("\n");
        if (attack_tick > 0) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblin.attack", false));
            event.getController().setAnimationSpeed(2.0f);
            return  PlayState.CONTINUE;
        }
        event.getController().clearAnimationCache();
        return PlayState.STOP;
    }

    @Override
    public void tick() {
        attack_tick -= 1;
        if (attack_tick <= 0) {
            play_attack = false;
            attack_tick = 0;
        }
        super.tick();
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        System.out.print("hit");
        System.out.print("\n");
        if (!play_attack) {
            attack_tick = 20;
            play_attack = true;
        }

        return super.doHurtTarget(target);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
        data.addAnimationController(new AnimationController(this, "controller_attack",
                0, this::predicate_attacks));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
