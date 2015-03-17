/**
 * 
 */
package com.eop.api.io;

import java.util.List;

/**
 * @author Ravi K
 *
 */

public class Offer {
	
	private String title;
	private String subTitle;
	private String longDescription;
	private String terms;
	private String category;
	private String merchantName;
	private String language;
	private String offerId;
	private String tags;
	private Media media;
	private String price;
	private List<Product> products;
	private List<Geo> sourceGeos;
	private List<RedemptionAddress> RedemptionAddresses;
	private List<String> tagTier;
	private List<String> tagPrice;
	private List<String> tagCategory;
	private String bookingStart;
	private String bookingEnd;
	private String displayStart;
	private String displayEnd;
	private String redemptionTypes;
	
	
	
	/**
     * @return the price
     */
    public String getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }
    /**
	 * @return the media
	 */
	public Media getMedia() {
		return media;
	}
	/**
	 * @param media the media to set
	 */
	public void setMedia(Media media) {
		this.media = media;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	/**
	 * @return the offerId
	 */
	public String getOfferId() {
		return offerId;
	}
	/**
	 * @param offerId the offerId to set
	 */
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the subTitle
	 */
	public String getSubTitle() {
		return subTitle;
	}
	/**
	 * @param subTitle the subTitle to set
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
    /**
     * @return the longDescription
     */
    public String getLongDescription() {
        return longDescription;
    }
    /**
     * @param longDescription the longDescription to set
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
    /**
     * @return the terms
     */
    public String getTerms() {
        return terms;
    }
    /**
     * @param terms the terms to set
     */
    public void setTerms(String terms) {
        this.terms = terms;
    }
	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	/**
	 * @return the sourceGeos
	 */
	public List<Geo> getSourceGeos() {
		return sourceGeos;
	}
	/**
	 * @param sourceGeos the sourceGeos to set
	 */
	public void setSourceGeos(List<Geo> sourceGeos) {
		this.sourceGeos = sourceGeos;
	}
	/**
	 * @return the redemptionAddresses
	 */
	public List<RedemptionAddress> getRedemptionAddresses() {
		return RedemptionAddresses;
	}
	/**
	 * @param redemptionAddresses the redemptionAddresses to set
	 */
	public void setRedemptionAddresses(List<RedemptionAddress> redemptionAddresses) {
		RedemptionAddresses = redemptionAddresses;
	}

	/**
	 * @return the tagTier
	 */
	public List<String> getTagTier() {
		return tagTier;
	}
	/**
	 * @param tagTier the tagTier to set
	 */
	public void setTagTier(List<String> tagTier) {
		this.tagTier = tagTier;
	}
	/**
	 * @return the tagPrice
	 */
	public List<String> getTagPrice() {
		return tagPrice;
	}
	/**
	 * @param tagPrice the tagPrice to set
	 */
	public void setTagPrice(List<String> tagPrice) {
		this.tagPrice = tagPrice;
	}
	/**
	 * @return the tagCategory
	 */
	public List<String> getTagCategory() {
		return tagCategory;
	}
	/**
	 * @param tagCategory the tagCategory to set
	 */
	public void setTagCategory(List<String> tagCategory) {
		this.tagCategory = tagCategory;
	}
	/**
	 * @return the bookingStart
	 */
	public String getBookingStart() {
		return bookingStart;
	}
	/**
	 * @param bookingStart the bookingStart to set
	 */
	public void setBookingStart(String bookingStart) {
		this.bookingStart = bookingStart;
	}
	/**
	 * @return the bookingEnd
	 */
	public String getBookingEnd() {
		return bookingEnd;
	}
	/**
	 * @param bookingEnd the bookingEnd to set
	 */
	public void setBookingEnd(String bookingEnd) {
		this.bookingEnd = bookingEnd;
	}
	/**
	 * @return the redemptionType
	 */
	public String getRedemptionTypes() {
		return redemptionTypes;
	}
	/**
	 * @param redemptionType the redemptionType to set
	 */
	public void setRedemptionTypes(String redemptionTypes) {
		this.redemptionTypes = redemptionTypes;
	} 
	
	/**
	 * @return the displayStart
	 */
	public String getDisplayStart() {
		return displayStart;
	}
	/**
	 * @param displayStart the displayStart to set
	 */
	public void setDisplayStart(String displayStart) {
		this.displayStart = displayStart;
	}
	/**
	 * @return the displayEnd
	 */
	public String getDisplayEnd() {
		return displayEnd;
	}
	/**
	 * @param displayEnd the displayEnd to set
	 */
	public void setDisplayEnd(String displayEnd) {
		this.displayEnd = displayEnd;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Offer [title=" + title + ", subTitle=" + subTitle
				+ ", longDescription=" + longDescription + ", terms=" + terms
				+ ", category=" + category + ", merchantName=" + merchantName
				+ ", language=" + language + ", offerId=" + offerId + ", tags="
				+ tags + ", media=" + media + ", price=" + price
				+ ", products=" + products + ", sourceGeos=" + sourceGeos
				+ ", RedemptionAddresses=" + RedemptionAddresses + ", tagTier="
				+ tagTier + ", tagPrice=" + tagPrice + ", tagCategory="
				+ tagCategory + ", bookingStart=" + bookingStart
				+ ", bookingEnd=" + bookingEnd + ", displayStart="
				+ displayStart + ", displayEnd=" + displayEnd
				+ ", redemptionType=" + redemptionTypes + "]";
	}

	
	
}
