package com.eop.api.io;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@SuppressWarnings("serial")
@XmlRootElement
public class Geo implements Serializable{
	//Transient fields
	private ReachType reachType = ReachType.GLOBAL;
	private Integer geoNameId;
	private String timeZone;
	private List<String> alternateNames;
	//XML/JSON fields
	private GeoAttribute city;
	private GeoAttribute administrativeAreaLevel1;
	private GeoAttribute administrativeAreaLevel2;
	private GeoAttribute administrativeAreaLevel3;
	private GeoAttribute country;
	private GeoAttribute region;
	private String postalCode;
	private Float latitude;
	private Float longitude;
	
	
	@XmlElement(name = "City")
	public GeoAttribute getCity() {
		return city;
	}
	
	public void setCity(GeoAttribute city) {
		this.city = city;
		if(this.reachType.getValue()<ReachType.CITY.getValue()){ 
			setReachType(ReachType.CITY);
		}
	}	
	public GeoAttribute getAdministrativeAreaLevel1() {
		return administrativeAreaLevel1;
	}
	public void setAdministrativeAreaLevel1(GeoAttribute administrativeAreaLevel1) {
		this.administrativeAreaLevel1 = administrativeAreaLevel1;
		if(this.reachType.getValue()<ReachType.STATE.getValue()){ 
			setReachType(ReachType.STATE);
		}
	}
	public GeoAttribute getAdministrativeAreaLevel2() {
		return administrativeAreaLevel2;
	}
	public void setAdministrativeAreaLevel2(GeoAttribute administrativeAreaLevel2) {
		this.administrativeAreaLevel2 = administrativeAreaLevel2;
	}
	public GeoAttribute getAdministrativeAreaLevel3() {
		return administrativeAreaLevel3;
	}
	public void setAdministrativeAreaLevel3(GeoAttribute administrativeAreaLevel3) {
		this.administrativeAreaLevel3 = administrativeAreaLevel3;
	}
	
	@XmlElement(name = "Country")
	public GeoAttribute getCountry() {
		return country;
	}
	
	public void setCountry(GeoAttribute country) {
		this.country = country;
		if(this.reachType.getValue()<ReachType.COUNTRY.getValue()){ 
			setReachType(ReachType.COUNTRY);
		}
	}
	
	@XmlElement(name = "Region")
	public GeoAttribute getRegion() {
		return region;
	}
	
	public void setRegion(GeoAttribute region) {
		this.region = region;
		if(this.reachType.getValue()<ReachType.REGIONAL.getValue()){ 
			setReachType(ReachType.REGIONAL);
		}		
	}
	
	@XmlElement(name = "PostalCode")
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		if(this.reachType.getValue()<ReachType.ZIP.getValue()){ 
			setReachType(ReachType.ZIP);
		}
	}
	
	@XmlElement(name = "Latitude")
	public Float getLatitude() {
		return latitude;
	}
	
	
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
		/*if(this.reachType.getValue()<ReachType.DMA.getValue()){ 
			setReachType(ReachType.DMA);
		}*/
	}
	
	@XmlElement(name = "Longitude")
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
		/*if(this.reachType.getValue()<ReachType.DMA.getValue()){ 
			setReachType(ReachType.DMA);
		}*/
	}
	public ReachType getReachType() {
		return reachType;
	}
	@XmlTransient
	public void setReachType(ReachType reachType) {
		this.reachType = reachType ;
	}
	
	public Integer getGeoNameId() {
		return geoNameId;
	}
	
	public void setGeoNameId(Integer geoNameId) {
		this.geoNameId = geoNameId;
	}
	public String getTimeZone() {
		return timeZone;
	}
	@XmlTransient
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public List<String> getAlternateNames() {
		return alternateNames;
	}
	@XmlTransient
	public void setAlternateNames(List<String> alternateNames) {
		this.alternateNames = alternateNames;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Geo: {reachType:").append(reachType).append(", city:")
				.append(city).append(", administrativeAreaLevel1:")
				.append(administrativeAreaLevel1)
				.append(", administrativeAreaLevel2:")
				.append(administrativeAreaLevel2)
				.append(", administrativeAreaLevel3:")
				.append(administrativeAreaLevel3).append(", country:")
				.append(country).append(", region:").append(region)
				.append(", postalCode:").append(postalCode)
				.append(", latitude:").append(latitude).append(", longitude:")
				.append(longitude).append("}");
		return builder.toString();
	}
	
	
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((administrativeAreaLevel1 == null) ? 0 : administrativeAreaLevel1.hashCode());
        result = prime * result + ((administrativeAreaLevel2 == null) ? 0 : administrativeAreaLevel2.hashCode());
        result = prime * result + ((administrativeAreaLevel3 == null) ? 0 : administrativeAreaLevel3.hashCode());
        result = prime * result + ((alternateNames == null) ? 0 : alternateNames.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((geoNameId == null) ? 0 : geoNameId.hashCode());
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
        result = prime * result + ((reachType == null) ? 0 : reachType.hashCode());
        result = prime * result + ((region == null) ? 0 : region.hashCode());
        result = prime * result + ((timeZone == null) ? 0 : timeZone.hashCode());
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
        Geo other = (Geo) obj;
        if (administrativeAreaLevel1 == null) {
            if (other.administrativeAreaLevel1 != null) return false;
        } else if (!administrativeAreaLevel1.equals(other.administrativeAreaLevel1)) return false;
        if (administrativeAreaLevel2 == null) {
            if (other.administrativeAreaLevel2 != null) return false;
        } else if (!administrativeAreaLevel2.equals(other.administrativeAreaLevel2)) return false;
        if (administrativeAreaLevel3 == null) {
            if (other.administrativeAreaLevel3 != null) return false;
        } else if (!administrativeAreaLevel3.equals(other.administrativeAreaLevel3)) return false;
        if (alternateNames == null) {
            if (other.alternateNames != null) return false;
        } else if (!alternateNames.equals(other.alternateNames)) return false;
        if (city == null) {
            if (other.city != null) return false;
        } else if (!city.equals(other.city)) return false;
        if (country == null) {
            if (other.country != null) return false;
        } else if (!country.equals(other.country)) return false;
        if (geoNameId == null) {
            if (other.geoNameId != null) return false;
        } else if (!geoNameId.equals(other.geoNameId)) return false;
        if (latitude == null) {
            if (other.latitude != null) return false;
        } else if (!latitude.equals(other.latitude)) return false;
        if (longitude == null) {
            if (other.longitude != null) return false;
        } else if (!longitude.equals(other.longitude)) return false;
        if (postalCode == null) {
            if (other.postalCode != null) return false;
        } else if (!postalCode.equals(other.postalCode)) return false;
        if (reachType != other.reachType) return false;
        if (region == null) {
            if (other.region != null) return false;
        } else if (!region.equals(other.region)) return false;
        if (timeZone == null) {
            if (other.timeZone != null) return false;
        } else if (!timeZone.equals(other.timeZone)) return false;
        return true;
    }
  
	
	
}

