package com.example.examplemod.utils;

import net.minecraft.server.MinecraftServer;

import static com.example.examplemod.ClientProxy.copied;
import static com.example.examplemod.ClientProxy.names;

public class Helper implements Helpers {
    @Override
    public String[] getAllPlayerInServer() {
        return MinecraftServer.getServer().getAllUsernames();
    }

    @Override
    public void isConnection(String name) {
        checkConnection(name);
    }

    @Override
    public void checkPlayerOnServer() {

    }

    public void checkConnection(String name) {
        for(String s : getAllPlayerInServer()) { // проверяем кто находится на сервере
            if(name.equals(s)) { // если имя совпадает с тем,кто на сервере
                for(String s1 : names) { // пробегаем по циклу и проверяем нет ли этого игрока уже в пати
                    if(name.equals(s1)) { // если есть он - рвём цикл
                        return;
                    }else {
                        names.add(name); // иначе доабвляем
                        copied.addAll(names);
                    }
                }
                return;

            } else return;
        }

    }
}
