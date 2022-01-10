package ru.job4j.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
        Map<Object, Object> prevTemp = prevList.stream().collect(Collectors.toMap(k -> k.getId(), v -> v.getName()));
        Map<Object, Object> currTemp = curList.stream().collect(Collectors.toMap(k -> k.getId(), v -> v.getName()));

        for (Object key : prevTemp.keySet()) {
            if (currTemp.containsKey(key)) {
                currTemp.remove(key);
                info.setChanged(info.getChanged() + 1);
            } else {
                info.setDeleted(info.getDeleted() + 1);
            }
        }

        info.setAdded(currTemp.size());

            return info;
    }
}