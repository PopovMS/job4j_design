package ru.job4j.question;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс сравнивает две коллекции и взвращает сколько добавлено, удалено и изменено объектов коллекций
 */
public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        HashSet<User> prevList = new HashSet<>(previous);
        HashSet<User> curList = new HashSet<>(current);
        prevList.removeAll(curList);
        curList.removeAll(previous);
        HashSet<User> prevTemp = new HashSet<>(prevList);
        HashSet<User> currTemp = new HashSet<>(current);
        for (User mUser : prevTemp) {
            for (User pUser : currTemp) {
                if (mUser.getId() == pUser.getId()) {
                    prevList.remove(mUser);
                    curList.remove(pUser);
                    info.setChanged(info.getChanged() + 1);
                }
            }
        }
        info.setAdded(curList.size());
        info.setDeleted(prevList.size());

            return info;
    }
}