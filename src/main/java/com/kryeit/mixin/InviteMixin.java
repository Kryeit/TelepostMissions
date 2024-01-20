package com.kryeit.mixin;

import com.kryeit.mission_types.InviteMission;
import com.kryeit.mission_types.InvitedMission;
import com.kryeit.telepost.MinecraftServerSupplier;
import com.kryeit.telepost.Telepost;
import com.kryeit.telepost.commands.Invite;
import com.kryeit.telepost.commands.Visit;
import com.kryeit.telepost.storage.bytes.HomePost;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(value = Invite.class, remap = false)
public class InviteMixin {

    @Inject(method = "execute", at = @At("HEAD"))
    private static void onExecute(CommandContext<ServerCommandSource> context, String name, CallbackInfoReturnable<Integer> cir) {
        ServerPlayerEntity player = context.getSource().getPlayer();
        ServerPlayerEntity invited = MinecraftServerSupplier.getServer().getPlayerManager().getPlayer(name);

        if (player == null || invited == null) return;

        Optional<HomePost> home = Telepost.getDB().getHome(player.getUuid());
        if (home.isEmpty()) return;

        InviteMission.handleInvite(player.getUuid());
        InvitedMission.handleInvite(invited.getUuid());
    }
}
