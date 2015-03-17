package com.eop.api.io;

import java.io.Serializable;
import java.util.HashMap;

public enum ReachType implements Serializable {

    GLOBAL(1), REGIONAL(2), COUNTRY(3), STATE(4), DMA(5), CITY(6), ZIP(7);

    private int reachType;

    private ReachType(int reachType) {
        this.reachType = reachType;
    }

    public int getValue() {
        return reachType;
    }
    
    public final static HashMap<Integer, String> enumMap = new HashMap<Integer, String>();
    
    static {
       for(ReachType reachType : ReachType.values()) {
              enumMap.put(reachType.getValue(), reachType.toString());
       }
    }

    public static String getString(Integer i) {

       return enumMap.get(i);

    }
}
