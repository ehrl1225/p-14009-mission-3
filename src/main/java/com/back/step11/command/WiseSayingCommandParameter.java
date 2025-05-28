package com.back.step11.command;

public class WiseSayingCommandParameter {
    private String name;
    private String value;
    private Boolean isNumeric;

    private void checkValueNumeric(){
        isNumeric = true;
        for (int i =0; i < value.length(); i++){
            char c = value.charAt(i);
            if (!Character.isDigit(c)){
                isNumeric = false;
            }
        }
    }

    public WiseSayingCommandParameter(String name, String value) {
        this.name = name;
        this.value = value;
        checkValueNumeric();
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public int getIntValue() {
        if (isNumeric){
            return Integer.parseInt(value);
        }
        throw new RuntimeException("WiseSayingCommandParameter is not numeric");
    }
}
