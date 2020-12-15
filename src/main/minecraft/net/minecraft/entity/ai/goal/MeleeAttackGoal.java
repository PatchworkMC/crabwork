package net.minecraft.entity.ai.goal;

import java.util.EnumSet;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class MeleeAttackGoal extends Goal {
    @Shadow
    @Final
    protected CreatureEntity attacker;
    @Shadow
    @Final
    private double speedTowardsTarget;
    @Shadow
    @Final
    private boolean longMemory;
    @Shadow
    private Path path;
    @Shadow
    private double targetX;
    @Shadow
    private double targetY;
    @Shadow
    private double targetZ;
    @Shadow
    private int delayCounter;
    @Shadow
    private int field_234037_i_;
    @Shadow
    @Final
    private int attackInterval;
    @Shadow
    private long field_220720_k;
    @Shadow
    private int failedPathFindingPenalty;
    @Shadow
    private boolean canPenalize;

    @Shadow
    public MeleeAttackGoal(CreatureEntity creature, double speedIn, boolean useLongMemory) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean shouldExecute() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean shouldContinueExecuting() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void startExecuting() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void resetTask() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void func_234039_g_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean func_234040_h_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected int func_234041_j_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected int func_234042_k_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected double getAttackReachSqr(LivingEntity attackTarget) {
        throw new UnsupportedOperationException();
    }
}
