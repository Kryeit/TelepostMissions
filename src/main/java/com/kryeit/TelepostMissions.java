package com.kryeit;

import com.kryeit.mission_types.InviteMission;
import com.kryeit.mission_types.InvitedMission;
import com.kryeit.missions.MissionTypeRegistry;
import net.fabricmc.api.DedicatedServerModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TelepostMissions implements DedicatedServerModInitializer {

	public static final String ID = "telepostmissions";
    public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	@Override
	public void onInitializeServer() {
		LOGGER.info("Loading Create: Missions addon -> Telepost Missions");

		// Register mission types
		MissionTypeRegistry.INSTANCE.register(new InviteMission());
		MissionTypeRegistry.INSTANCE.register(new InvitedMission());
	}
}