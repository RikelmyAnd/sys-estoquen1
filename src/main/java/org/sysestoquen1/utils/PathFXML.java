package org.sysestoquen1.utils;

import java.nio.file.Paths;

public class PathFXML {
    public static String pathFXML() {
        String path = "src/main/java/org/sysestoquen1/view";
        return Paths.get(path).toAbsolutePath().toString();
    }
}
