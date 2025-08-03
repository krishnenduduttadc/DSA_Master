package DesignPatternL2;

public class MementoPatternDemo {

    // Caretaker
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.set("Version 1");
        Memento saved = editor.save();

        editor.set("Version 2");
        System.out.println("Current: " + editor.get());

        editor.restore(saved);
        System.out.println("Restored: " + editor.get());
    }

    // Memento
    static class Memento {
        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    // Originator
    static class Editor {
        private String content;

        public void set(String content) {
            this.content = content;
        }

        public String get() {
            return content;
        }

        public Memento save() {
            return new Memento(content);
        }

        public void restore(Memento memento) {
            this.content = memento.getState();
        }
    }
}

