package DesignPatternL2;

import java.util.ArrayList;
import java.util.List;

public class CompositePatternDemo {

    // Main method
    public static void main(String[] args) {
        File file1 = new File("Resume.pdf");
        File file2 = new File("CoverLetter.docx");

        Folder documents = new Folder("Documents");
        documents.add(file1);
        documents.add(file2);

        Folder root = new Folder("Root");
        root.add(documents);
        root.add(new File("ReadMe.txt"));

        root.show();
    }

    // Component
    interface FileSystem {
        void show();
    }

    // Leaf
    static class File implements FileSystem {
        private String name;

        public File(String name) {
            this.name = name;
        }

        @Override
        public void show() {
            System.out.println("File: " + name);
        }
    }

    // Composite
    static class Folder implements FileSystem {
        private String name;
        private List<FileSystem> children = new ArrayList<>();

        public Folder(String name) {
            this.name = name;
        }

        public void add(FileSystem fs) {
            children.add(fs);
        }

        @Override
        public void show() {
            System.out.println("Folder: " + name);
            for (FileSystem fs : children) {
                fs.show();
            }
        }
    }
}

