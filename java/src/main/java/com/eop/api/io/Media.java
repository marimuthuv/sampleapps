/**
 * 
 */
package com.eop.api.io;

/**
 * @author Ravi K
 *
 */
public class Media {

	private String offerImageUrl;
	private String offerImageAltText;
	private String merchantImageUrl;
	private String merchantAltText;
	

	/**
	 * @return the offerImageAltText
	 */
	public String getOfferImageAltText() {
		return offerImageAltText;
	}

	/**
	 * @param offerImageAltText the offerImageAltText to set
	 */
	public void setOfferImageAltText(String offerImageAltText) {
		this.offerImageAltText = offerImageAltText;
	}

	/**
	 * @return the offerImageUrl
	 */
	public String getOfferImageUrl() {
		return offerImageUrl;
	}

	/**
	 * @param offerImageUrl the offerImageUrl to set
	 */
	public void setOfferImageUrl(String offerImageUrl) {
		this.offerImageUrl = offerImageUrl;
	}

    /**
     * @return the merchantImageUrl
     */
    public String getMerchantImageUrl() {
        return merchantImageUrl;
    }

    /**
     * @param merchantImageUrl the merchantImageUrl to set
     */
    public void setMerchantImageUrl(String merchantImageUrl) {
        this.merchantImageUrl = merchantImageUrl;
    }

    /**
     * @return the merchantAltText
     */
    public String getMerchantAltText() {
        return merchantAltText;
    }

    /**
     * @param merchantAltText the merchantAltText to set
     */
    public void setMerchantAltText(String merchantAltText) {
        this.merchantAltText = merchantAltText;
    }
	
}
