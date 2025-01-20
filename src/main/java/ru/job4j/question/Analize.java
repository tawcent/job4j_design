package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, User> previousMap = new HashMap<>();
        for (User user : previous) {
            previousMap.put(user.getId(), user);
        }

        int added = 0;
        int changed = 0;
        int deleted = 0;

        for (User user : current) {
            User prevUser = previousMap.remove(user.getId());
            if (prevUser == null) {
                added++;
            } else if (!prevUser.getName().equals(user.getName())) {
                changed++;
            }
        }
        deleted = previousMap.size();
        return new Info(added, changed, deleted);
    }
}
