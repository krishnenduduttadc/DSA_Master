package DesignPatternL2;

public class AdapterPatternDemo {

    // Main method
    public static void main(String[] args) {
        OldCharger oldCharger = new OldCharger();
        NewCharger adapter = new ChargerAdapter(oldCharger);

        Mobile phone = new Mobile(adapter);
        phone.plugIn();
    }

    // Target interface
    interface NewCharger {
        void chargePhone();
    }

    // Adaptee (incompatible interface)
    static class OldCharger {
        public void oldCharge() {
            System.out.println("Charging phone using Old Charger...");
        }
    }

    // Adapter class
    static class ChargerAdapter implements NewCharger {
        private OldCharger oldCharger;

        public ChargerAdapter(OldCharger oldCharger) {
            this.oldCharger = oldCharger;
        }

        @Override
        public void chargePhone() {
            oldCharger.oldCharge(); // delegate call
        }
    }

    // Client
    static class Mobile {
        private NewCharger charger;

        public Mobile(NewCharger charger) {
            this.charger = charger;
        }

        public void plugIn() {
            charger.chargePhone();
        }
    }
}

