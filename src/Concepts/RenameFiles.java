package Concepts;

import java.io.File;
import java.util.Arrays;

public class RenameFiles {
    public static void main(String[] args) {
        String folderPath = "E:\\Chitsheets\\my tutorials\\DSA-JAVA\\SearchAndSortL1";
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Folder does not exist or is not a directory.");
            return;
        }

        File[] files = folder.listFiles(File::isFile);

        if (files == null || files.length == 0) {
            System.out.println("No files found in the folder.");
            return;
        }

        // Sort files by name (optional)
        Arrays.sort(files);

        for (int i = 0; i < files.length; i++) {
            File oldFile = files[i];
            String newFileName = (i + 1) + ".docx";
            File newFile = new File(folderPath + "\\" + newFileName);

            if (oldFile.renameTo(newFile)) {
                System.out.println(oldFile.getName() + " -> " + newFileName);
            } else {
                System.out.println("Failed to rename: " + oldFile.getName());
            }
        }
    }
}

