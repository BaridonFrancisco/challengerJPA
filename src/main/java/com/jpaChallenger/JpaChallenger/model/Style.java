package com.jpaChallenger.JpaChallenger.model;

public enum Style {
    ROCK("rock"),
    POP("pop"),
    CUMBIA("cumbia"),
    REGUETON("regueton"),
    FOLKLORE("folklore"),
    CLASICO("clasico"),
    DESCONOCIDO("desconocido");

    private String value;

    Style(String value){
        this.value=value;
    }

    public static Style fromStyle(String style){
        for(Style styleEnum:Style.values()){
            if(styleEnum.value.equalsIgnoreCase(style)){
                return styleEnum;
            }
        }
        return Style.DESCONOCIDO;
        //throw new UnsupportedOperationException("Opereancion no realizada");
    }


    public String getStyle(){
        return this.value;
    }

}
