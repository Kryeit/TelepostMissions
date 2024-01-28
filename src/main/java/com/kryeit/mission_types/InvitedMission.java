package com.kryeit.mission_types;

import com.kryeit.Main;
import com.kryeit.TelepostMissions;
import com.kryeit.missions.MissionDifficulty;
import com.kryeit.missions.MissionManager;
import com.kryeit.missions.MissionType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class InvitedMission implements MissionType {
    private static final Identifier IDENTIFIER = new Identifier(Main.MOD_ID, "invites");

    public static void handleInvite(UUID player) {
        MissionManager.incrementMission(player, InvitedMission.class, IDENTIFIER, 1);
    }

    @Override
    public String id() {
        return "invited";
    }

    @Override
    public MissionDifficulty difficulty() {
        return MissionDifficulty.NORMAL;
    }

    @Override
    public Text description() {
        return Text.literal("Get invited by %s players to their homepost");
    }

    @Override
    public int getProgress(UUID player, Identifier item) {
        return getData(player).getInt("value");
    }

    @Override
    public void reset(UUID player) {
        getData(player).remove("value");
    }

    @Override
    public void increment(int amount, Identifier item, NbtCompound data) {
        data.putInt("value", data.getInt("value") + amount);
    }

    @Override
    public ItemStack getItemStack(Identifier item) {
        return Items.AIR.getDefaultStack();
    }

    @Override
    public ItemStack getPreviewStack(Identifier item) {
        return Items.WRITTEN_BOOK.getDefaultStack();
    }
}
