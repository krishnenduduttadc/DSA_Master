package LowLevelDesign;

public class BuilderDP {
    public static class House {
        private String foundation;
        private String structure;
        private String roof;
        private String interior;

        // Private constructor to enforce the use of the builder
        private House(Builder builder) {
            this.foundation = builder.foundation;
            this.structure = builder.structure;
            this.roof = builder.roof;
            this.interior = builder.interior;
        }

        @Override
        public String toString() {
            return "House [foundation=" + foundation + ", structure=" + structure +
                    ", roof=" + roof + ", interior=" + interior + "]";
        }

        // Static nested Builder class
        public static class Builder {
            private String foundation;
            private String structure;
            private String roof;
            private String interior;

            // Builder methods for setting properties
            public Builder setFoundation(String foundation) {
                this.foundation = foundation;
                return this;
            }

            public Builder setStructure(String structure) {
                this.structure = structure;
                return this;
            }

            public Builder setRoof(String roof) {
                this.roof = roof;
                return this;
            }

            public Builder setInterior(String interior) {
                this.interior = interior;
                return this;
            }

            // Method to build the final House object
            public House build() {
                return new House(this);
            }
        }
    }


    public static void main(String[] args) {
        // Use the builder to create a House object
        House house = new House.Builder()
                .setFoundation("Concrete")
                .setStructure("Wood")
                .setRoof("Tiles")
                .setInterior("Modern")
                .build();

        System.out.println(house);
    }
}
