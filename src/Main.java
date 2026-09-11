class Pizza {
    private final String size;
    private final boolean cheese;
    private final boolean mushrooms;
    private final boolean pepperoni;
    private final boolean olives;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.mushrooms = builder.mushrooms;
        this.pepperoni = builder.pepperoni;
        this.olives = builder.olives;
    }

    static class Builder {
        private final String size;
        private boolean cheese = false;
        private boolean mushrooms = false;
        private boolean pepperoni = false;
        private boolean olives = false;

        Builder(String size) {
            this.size = size;
        }

        Builder cheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        Builder mushrooms(boolean mushrooms) {
            this.mushrooms = mushrooms;
            return this;
        }

        Builder pepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        Builder olives(boolean olives) {
            this.olives = olives;
            return this;
        }

        Pizza build() {
            return new Pizza(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Пицца размера ").append(size);
        if (cheese) sb.append(" с сыром");
        if (mushrooms) sb.append(" с грибами");
        if (pepperoni) sb.append(" с пепперони");
        if (olives) sb.append(" с оливками");
        return sb.toString();
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();

        Pizza pizza1 = new Pizza.Builder("Средняя")
                .cheese(true)
                .mushrooms(true)
                .build();

        Pizza pizza2 = new Pizza.Builder("Большая")
                .cheese(true)
                .pepperoni(true)
                .olives(true)
                .build();

        System.out.println(pizza1);
        System.out.println(pizza2);
    }
}