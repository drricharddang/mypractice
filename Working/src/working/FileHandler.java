package working;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class FileHandler {
    File file;

    FileHandler (File file) {
        this.file = file;
    }
    static void printFileContent (File file) {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    static void deleteDirRecursively(File dir) {
        File[] children = dir.listFiles();
        for (File child : children) {
            if (child.isDirectory()) {
                deleteDirRecursively(child);
            } else {
                child.delete();
            }
        }

        dir.delete();
    }

    String deepestPath = "";
    int deepestLevel = 0;

    File findDeepestObj(File obj, int level) {
        boolean isDeepestForThisBranch = false;

        for (File f: obj.listFiles()) {
            if (f.isDirectory() && f.listFiles().length > 0) {
                level++;
                findDeepestObj(f, level);
            } else {
                if (level > deepestLevel) {
                    deepestLevel = level;
                    deepestPath = f.getPath();
                }
                continue;
            }
        }

        return new File(deepestPath);
    }
}