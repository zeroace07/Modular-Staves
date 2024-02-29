package io.redspace.ironsspellbooks.compat.tetra.effects;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.network.ClientboundSyncMana;
import io.redspace.ironsspellbooks.setup.Messages;
import io.redspace.ironsspellbooks.item.CastingItem;
import io.redspace.ironsspellbooks.render.StaffArmPose;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import se.mickelus.tetra.blocks.workbench.gui.WorkbenchStatsGui;
import se.mickelus.tetra.effect.ItemEffect;
import se.mickelus.tetra.gui.stats.StatsHelper;
import se.mickelus.tetra.gui.stats.bar.GuiStatBar;
import se.mickelus.tetra.gui.stats.getter.IStatGetter;
import se.mickelus.tetra.gui.stats.getter.LabelGetterBasic;
import se.mickelus.tetra.gui.stats.getter.StatGetterEffectLevel;
import se.mickelus.tetra.gui.stats.getter.TooltipGetterPercentage;
import se.mickelus.tetra.items.modular.ModularItem;
import se.mickelus.tetra.items.modular.impl.holo.gui.craft.HoloStatsGui;
import se.mickelus.tetra.items.modular.ItemModularHandheld;



public class CastingImplementTetraEffect extends CastingItem {
    public static final ItemEffect castingImplement = ItemEffect.get("modular_staves:casting_implement");
    public static final String castingImplementName = "modular_staves.tetra_effect.casting_implement";
    public static final String castingImplementTooltip = "modular_staves.tetra_effect.casting_implement.tooltip";

    @OnlyIn(Dist.CLIENT)
    public static void addGuiBars() {
        final IStatGetter effectStatGetter = new StatGetterEffectLevel(castingImplement, 1);
        final GuiStatBar effectBar = new GuiStatBar(0, 0, StatsHelper.barLength, castingImplementName, 0, 30, false, effectStatGetter, LabelGetterBasic.percentageLabel,
                new TooltipGetterPercentage(castingImplementTooltip, effectStatGetter));
        WorkbenchStatsGui.addBar(effectBar);
        HoloStatsGui.addBar(effectBar);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        StaffArmPose.initializeClientHelper(consumer);
    }
}
