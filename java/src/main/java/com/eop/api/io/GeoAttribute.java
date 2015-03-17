package com.eop.api.io;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

@SuppressWarnings("serial")
public class GeoAttribute implements Serializable{

    protected String code;
    
    protected String displayText;

    public GeoAttribute() {
		super();
	}

	public GeoAttribute(String code) {
		this.code = code;
	}
	public GeoAttribute(String code,String displayText) {
		this.code = code;
		this.displayText = displayText;
	}

	public String getCode() {
        return code;
    }
	@XmlAttribute
    public void setCode(String value) {
        this.code = value;
    }

    public String getDisplayText() {
        return displayText;
    }
    @XmlAttribute
    public void setDisplayText(String value) {
        this.displayText = value;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeoAttribute: {code:").append(code)
				.append(", displayText:").append(displayText).append("}");
		return builder.toString();
	}

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((displayText == null) ? 0 : displayText.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        GeoAttribute other = (GeoAttribute) obj;
        if (code == null) {
            if (other.code != null) return false;
        } else if (!code.equals(other.code)) return false;
        if (displayText == null) {
            if (other.displayText != null) return false;
        } else if (!displayText.equals(other.displayText)) return false;
        return true;
    }
	
	
}