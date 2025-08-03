package DesignPatternL1;

import java.util.HashMap;
import java.util.Map;

public class FlyweightDP {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();

        // Render characters using flyweight objects
        Character charA = characterFactory.getCharacter('A');
        charA.render("Arial", 12);

        Character charB = characterFactory.getCharacter('B');
        charB.render("Times New Roman", 14);

        Character charA2 = characterFactory.getCharacter('A');
        charA2.render("Arial", 12);
    }

    // Flyweight interface
    public interface Character {
        void render(String font, int size);
    }

    // Concrete flyweight class
    public static class CharacterImpl implements Character {
        private java.lang.Character character; // Using fully qualified name

        public CharacterImpl(java.lang.Character character) {
            this.character = character;
        }

        @Override
        public void render(String font, int size) {
            System.out.println("Character '" + character + "' rendered with font '" + font + "' and size " + size);
        }
    }

    // Flyweight factory
    public static class CharacterFactory {
        private Map<java.lang.Character, CharacterImpl> characterMap = new HashMap<>(); // Using fully qualified name

        public Character getCharacter(char character) {
            java.lang.Character characterKey = character; // Using fully qualified name
            if (!characterMap.containsKey(characterKey)) {
                characterMap.put(characterKey, new CharacterImpl(characterKey));
            }
            return characterMap.get(characterKey);
        }
    }
}
