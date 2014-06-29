package com.mLab.geometric.file;

/**
 * Created by aram on 6/29/14.
 */
public enum SearchTypes {

    SEARCH_BY_NAME("SearchByName"),
    SEARCH_BY_NONE(""),
    SEARCH_BY_PATH("SearchByPath");

    private String typeValue;

    private SearchTypes(String type) {
        typeValue = type;
    }

    static public SearchTypes getType(String pType) {
        for (SearchTypes type: SearchTypes.values()) {
            if (type.getTypeValue().equals(pType)) {
                return type;
            }
        }
        throw new RuntimeException("Unknown Search Type");
    }

    public String getTypeValue() {
        return typeValue;
    }
}
