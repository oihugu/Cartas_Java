
public class Carta {

    private String suit;
    private String value;
    private Boolean isJoker;
    
    public Carta(String value, String suit) {
        this.isJoker = false;
        this.value = value.toLowerCase();
        this.suit = suit.toLowerCase();
    }

    public Carta() {
        this.isJoker = true;
        this.value = "0";
        this.suit = "";
    }

    // Getters
    public String getsuit() {
        return this.suit;
    }

    public String getvalue() {
        return this.value;
    }

    public Boolean getIsJoker() {
        return this.isJoker;
    }

    public int getCardValue() {
        if (this.value.equals("as")) {
            return 1;
        } else if (this.value.equals("valete")) {
            return 11;
        } else if (this.value.equals("dama")){
            return 12;
        } else if (this.value.equals("rei")){
            return 13;
        } else if (this.value.equals("curinga")){
            return 0;
        }else {
            return Integer.parseInt(this.value);
        }
    }

    public String getCardName() {
        String captalizedValue;
        if (this.value.equals("as") || this.value.equals("valete") || this.value.equals("dama") || this.value.equals("rei") || this.value.equals("0")) {
            // Normalmente usaria uma lista para isso, mas não sabia se era permitido
            if (this.isJoker){
                captalizedValue = "Curinga";
                return captalizedValue;
            } else {
                captalizedValue = this.value.substring(0, 1).toUpperCase() + this.value.substring(1);
                return captalizedValue + " de " + this.suit;
            }
        }
        else{
            captalizedValue = this.value;
            return captalizedValue + " de " + this.suit;
        }

        
    }
    
    // Setters
    public void setsuit(String suit) {
        this.suit = suit;
    }

    public void setvalue(String value) {
        this.value = value;
    }

    public void setIsJoker(Boolean isJoker) {
        this.isJoker = isJoker;
        if (isJoker) {
            this.value = "curinga";
            this.suit = "";
        }
        else {
            this.value = "";
        }
    }

    // Others

    public int compare(Carta other) {
        if (this.getCardValue() > other.getCardValue()) {
            return 1;
        } else if (this.getCardValue() < other.getCardValue()) {
            return -1;
        } else {
            return 0;
        }
    }
}
