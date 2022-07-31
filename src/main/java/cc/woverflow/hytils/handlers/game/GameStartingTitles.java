/*
 * Hytils Reborn - Hypixel focused Quality of Life mod.
 * Copyright (C) 2020, 2021, 2022  Polyfrost, Sk1er LLC and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package cc.woverflow.hytils.handlers.game;

import cc.polyfrost.oneconfig.utils.hypixel.HypixelUtils;
import cc.woverflow.hytils.config.HytilsConfig;
import cc.woverflow.hytils.events.TitleEvent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GameStartingTitles {
    // Hides the countdown timer title text that is displayed before a game is about to start and other titles
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onTitle(TitleEvent event) {
        if (!HypixelUtils.INSTANCE.isHypixel() || !HytilsConfig.hideGameStartingTitles) {
            return;
        }

        switch (EnumChatFormatting.getTextWithoutFormattingCodes(event.getTitle())) {
            case "10 seconds":
            case "10":
            case "5":
            case "4":
            case "3":
            case "2":
            case "1":
            case "Waiting for more players...":
            case "SkyWars":
            case "INSANE MODE":
            case "Fight!":
            case "Zombies":
            case "ASSASSINS":
            case "YOU ARE RED":
            case "YOU ARE BLUE":
            case "YOU ARE YELLOW":
            case "YOU ARE GREEN":
            case "PRE ROUND":
            case "ROUND START":
            case "❸":
            case "❷":
            case "❶":
                event.setCanceled(true);
                break;
        }
    }
}
