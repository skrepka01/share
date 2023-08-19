package com.example.examplemod.cmd;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.network.PacketDispatcher;
import com.example.examplemod.network.packet.PaketAddPlayerPatty;
import com.example.examplemod.utils.Helper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

import java.util.ArrayList;
import java.util.List;

import static com.example.examplemod.ClientProxy.names;

public class AddPlayerToParty extends CommandBase {

    private final String
    name = "addToParty",
    usage = "/addToParty";

    private final Helper helper = new Helper();

    @Override
    public String getCommandName() {
        return name;
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return usage;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length > 1) {
            if (args[0].equals("add")) {
                //-------------------
                /*
                *
                * почему так именно сделалн
                * сервер не знает клиент прокси так-что проще сделать наверное так но я могу быть не прав)))
                *
                */
                List<String> test = new ArrayList<>();
                test.add(sender.getCommandSenderName());
                test.add(args[1]);
                //-------------------
                EntityPlayerMP playerMP = getPlayer(sender, args[1]);
                PacketDispatcher.sendTo(new PaketAddPlayerPatty(test),playerMP);
            }
            if (args[0].equals("clear")) {
                names.clear();
            }
        }
    }

    public List addTabCompletionOptions(ICommandSender sender, String[] args) {
        if (args.length == 1) {
            return getListOfStringsMatchingLastWord(args,"add", "clear");
        }
        if (args.length == 2) {
            return getListOfStringsMatchingLastWord(args, this.getPlayers());
        }
        return null;
    }

    public String[] getPlayers() {
        return MinecraftServer.getServer().getAllUsernames();
    }
}
