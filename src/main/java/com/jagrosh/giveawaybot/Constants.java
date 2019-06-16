/*
 * Copyright 2017 John Grosh (john.a.grosh@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jagrosh.giveawaybot;

import java.awt.Color;
import java.time.OffsetDateTime;
import java.util.concurrent.TimeUnit;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.TextChannel;
import com.jagrosh.giveawaybot.util.FormatUtil;

/**
 *
 * @author John Grosh (john.a.grosh@gmail.com)
 */
public class Constants {
    private static final Config config = ConfigFactory.load();

    public static final OffsetDateTime STARTUP = OffsetDateTime.now();
    public static final int PRIZE_MAX   = config.getInt("maxprize");
    public static final long SERVER_ID  = config.getLong("serverid");
    public static final String TADA     = "\uD83C\uDF89"; // 🎉
    public static final String WARNING  = "\uD83D\uDCA5"; // 💥
    public static final String ERROR    = "\uD83D\uDCA5"; // 💥
    public static final String YAY      = "<:" + config.getString("yay") + ">";
    public static final String REACTION = config.getString("yay");
    public static final Color  BLURPLE  = Color.decode("#7289DA");
    public static final String INVITE   = "https://giveawaybot.party/invite";
    public static final int MIN_TIME    = ((Long) config.getDuration("mintime", TimeUnit.SECONDS)).intValue();
    public static final int MAX_TIME    = ((Long) config.getDuration("maxtime", TimeUnit.SECONDS)).intValue();
    public static final int MAX_WINNERS = config.getInt("maxwinners");
    public static final int MAX_GIVEAWAYS = config.getInt("maxgiveaways");
    public static final String TIME_MSG = "Giveaway time must not be shorter than "
      + FormatUtil.secondsToTime(Constants.MIN_TIME) + " and no longer than "
      + FormatUtil.secondsToTime(Constants.MAX_TIME);
    public static final String WEBSITE  = "https://giveawaybot.party";
    public static final String OWNER    = config.getString("owner.name");
    public static final String GITHUB   = "https://github.com/jagrosh/GiveawayBot";
    public static final String VERSION  = "2.3";
    public static final String PERMS    = "`Read Messages`, `Write Messages`, `Read Message History`, `Embed Links`, `Use External Emoji`, and `Add Reactions`";
    public static final String OWNER_ID = config.getString("owner.id");

    public static final boolean canSendGiveaway(TextChannel channel)
    {
        return channel.getGuild().getSelfMember().hasPermission(channel, Permission.MESSAGE_READ, Permission.MESSAGE_WRITE,
                Permission.MESSAGE_HISTORY, Permission.MESSAGE_EMBED_LINKS, Permission.MESSAGE_EXT_EMOJI, Permission.MESSAGE_ADD_REACTION);
    }
}
