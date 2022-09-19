package net.earthspawn.mod.entities.classes;

import net.earthspawn.mod.Earthspawn;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Random;
import java.util.function.Predicate;

public class GoblinEntity extends Monster implements IAnimatable{

    // Define an animation event handler
    private AnimationFactory factory = new AnimationFactory(this);

    private boolean canBreakDoors;
    private static float distance_to_target = 0;
    public boolean playAttackAnimation = false;
    public int attackTick=1;
    // Enumerate attack States
    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(GoblinEntity.class,
            EntityDataSerializers.INT);

    private final BreakDoorGoal breakDoorGoal = new BreakDoorGoal(this, DOOR_BREAKING_PREDICATE);
    private static final Predicate<Difficulty> DOOR_BREAKING_PREDICATE = (mode) -> {
        return mode == Difficulty.HARD || mode == Difficulty.NORMAL;
    };

    public GoblinEntity(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 10;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {

        // Take our attack AI To register
        this.goalSelector.addGoal(1, new GoblinEntity.AttackGoal(this));
        this.goalSelector.addGoal(2, new DundAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }


    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12.0D)
                .add(Attributes.ATTACK_DAMAGE, 0.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.20f)
                .build();
    }


    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            this.playAttackAnimation=false;
            return false;
        }
        else{
            if(entityIn instanceof LivingEntity)
            {
                float f = this.level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
                ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.WITHER, 100 * (int)f,0,true,true));
            }
            return true;
        }

    }

    // In this state, the player controls various actions of the creature at ordinary times
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        // Creatures are moving , Just play the moving animation , Path and section 2 The action string of the step corresponds to
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblin.walk", true));
            return PlayState.CONTINUE;
        }

        // If you don't move, play the animation when it's idle
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblin.idle", true));
        return PlayState.CONTINUE;
    }

    // In this state, the player controls various actions when the creature attacks
    private <E extends IAnimatable> PlayState predicate1(AnimationEvent<E> event) {
        // If the creature's attack status is 1 And no death , Just execute this attack animation
            if ((this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) && this.distance_to_target < 3) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblin.attack", true));
                return PlayState.CONTINUE;
            } else {
                event.getController().clearAnimationCache();
                return PlayState.STOP;
            }
        // If the creature's attack status is 2 And no death , Just execute this attack animation
//		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
//			event.getController().setAnimation(new AnimationBuilder().addAnimation("fire", true));
//			return PlayState.CONTINUE;
//		}
        // If the creature's attack status is 3 And no death , Just execute this attack animation
        //...

        // Stop after broadcasting
    }

    // Register all our previous animation controllers
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
        data.addAnimationController(new AnimationController(this, "controller1",
                0, this::predicate1));
    }

    @Override
    public AnimationFactory getFactory() {
        // TODO Auto-generated method stub
        return this.factory;
    }

    // Biological entity sound
    @Nullable
    protected SoundEvent getAmbientSound() {
        return SoundEvents.RAVAGER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.RAVAGER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.RAVAGER_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockstate) {
        this.playSound(SoundEvents.RAVAGER_STEP, 0.15F, 1.0F);
    }

    static class DundAttackGoal extends MeleeAttackGoal {
        private final GoblinEntity zombie;

        public DundAttackGoal(GoblinEntity entity, double p_i46803_2_, boolean p_i46803_4_) {
            super(entity, p_i46803_2_, p_i46803_4_);
            this.zombie=entity;
        }
    }

    public boolean canBreakDoors() {
        return this.canBreakDoors;
    }

    protected boolean supportsBreakDoorGoal() {
        return true;
    }
    // Can monsters break through the door
    public void setCanBreakDoors(boolean p_34337_) {
        if (this.supportsBreakDoorGoal() && GoalUtils.hasGroundPathNavigation(this)) {
            if (this.canBreakDoors != p_34337_) {
                this.canBreakDoors = p_34337_;
                ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(p_34337_);
                if (p_34337_) {
                    this.goalSelector.addGoal(1, this.breakDoorGoal);
                } else {
                    this.goalSelector.removeGoal(this.breakDoorGoal);
                }
            }
        } else if (this.canBreakDoors) {
            this.goalSelector.removeGoal(this.breakDoorGoal);
            this.canBreakDoors = false;
        }

    }

    public int getAttckingState() {
        return this.entityData.get(STATE);
    }

    public void setAttackingState(int time) {
        this.entityData.set(STATE, time);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, 0);
    }

    // Our biological AI, Decide which attack to use
    static class AttackGoal extends Goal {
        private final GoblinEntity parentEntity;
        // Attack timer
        protected int attackTimer = 0;
        public AttackGoal(GoblinEntity mob) {
            this.parentEntity = mob;
        }

        public boolean canUse() {
            return this.parentEntity.getTarget() != null;
        }

        public void start() {
            super.start();
            this.parentEntity.setAggressive(true);
        }

        @Override
        public void stop() {
            super.stop();
            this.parentEntity.setAggressive(false);
            this.parentEntity.setAttackingState(0);
            this.attackTimer = -1;
        }

        public void tick() {
            LivingEntity livingentity = this.parentEntity.getTarget();
            this.parentEntity.distance_to_target = this.parentEntity.distanceTo(livingentity);
            System.out.print(this.parentEntity.distance_to_target);
            System.out.print("\n");
            if (this.parentEntity.hasLineOfSight(livingentity)) {
                Level world = this.parentEntity.level;
                ++this.attackTimer;
                Random rand = new Random();
                Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
                double d0 = Math.min(livingentity.getY(), livingentity.getY());
                double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
                double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
                double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
                double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
                float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
                        livingentity.getX() - parentEntity.getX());

                this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
                if (this.attackTimer == 15) {
                    //  Set the creature's attack state to 2
                    this.parentEntity.setAttackingState(2);
                }
                else {
                    //  Set the creature's attack state to 1
                    this.parentEntity.setAttackingState(1);
                }

                // When the timer comes to an end , Set the attack status to 0, At the same time, the timer clears 0
                if (this.attackTimer == 30) {
                    this.parentEntity.setAttackingState(0);
                    this.attackTimer = -5;
                }
            }
            else if (this.attackTimer > 0) {
                --this.attackTimer;
            }
            this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
        }

    }
}
