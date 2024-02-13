package com.kryeit.mission_types;

import com.kryeit.Missions;
import com.kryeit.missions.MissionDifficulty;
import com.kryeit.missions.MissionManager;
import com.kryeit.missions.MissionType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class InviteMission implements MissionType {
    private static final Identifier IDENTIFIER = Missions.asResource("invites");

    public static void handleInvite(UUID player) {
        MissionManager.incrementMission(player, InviteMission.class, IDENTIFIER, 1);
    }

    @Override
    public String id() {
        return "invite";
    }

    @Override
    public MissionDifficulty difficulty() {
        return MissionDifficulty.EASY;
    }

    @Override
    public Text description() {
        return Text.literal("Invite %s players to your home post");
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
        return Items.WRITABLE_BOOK.getDefaultStack();
    }
}
